//package com.webproject.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.jdbc.datasource.DriverManagerDataSource;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
//
//import javax.sql.DataSource;
//
///**
// * Created by Shaurav on 4/27/2017.
// */
//@Configuration
//public class DatabaseConfig extends WebMvcConfigurerAdapter {
//    @Bean(name = "dataSource")
//    public DataSource dataSource() {
//        DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
//        driverManagerDataSource.setDriverClassName("com.mysql.jdbc.Driver");
//        driverManagerDataSource.setUrl("jdbc:mysql://localhost:3306/hostyourtournament");
//        driverManagerDataSource.setUsername("root");
//        driverManagerDataSource.setPassword("");
//        return driverManagerDataSource;
//    }
//
//}
