package com.roofflex.springsecutiry.demo.config;


import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.util.logging.Logger;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.roofflex.springsecutiry.demo")
@PropertySource("classpath:persistence-mysql.properties")
public class DemoAppConfig {

    // set variable to hold properties

    @Autowired
    private Environment environment;

    // set up Logger

    private Logger logger = Logger.getLogger(getClass().getName());

    // define a bean for viewresolver
    @Bean
    public ViewResolver viewResolver(){

        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/view/");
        viewResolver.setSuffix(".jsp");

        return viewResolver;
    }

    // define a bean for security datasource
    @Bean
    public DataSource securityDataSource() throws PropertyVetoException {

        // create connection pool
        ComboPooledDataSource securityDataSource = new ComboPooledDataSource();

        // set up jdbc driver
        securityDataSource.setDriverClass(environment.getProperty("jdbc.driver"));

        // log connection properties
        logger.info(">>> jdbc url: " + environment.getProperty("jdbc.url"));
        logger.info(">>> jdbc user: " + environment.getProperty("jdbc.user"));

        // set up db properties
        securityDataSource.setJdbcUrl(environment.getProperty("jdbc.url"));
        securityDataSource.setUser(environment.getProperty("jdbc.user"));
        securityDataSource.setPassword(environment.getProperty("jdbc.password"));

        // set up connection pool properties
        securityDataSource.setInitialPoolSize(Integer.parseInt(environment.getProperty("connection.pool.initialPoolSize")));
        securityDataSource.setMinPoolSize(Integer.parseInt(environment.getProperty("connection.pool.minPoolSize")));
        securityDataSource.setMinPoolSize(Integer.parseInt(environment.getProperty("connection.pool.maxPoolSize")));
        securityDataSource.setMaxIdleTime(Integer.parseInt(environment.getProperty("connection.pool.maxIdleTime")));

        return securityDataSource;
    }
}
