
package com.liuqi.rabbit.producer.config.database;

import com.dangdang.ddframe.job.event.JobEventConfiguration;
import com.dangdang.ddframe.job.event.rdb.JobEventRdbConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;
import javax.sql.DataSource;

@Configuration
@AutoConfigureAfter(value = {RabbitProducerDataSourceConfiguration.class})//约束条件，必须是数据源初始化完成后才进行
public class JobEventConfig {

    @Autowired
    private DataSource rabbitProducerDataSource;

    @Bean(name="jobEventConfiguration")
    public JobEventConfiguration jobEventConfiguration() {
        return new JobEventRdbConfiguration(rabbitProducerDataSource);
    }
}
