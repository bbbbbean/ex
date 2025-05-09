package com.example.demo.config;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataSourceConfig {
	// Spring-jdbc DataSource	
//	@Bean
//	public DataSource dataSource2()
//	{
////		DriverManagerDataSource dataSource = new DriverManagerDataSource();
//		// 기본 제공
//		BasicDataSource dataSource = new BasicDataSource();
//		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
//		dataSource.setUrl("jdbc:mysql://localhost:3306/testdb");
//		dataSource.setUsername("root");
//		dataSource.setPassword("1234");
//
//		// 커넥션 풀 설정
//		dataSource.setInitialSize(5);	// 초기 연결 갯수
//		dataSource.setMaxTotal(10);		// 최대 연결 갯수
//		dataSource.setMaxIdle(8);		// 최대 유휴 연결 수 : 사용하지 않는 상태일 때 몇개까지 쉬고있는 상태? 검색해...
//		dataSource.setMinIdle(3);		// 최소 유휴 연결 수
//
//		return dataSource;
//	}
	
	//HikariCP DataSource
	@Bean
	public HikariDataSource dataSource()
	{
		HikariDataSource dataSource = new HikariDataSource();
		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/testdb");
		dataSource.setUsername("root");
		dataSource.setPassword("1234");	
		 
		return dataSource;
	}
	
}
