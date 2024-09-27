package com.kwu.propictures.configuration;

import com.kwu.propictures.service.ChinesGreetingService;
import com.kwu.propictures.service.EnglishGreetingService;
import com.kwu.propictures.service.GreetingService;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GreetingServiceConfig {

    @Bean
    @ConditionalOnProperty(name="language.name", havingValue = "english", matchIfMissing = true)
    public GreetingService englishGreetingService(){
        return new EnglishGreetingService();
    }

    @Bean
    @ConditionalOnProperty(name="language.name", havingValue = "chinese")
    public GreetingService chineseGreetingService(){
        return new ChinesGreetingService();
    }
}
