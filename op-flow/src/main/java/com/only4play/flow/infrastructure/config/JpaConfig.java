package com.only4play.flow.infrastructure.config;

import javax.persistence.EntityManager;

import com.querydsl.jpa.impl.JPAQueryFactory;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JpaConfig {

    @Bean
    public JPAQueryFactory jpaQuery(EntityManager entityManager) {
        return new JPAQueryFactory(entityManager);
    }

}