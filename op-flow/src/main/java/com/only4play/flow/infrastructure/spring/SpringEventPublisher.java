package com.only4play.flow.infrastructure.spring;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class SpringEventPublisher implements ApplicationContextAware {

    private static ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        SpringEventPublisher.applicationContext = applicationContext;
    }

    public static void publishEvent(Object event) {
        SpringEventPublisher.applicationContext.publishEvent(event);
    }
}