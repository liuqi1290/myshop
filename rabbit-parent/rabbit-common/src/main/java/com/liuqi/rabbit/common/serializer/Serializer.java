package com.liuqi.rabbit.common.serializer;

import org.springframework.core.serializer.Deserializer;

;

/**
 * 序列化和反序列化接口
 * @auther liuqi
 * @create 2020-12-17  14:45
 */


public interface Serializer {
    byte[] serializeRaw(Object data);
    String serialize(Object data);

    <T> T deserialize(String content);
    <T> T deserialize(byte[] content);
}
