package com.liuqi.rabbit.common.serializer.impl;

import com.liuqi.rabbit.api.Message;
import com.liuqi.rabbit.common.serializer.Serializer;
import com.liuqi.rabbit.common.serializer.SerializerFactory;

;

/**
 * @auther liuqi
 * @create 2020-12-17  15:22
 */


public class JacksonSerializerFactory implements SerializerFactory {
    //饥饿工厂模式
    public static final  JacksonSerializerFactory INSTENCE=new JacksonSerializerFactory();

    @Override
    public Serializer create() {
        return JacksonSerializer.createParametricType(Message.class);
    }
}
