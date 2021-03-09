package com.liuqi.rabbit.api;

import lombok.Data;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**消息的封装
 * @author liuqi
 */
@Data
public class Message implements Serializable {

    private static final long serialVersionUID = 1301363546860703158L;
    /**
     * 消息唯一标识
     */
    private String messageId;
    /**
     * 消息主题
     */
    private String topic;
    /**
     * 消息路由键
     */
    private  String routingKey="";
    /**
     * 附加属性
     */
    private Map<String ,Object> attributes = new HashMap<>();
    /**
     * 延时时间
     */
    private int delayMills;
    /**
     * 消息类型：默认为Comfirm类型
     */
    private String messageType=MessageType.CONFIRM;

    public Message() {

    }

    public Message(String messageId, String topic, String routingKey, Map<String, Object> attributes, int delayMills) {
        this.messageId = messageId;
        this.topic = topic;
        this.routingKey = routingKey;
        this.attributes = attributes;
        this.delayMills = delayMills;
        this.messageType = messageType;
    }
    public Message(String messageId, String topic, String routingKey, Map<String, Object> attributes, int delayMills, String messageType) {
        this.messageId = messageId;
        this.topic = topic;
        this.routingKey = routingKey;
        this.attributes = attributes;
        this.delayMills = delayMills;
        this.messageType = messageType;
    }
}
