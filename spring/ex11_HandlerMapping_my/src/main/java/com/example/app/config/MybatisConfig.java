package com.example.app.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

	
@Configuration
public class MybatisConfig {

	@Autowired
	private DataSource dataSource3;

	@Bean 
	public SqlSessionFactory sqlSessionFactory() throws Exception {
		// bean생성
		SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
		// bean에 데이터소스 넣기
		sessionFactory.setDataSource(dataSource3);
		
		// Mapper XML 파일의 위치 설정
	    PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
	    // 모든 경로의 mapper라는 폴더 아래 모든 xml파일
	    Resource[] resources = resolver.getResources("classpath*:mapper/*.xml");
	    sessionFactory.setMapperLocations(resources);
		
		// 데이터 소스가 들어간 빈 반환
		return sessionFactory.getObject();
	}

	//-----------------------
	// sqlSession 생성
	//-----------------------
	@Autowired
	private SqlSessionFactory sqlSessionFactory;
		
	@Bean
	public SqlSessionTemplate sqlSessionTemplate() {
	    return new SqlSessionTemplate(sqlSessionFactory);
	}
}

