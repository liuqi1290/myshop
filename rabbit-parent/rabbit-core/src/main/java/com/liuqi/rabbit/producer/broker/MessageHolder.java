package com.liuqi.rabbit.producer.broker;

import com.google.common.collect.Lists;
import com.liuqi.rabbit.api.Message;

;import java.util.ArrayList;
import java.util.List;

/**
 * 缓存消息
 *
 * @auther liuqi
 * @create 2021-03-16  14:25
 */


public class MessageHolder {
    private List<Message> messageList=Lists.newArrayList();

    public static final ThreadLocal<MessageHolder> holderThreadLocal;

    static {
        holderThreadLocal=ThreadLocal.withInitial(() -> new MessageHolder());
    }

    public static void  add(Message message){
        holderThreadLocal.get().messageList.add(message);
    }

    public static  List<Message> getMessages(){
        ArrayList<Message> temp=new ArrayList<>(holderThreadLocal.get().messageList);
        holderThreadLocal.remove();
        return temp;
    }

}
