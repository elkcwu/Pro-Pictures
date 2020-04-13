package com.kwu.propictures.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@ConfigurationProperties("spring.datasource")
@SuppressWarnings("unused")
public class DBConfiguration {
    private String driverClassName;
    private String url;
    private String username;
    private String password;

    @Profile("dev")
    @Bean
    public String devDatabaseConnection(){
        System.out.println("DB connection for DEV - H2");
        System.out.println(username);
        System.out.println(url);
        return "DB connection for DEV - H2";
    }

    @Profile("test")
    @Bean
    public String testDatabaseConnection(){
        System.out.println("DB connection to TEST environment -");
        System.out.println(username);
        System.out.println(url);
        return "DB connection to TEST environment -";
    }

    @Profile("prod")
    @Bean
    public String prodDatabaseConnection(){
        System.out.println("DB connection to PRODUCTION environment -");
        System.out.println("username: " + username);
        System.out.println("url: " + url);
        return "DB connection to PRODUCTION environment -";
    }
}
