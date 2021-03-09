package com.liuqi.rabbit.common.convert;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.support.converter.MessageConversionException;
import org.springframework.amqp.support.converter.MessageConverter;

;

/**
 * 使用装饰者模式（静态代理）去装饰一些个性的设置。
 * @auther liuqi
 * @create 2020-12-17  15:44
 */


public class RabbitMessageConverter implements MessageConverter {
    private   final  String defaulteExprie=String.valueOf(24*60*60*1000);

    private GenericMessageConverter delegate;
    //构建被装饰着对象
    public RabbitMessageConverter(GenericMessageConverter delegate) {
        this.delegate=delegate;
    }

    @Override
    public Message toMessage(Object object, MessageProperties messageProperties) throws MessageConversionException {
        //自己装饰的设置，扩展性好
        messageProperties.setExpiration(defaulteExprie);
        messageProperties.setContentEncoding("utf-8");
        return this.delegate.toMessage(object, messageProperties);
    }

    @Override
    public Object fromMessage(Message message) throws MessageConversionException {
       com.liuqi.rabbit.api.Message msg=(com.liuqi.rabbit.api.Message)delegate.fromMessage(message);
         return msg;
    }
}
