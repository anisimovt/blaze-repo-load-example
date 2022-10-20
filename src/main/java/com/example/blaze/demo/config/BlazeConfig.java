package com.example.blaze.demo.config;

import com.blazebit.persistence.Criteria;
import com.blazebit.persistence.CriteriaBuilderFactory;
import com.blazebit.persistence.integration.view.spring.EnableEntityViews;
import com.blazebit.persistence.spi.CriteriaBuilderConfiguration;
import com.blazebit.persistence.spring.data.impl.repository.BlazePersistenceRepositoryFactoryBean;
import com.blazebit.persistence.view.EntityViewManager;
import com.blazebit.persistence.view.spi.EntityViewConfiguration;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

@Configuration
@EnableEntityViews(basePackages = "com.example.blaze.demo.view")
@EnableJpaRepositories(
        repositoryFactoryBeanClass = BlazePersistenceRepositoryFactoryBean.class,
        basePackages = "com.example.blaze.demo.repository")
public class BlazeConfig {
    @PersistenceUnit
    private EntityManagerFactory entityManagerFactory;

    @Bean
    @Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
    @Lazy(false)
    public CriteriaBuilderFactory createCriteriaBuilderFactory() {
        CriteriaBuilderConfiguration configuration = Criteria.getDefault();
        return configuration.createCriteriaBuilderFactory(entityManagerFactory);
    }

    @Bean
    @Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
    @Lazy(false)
    public EntityViewManager createEntityViewManager(CriteriaBuilderFactory criteriaBuilderFactory, EntityViewConfiguration entityViewConfiguration) {
        EntityViewManager manager = entityViewConfiguration.createEntityViewManager(criteriaBuilderFactory);
        return manager;
    }
}

