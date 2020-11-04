package com.liuqi.rabbitmqconcumer.componet;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

@Component
public class RabbitConcumer {
    @RabbitListener(bindings = @QueueBinding(value = @Queue(value = "queue-1",declare = "true"),
                    exchange = @Exchange(name = "exchange-1",
                            durable = "true",//持久化
                            type = "topic",//类型 主题模式
                            ignoreDeclarationExceptions = "true"),//忽略异常
                    key = "springboot-rabbit")
                    )
    @RabbitHandler
    public  void  onMessage(Message message, Channel channel) throws Exception{
        System.out.println("------------------------------------------------------------------------");
        System.out.println("消费消息："+message);
        // 由于配置了手动签收的方式 所以需要手动获取deliveryTag，并进行ack
        Long deliveryTag = (Long) message.getHeaders().get(AmqpHeaders.DELIVERY_TAG);
        channel.basicAck(deliveryTag, false);
    }
}
