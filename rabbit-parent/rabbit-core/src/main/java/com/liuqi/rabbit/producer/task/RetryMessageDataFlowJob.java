package com.liuqi.rabbit.producer.task;

import com.dangdang.ddframe.job.api.ShardingContext;
import com.dangdang.ddframe.job.api.dataflow.DataflowJob;
import com.liuqi.rabbit.common.contant.BrokerMessageStatus;
import com.liuqi.rabbit.producer.broker.RabbitBroker;
import com.liuqi.rabbit.producer.entity.BrokerMessage;
import com.liuqi.rabbit.producer.service.MassageStoreService;
import com.liuqi.rabbit.task.annotation.ElasticJobConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/** 可靠性投递补偿任务
 * @auther liuqi
 * @create 2021-03-12  14:56
 */
@Slf4j
@ElasticJobConfig(
        name = "com.liuqi.rabbit.producer.task.RetryMessageDataFlowJob",
        cron = "0 0/1 * * * ?",
        description = "可靠性投递补偿定时任务",
        overwrite = true,
        streamingProcess=false,
        eventTraceRdbDataSource="jobEventConfiguration",
        shardingTotalCount = 2
)
@Component
public class RetryMessageDataFlowJob implements DataflowJob<BrokerMessage> {
    @Autowired
    private MassageStoreService massageStoreService;
    @Autowired
    private RabbitBroker rabbitBroker;

    private static  final  int MAXRETY_COUNT=3;
    @Override
    public List fetchData(ShardingContext shardingContext) {
        List<BrokerMessage> brokerMessages=massageStoreService.queryBrokerMessageStatus4Timeout(BrokerMessageStatus.SENDING.getCode());
        log.info("@@@@@@@@ 抓取数据集合  数量{} @@@@@@@@",brokerMessages.size());
        return brokerMessages;
    }

    @Override
    public void processData(ShardingContext shardingContext, List<BrokerMessage> dataList) {
        dataList.forEach(brokerMessage -> {
            String messageId=brokerMessage.getMessageId();
            if(brokerMessage.getTryCount()>MAXRETY_COUNT){
                this.massageStoreService.fail(messageId);
                log.warn("@@@@@@@@ 消息设置为最终失败 消息ID {} @@@@@@@@",messageId);
            }else{
                massageStoreService.updateTryCount(messageId);
                rabbitBroker.reliantSend(brokerMessage.getMessage());
            }

        });
    }
}
