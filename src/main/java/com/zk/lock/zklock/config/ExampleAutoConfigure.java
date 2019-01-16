package com.zk.lock.zklock.config;

import com.zk.lock.zklock.service.ExampleService;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author andyFan
 * @since 2019年01月14日
 */
@Configuration
@ConditionalOnClass(ExampleService.class)
@EnableConfigurationProperties(ExampleServiceProperties.class)
public class ExampleAutoConfigure {
    private final ExampleServiceProperties properties;

    public ExampleAutoConfigure(ExampleServiceProperties properties) {
        this.properties = properties;
    }

    @Bean
    @ConditionalOnMissingBean
    @ConditionalOnProperty(prefix = "example.service", value = "enabled", havingValue = "true")
    ExampleService exampleService() {
        return new ExampleService(properties.getPrefix(), properties.getSuffix());
    }
}
