package com.example.beanpostprocessor;

import com.google.common.eventbus.EventBus;

import java.util.function.BiConsumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.framework.Advised;
import org.springframework.aop.support.AopUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.FatalBeanException;
import org.springframework.beans.factory.config.DestructionAwareBeanPostProcessor;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionException;
import org.springframework.expression.spel.standard.SpelExpressionParser;

/**
 * A {@link DestructionAwareBeanPostProcessor} which registers/un-registers subscribers to a Guava
 * {@link EventBus}. The class must be annotated with {@link Subscriber} and each subscribing method
 * must be annotated with {@link com.google.common.eventbus.Subscribe}.
 */
// Suppress all warnings
@SuppressWarnings("ALL") public class GuavaEventBusBeanPostProcessor
        implements DestructionAwareBeanPostProcessor {
    // Logger for this class
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    // Parser for SpEL expressions
    private final SpelExpressionParser expressionParser = new SpelExpressionParser();

    // Method to process the bean before its destruction
    @Override public void postProcessBeforeDestruction(final Object bean, final String beanName)
            throws BeansException {
        // Unregister the bean from the EventBus before its destruction
        this.process(bean, EventBus::unregister, "destruction");
    }

    // Method to check if a bean requires destruction
    @Override public boolean requiresDestruction(Object bean) {
        // All beans require destruction in this implementation
        return true;
    }

    // Method to process the bean before its initialization
    @Override public Object postProcessBeforeInitialization(final Object bean,
                                                            final String beanName)
            throws BeansException {
        // No processing is done before initialization in this implementation, so just return the
        // bean as is
        return bean;
    }

    // Method to process the bean after its initialization
    @Override public Object postProcessAfterInitialization(final Object bean, final String beanName)
            throws BeansException {
        // Register the bean with the EventBus after its initialization
        this.process(bean, EventBus::register, "initialization");
        return bean;
    }

    // Private method to process a bean with a given consumer (either register or unregister it
    // with an EventBus)
    private void process(final Object bean,
                         final BiConsumer<EventBus, Object> consumer,
                         final String action) {
        // Get the target object of the bean (in case it's a JDK dynamic proxy)
        Object proxy = this.getTargetObject(bean);
        // Get the Subscriber annotation of the current bean's class
        final Subscriber annotation = AnnotationUtils.getAnnotation(proxy.getClass(),
                                                                    Subscriber.class);
        // If there is no Subscriber annotation, skip this bean
        if (annotation == null)
            return;
        // Log that we are processing this bean during either initialization or destruction
        this.logger.info("{}: processing bean of type {} during {}",
                         this.getClass().getSimpleName(), proxy.getClass().getName(), action);
        // Get the value of the Subscriber annotation
        final String annotationValue = annotation.value();
        try {
            // Parse and evaluate the annotation value as a SpEL expression
            final Expression expression = this.expressionParser.parseExpression(annotationValue);
            final Object value = expression.getValue();
            // If the evaluated value is not an EventBus, log an error and return
            if (!(value instanceof EventBus)) {
                this.logger.error(
                        "{}: expression {} did not evaluate to an instance of EventBus for bean " +
                        "of type {}",
                        this.getClass().getSimpleName(), annotationValue,
                        proxy.getClass().getSimpleName());
                return;
            }
            // Apply the consumer (either register or unregister) to the evaluated EventBus and
            // the current bean
            final EventBus eventBus = (EventBus) value;
            consumer.accept(eventBus, proxy);
        } catch (ExpressionException ex) {
            // Log an error if we were unable to parse/evaluate the expression
            this.logger.error("{}: unable to parse/evaluate expression {} for bean of type {}",
                              this.getClass().getSimpleName(), annotationValue,
                              proxy.getClass().getName());
        }
    }

    // Method to get the target object of a JDK dynamic proxy, or return the object itself if it
    // is not a proxy
    private Object getTargetObject(Object proxy) throws BeansException {
        if (AopUtils.isJdkDynamicProxy(proxy)) {
            try {
                return ((Advised) proxy).getTargetSource().getTarget();
            } catch (Exception e) {
                throw new FatalBeanException("Error getting target of JDK proxy", e);
            }
        }
        return proxy;
    }
}
