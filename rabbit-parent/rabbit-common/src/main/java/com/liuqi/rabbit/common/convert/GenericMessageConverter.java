package com.liuqi.rabbit.common.convert;

import com.google.common.base.Preconditions;
import com.liuqi.rabbit.common.serializer.Serializer;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.support.converter.MessageConversionException;
import org.springframework.amqp.support.converter.MessageConverter;

/**
 * @auther liuqi
 * @create 2020-12-17  15:25
 */


public class GenericMessageConverter implements MessageConverter {

    private Serializer serializer;

    public GenericMessageConverter(Serializer serializer) {
        Preconditions.checkNotNull(serializer);
        this.serializer=serializer;
    }


    @Override
    public Message toMessage(Object object, MessageProperties messageProperties) throws MessageConversionException {
        return new Message(this.serializer.serializeRaw(object), messageProperties);
    }

    @Override
    public Object fromMessage(Message message) throws MessageConversionException {
        return serializer.deserialize(message.getBody());
    }
}
