package com.roofflex.springdemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
//@ComponentScan("com.roofflex.springdemo")
@PropertySource("classpath:sport.properties")
public class SportConfig {

    // define bean for the fortune service
    @Bean
    public FortuneService sadFortuneService(){
        return new SadFortuneService();
    }

    // define bean for the swim coach and inject dependency
    @Bean
    public SwimCoach swimCoach(){
        return new SwimCoach(sadFortuneService());
    }
}
