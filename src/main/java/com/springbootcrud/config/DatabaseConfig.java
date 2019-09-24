//   Since we are added the database configuration in our application.properties, we don't need this.


//package com.springbootcrud.config;
//
//import javax.sql.DataSource;
//
//import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Primary;
//import org.springframework.stereotype.Component;
//
//@Configuration
//@Component
//public class DatabaseConfig {
//
//	@ConfigurationProperties(prefix = "spring.datasource")
//	@Bean
//	@Primary
//	public DataSource getDataSource() {
//		return DataSourceBuilder.create().url("jdbc:mysql://localhost:3306/dbspringboot?useSSL=false").username("root")
//				.password("2015").build();
//	}
//}
