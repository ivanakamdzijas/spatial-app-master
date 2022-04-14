package com.example.accessingdata;



import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.neo4j.driver.Session;
import org.neo4j.driver.internal.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableNeo4jRepositories(
     basePackages = {"com.example.accessingdata.neo4j.repo"})

public class Neo4jConfig {
	
	@Autowired
    private Environment  env;


@Bean 
@ConfigurationProperties (prefix = "spring.neo4j")
public DataSource  dataSource() {
//return DataSourceBuilder.create().build();
  DriverManagerDataSource dataSource = new DriverManagerDataSource();
    dataSource.setUrl(env.getProperty("spring.neo4j.uri"));

    dataSource.setUsername(env.getProperty("spring.neo4j.authentication.username"));
    dataSource.setPassword(env.getProperty("spring.neo4j.authentication.password"));
    
    return dataSource;
}





}



