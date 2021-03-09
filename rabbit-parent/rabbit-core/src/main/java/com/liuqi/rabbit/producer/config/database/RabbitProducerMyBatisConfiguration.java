package com.liuqi.rabbit.producer.config.database;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

/**
 * 改配置没有写到yml配置文件中，为了让该组件对用户无感知，不想让调用者去修改。
 */

@Configuration
@AutoConfigureAfter(value = {RabbitProducerDataSourceConfiguration.class})//约束条件，必须是数据源初始化完成后才进行
public class RabbitProducerMyBatisConfiguration {

	@Resource(name= "rabbitProducerDataSource")
	private DataSource rabbitProducerDataSource;
	
	@Bean(name="rabbitProducerSqlSessionFactory")
	public SqlSessionFactory rabbitProducerSqlSessionFactory(DataSource rabbitProducerDataSource) {
		
		SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
		bean.setDataSource(rabbitProducerDataSource);
		ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
		try {
			bean.setMapperLocations(resolver.getResources("classpath:com/liuqi/rabbit/producer/mapping/*.xml"));
			SqlSessionFactory sqlSessionFactory = bean.getObject();
			sqlSessionFactory.getConfiguration().setCacheEnabled(Boolean.TRUE);
			return sqlSessionFactory;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	@Bean(name="rabbitProducerSqlSessionTemplate")
	public SqlSessionTemplate rabbitProducerSqlSessionTemplate(SqlSessionFactory sqlSessionFactory) {
		return new SqlSessionTemplate(sqlSessionFactory);
	}
	
}
