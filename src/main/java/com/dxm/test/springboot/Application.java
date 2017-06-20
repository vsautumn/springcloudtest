package com.dxm.test.springboot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@MapperScan("com.dxm.test.springboot.mapper")
public class Application {
	protected static Logger logger = LoggerFactory.getLogger(Application.class);

//	@Bean
//	@ConfigurationProperties(prefix = "spring.datasource")
//	public DataSource dataSource() {
//		return new org.apache.tomcat.jdbc.pool.DataSource();
//	}
//
//	@Bean
//	public SqlSessionFactory sqlSessionFactoryBean() throws Exception {
//
//		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
//		sqlSessionFactoryBean.setDataSource(dataSource());
//
//		PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
//
//		sqlSessionFactoryBean.setMapperLocations(resolver
//				.getResources("classpath:/mybatis/*.xml"));
//
//		return sqlSessionFactoryBean.getObject();
//	}
//
//	@Bean
//	public PlatformTransactionManager transactionManager() {
//		return new DataSourceTransactionManager(dataSource());
//	}

	public static void main(String[] args) {
		System.out.println("-------------");
		
		SpringApplication.run(Application.class, args);
	}
}
