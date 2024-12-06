package com.project.healthcare.Supporter.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.annotation.PreDestroy;

@Configuration
public class ThreadPoolConfig {

    private final ExecutorService executorService = Executors.newFixedThreadPool(10);

    @Bean
    public ExecutorService taskExecutor() {
        return executorService;
    }

    @PreDestroy
    public void shutdown() {
        executorService.shutdown();
    }
}