package com.liuqi.rabbit.api;

/**
 * 定义消息类型
 * @author liuqi
 */
public final class MessageType {
    /**
     * 迅速消息： 不需要保证可靠性，也不需要做确认
     */
    public static  final String RAPID="0";
    /**
     * 确认消息：不需要保证消息可靠性，但是会做消息收到的confirm
     */
    public static  final String CONFIRM="1";
    /**
     * 可靠消息：一定保证消息100%的投递，不许允许任何消息丢失，保证数据库和所发的消息的原子性（最终一致性）
     */
    public static  final String RELIANT="2";
}
