package com.liuqi.rabbit.producer.config.database;

import com.zaxxer.hikari.HikariDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * Hikari DataSource configuration.
 */
@Configuration
@PropertySource({"classpath:rabbit-producer-message.yml"})
public class RabbitProducerDataSourceConfiguration {

    private static Logger LOGGER=org.slf4j.LoggerFactory.getLogger(RabbitProducerDataSourceConfiguration.class);

    /**
     * 加载yml 配置文件的属性配置
     * @return
     */
   @Bean
   @ConfigurationProperties(prefix="spring.datasource.hikari")
   public DataSourceProperties dataSourceProperties(){

      return new DataSourceProperties();
   }

    /**
     * 构建dataSource
     * @return
     */
    @Bean(name="rabbitProducerDataSource")
    @ConfigurationProperties(prefix="spring.datasource")
    public HikariDataSource dataSource(DataSourceProperties properties) {
        HikariDataSource hikariDataSource=properties.initializeDataSourceBuilder().type(HikariDataSource.class).build();
        LOGGER.info("--------------rabbitProducerDataSource-----------:" + hikariDataSource);
        return hikariDataSource;
    }


}
