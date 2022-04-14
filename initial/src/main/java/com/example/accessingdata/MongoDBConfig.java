package com.example.accessingdata;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.bremersee.geojson.spring.data.mongodb.convert.GeoJsonConverters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.convert.CustomConversions;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.convert.MongoCustomConversions;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@EnableMongoRepositories(basePackages = "com.example.accessingdata.mongodb.repo")
public class MongoDBConfig {

	@Autowired
    private Environment env;

    @Bean
    @ConfigurationProperties (prefix = "spring.data")
    public DataSource  dataSource() {
    //return DataSourceBuilder.create().build();
      DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl(env.getProperty("spring.data.mongodb.uri"));


        return dataSource;
    }
    
  
    @Bean
    public MongoCustomConversions customConversions() {
      final List<Object> converters = new ArrayList<>(
          GeoJsonConverters.getConvertersToRegister(null));
      // add more custom converters
      return new MongoCustomConversions(converters);
    }
    


}