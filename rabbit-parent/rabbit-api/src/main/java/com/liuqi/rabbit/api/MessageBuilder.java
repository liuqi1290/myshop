package com.liuqi.rabbit.api;

import com.liuqi.rabbit.api.exception.MessageRunTimeException;
import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * 建造者模式
 * @author liuqi
 */
public class MessageBuilder {

    private String messageId;

    private String topic;

    private  String routingKey="";

    private Map<String ,Object> attributes = new HashMap<>();

    private int delayMills;

    private String messageType=MessageType.CONFIRM;


    private MessageBuilder() {

    }
     public  static MessageBuilder create(){return new MessageBuilder();}

     public MessageBuilder withMessageId(String messageId){
         this.messageId=messageId;
         return this;
     }

    public MessageBuilder withTopic(String topic){
        this.topic=topic;
        return this;
    }
    public MessageBuilder withRoutingKey(String routingKey){
        this.routingKey=routingKey;
        return this;
    }
    public MessageBuilder witAattributes(Map<String ,Object> attributes){
        this.attributes=attributes;
        return this;
    }
    public MessageBuilder withAattribute(String Key,Object value){
        this.attributes.put(Key, value);
        return this;
    }
    public MessageBuilder withDelayMills(int delayMills){
        this.delayMills=delayMills;
        return this;
    }
    public MessageBuilder withMessageType(String messageType){
        this.messageType=messageType;
        return this;
    }

    public  Message build(){
        if(StringUtils.isBlank(this.messageId)){

            this.messageId= UUID.randomUUID().toString().replace("-", "");
        }

        if(StringUtils.isBlank(this.topic)){
          throw new MessageRunTimeException("this topic is null");
        }
        Message message = new Message(messageId, topic, routingKey, attributes, delayMills, messageType);
        return message;
    }


    public static void main(String[] args) {
        Message message = MessageBuilder.create().withMessageId("123").withTopic("topic").build();
    }
}
