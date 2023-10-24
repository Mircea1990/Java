package com.example.component.autoproxying;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Lazy;
import org.springframework.lang.NonNull;

import static com.example.component.autoproxying.NotEligibleForAutoProxyRandomIntProcessor.getObject;

// This class implements the BeanPostProcessor interface which allows for custom modification of
// new bean instances.
public class EligibleForAutoProxyRandomIntProcessor implements BeanPostProcessor {
    // A private final instance of RandomIntGenerator.
    private final RandomIntGenerator randomIntGenerator;

    // The @Lazy annotation indicates that a bean is to be lazily initialized.
    // The constructor for this class. It initializes the randomIntGenerator.
    @Lazy public EligibleForAutoProxyRandomIntProcessor(RandomIntGenerator randomIntGenerator) {
        this.randomIntGenerator = randomIntGenerator;
    }

    // This method is overridden from the BeanPostProcessor interface.
    // It takes in an Object and a String as parameters and returns an Object.
    // It is called before a bean's initialization method.
    @Override public Object postProcessBeforeInitialization(@NonNull Object bean,
                                                            @NonNull String beanName)
            throws BeansException {
        // It calls the getObject method with the bean and randomIntGenerator as parameters.
        return getObject(bean, randomIntGenerator);
    }
}

