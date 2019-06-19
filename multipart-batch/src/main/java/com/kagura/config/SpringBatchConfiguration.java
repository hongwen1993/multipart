package com.kagura.config;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.support.ApplicationContextFactory;
import org.springframework.batch.core.configuration.support.GenericApplicationContextFactory;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration
//@EnableAutoConfiguration
//@EnableBatchProcessing(modular = true)
public class SpringBatchConfiguration {

    //@Bean
    //public ApplicationContextFactory messageMigrationJobContext() {
    //    return new GenericApplicationContextFactory(MessageMigrationJobConfiguration.class);
    //}

}
