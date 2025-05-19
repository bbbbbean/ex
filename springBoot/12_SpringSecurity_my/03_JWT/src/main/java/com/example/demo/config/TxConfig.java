package com.example.demo.config;

import jakarta.persistence.EntityManagerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement    // myBatis, 기본 Tx 설정
//@EnableJpaRepositories  // JPA 안쓸거면 이 설정 필요없음
       // (
               // basePackages ="com.example.demo.domain.repository",
                //transactionManagerRef = "jpaTransactionManager"
        //)
public class TxConfig {


    @Autowired
    private DataSource dataSource;

//    // 기본 TransactionManager : myBatis 여기 적용
//    @Bean(name = "dataSourceTransactionManager")
//    public DataSourceTransactionManager transactionManager2() {
//        //System.out.println("TX dataSrouce2 : " + dataSource.toString());
//        return new DataSourceTransactionManager(dataSource);
//    }


    //    JPA TransactionManager Settings
    @Bean(name="jpaTransactionManager")
    public JpaTransactionManager jpaTransactionManager(EntityManagerFactory entityManagerFactory) {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory);
        transactionManager.setDataSource(dataSource);

        return transactionManager;
    }

}

