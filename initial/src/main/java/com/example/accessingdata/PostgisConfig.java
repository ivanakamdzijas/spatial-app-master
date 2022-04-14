package com.example.accessingdata;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.n52.jackson.datatype.jts.JtsModule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
  entityManagerFactoryRef = "entityManagerFactory",
  basePackages = { "com.example.accessingdata.postgis.repo" }
)
public class PostgisConfig {
	
	@Autowired
    private Environment  env;
  
  @Primary
  @Bean(name = "dataSource")
  @ConfigurationProperties(prefix = "spring.datasource")
  public DataSource dataSource() {
    /*return DataSourceBuilder
    		.create().build();*/
	  DriverManagerDataSource dataSource = new DriverManagerDataSource();
	    dataSource.setUrl(env.getProperty("spring.datasource.url"));

	    dataSource.setUsername(env.getProperty("spring.datasource.username"));
	    dataSource.setPassword(env.getProperty("spring.datasource.password"));

	    return dataSource;
  }
  
  @Primary
  @Bean(name = "entityManagerFactory")
  public LocalContainerEntityManagerFactoryBean
  entityManagerFactory(
    EntityManagerFactoryBuilder builder,
    @Qualifier("dataSource") DataSource dataSource
  ) {
    return builder
      .dataSource(dataSource)
      .packages("com.example.accessingdata.postgis.entities")
      //???
      .persistenceUnit("postgis")
      .build();
  }
    
  @Primary
  @Bean(name = "transactionManager")
  public PlatformTransactionManager transactionManager(
    @Qualifier("entityManagerFactory") EntityManagerFactory 
    entityManagerFactory
  ) {
    return new JpaTransactionManager(entityManagerFactory);
  }
  
  @Bean
	public JtsModule jtsModule() {
		// This module will provide a Serializer for geometries
		return new JtsModule();
	}

}
