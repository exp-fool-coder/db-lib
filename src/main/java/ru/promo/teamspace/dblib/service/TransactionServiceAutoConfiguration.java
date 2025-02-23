package ru.promo.teamspace.dblib.service;

import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.transaction.TransactionAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration(proxyBeanMethods = false)
@ConditionalOnClass({PlatformTransactionManager.class})
@AutoConfigureAfter({TransactionAutoConfiguration.class})
public class TransactionServiceAutoConfiguration {
    @Bean
    public TransactionService transactionService() {
        return new SpringTransactionService();
    }
}
