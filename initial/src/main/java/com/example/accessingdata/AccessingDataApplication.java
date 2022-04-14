package com.example.accessingdata;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

import org.springframework.transaction.annotation.EnableTransactionManagement;


//@EnableTransactionManagement
//@EnableNeo4jRepositories
//@ComponentScan(basePackages = "com.example.accessingdata.controller")
@SpringBootApplication 
//@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class, HibernateJpaAutoConfiguration.class})
public class AccessingDataApplication {

public static void main(String[] args) {
  SpringApplication.run(AccessingDataApplication.class, args);
 
}
}