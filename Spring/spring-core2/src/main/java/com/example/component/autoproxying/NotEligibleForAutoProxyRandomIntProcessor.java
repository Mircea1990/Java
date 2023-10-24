package com.example.component.autoproxying;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.lang.NonNull;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;

// This class implements the BeanPostProcessor interface which allows for custom modification of
// new bean instances.
public class NotEligibleForAutoProxyRandomIntProcessor implements BeanPostProcessor {
    // A private final instance of RandomIntGenerator.
    private final RandomIntGenerator randomIntGenerator;

    // The constructor for this class. It initializes the randomIntGenerator.
    public NotEligibleForAutoProxyRandomIntProcessor(RandomIntGenerator randomIntGenerator) {
        this.randomIntGenerator = randomIntGenerator;
    }

    // This static method takes an Object and a RandomIntGenerator as parameters and returns an
    // Object.
    // It gets all declared fields of the bean's class and checks each field for the presence of
    // the RandomInt annotation.
    // If the annotation is present, it generates a random value within the specified range and
    // sets it to the field.
    static Object getObject(Object bean, RandomIntGenerator randomIntGenerator) {
        Field[] fields = bean.getClass().getDeclaredFields();
        for (Field field : fields) {
            RandomInt injectRandomInt = field.getAnnotation(RandomInt.class);
            if (injectRandomInt != null) {
                int min = injectRandomInt.min();
                int max = injectRandomInt.max();
                int randomValue = randomIntGenerator.generate(min, max);
                field.setAccessible(true);
                ReflectionUtils.setField(field, bean, randomValue);
            }
        }
        return bean;
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

