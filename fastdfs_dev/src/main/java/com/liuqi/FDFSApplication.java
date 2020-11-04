package com.liuqi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import tk.mybatis.spring.annotation.MapperScan;


@ComponentScan(basePackages ={"com.liuqi","com.org.n3r.idworker"})
@MapperScan(basePackages = "com.liuqi.mapper")
@SpringBootApplication
public class FDFSApplication {
    public static void main(String[] args) {
        SpringApplication.run(FDFSApplication.class,args);
    }

    //mq  服务解耦   削峰填谷    异步任务
    //mq 的思考  消息投递的可靠性，消息消费的幂等性， mq的高可用  低延迟，可靠性，可扩展，消息堆积能力
    //主流的mq activemq,rabbiteMq ,rockteMq kafka
    //技术选型
        // activemq 适合中小型传统行业
        // rabbitmq 横向扩展能力不是太好，可维护 可用性高
        // rockteMq 扩展性好，可用性繁琐，硬件要求高，公司技术栈的考虑
        // kafa 扩展性好,针对消息要求不严格的情况下  这个是可以在低配的服务器上有好的性能
   // rabbitMq 四种集群
        // 主备模式（Haproxy进行切换）
        //  远程模式 （slov）
        //  镜像模式（）
        // 双活模式  （需要通过federation 组件连接两个集群的通信）
   // kafaka  特点
        // 分布式，跨平台，伸缩性，实时性。适合做数据收集（亿级数据），消息堆积能力，支持水平扩展
        // kafka高性能的搞得原因：
            // 顺序写消息（page cache 空中接力）  page cache ：将磁盘的数据缓存到内存中,将对磁盘的访问转换为对内存的读取，该缓存是系统层面的功能，所以kafka 的重启不会导致该缓存的丢失。
            // 后台异步
            // 预读策略
   // 如何保证消息可靠性投递？
        // 保证消息的成功发出
            //1.消息状态入库，针对消息状态非正确的进行重复投递。
            //2.消息延迟投递，检查confirm确认
        // 保障Mq节点成功的接收，消费端的幂等性
            // 唯一ID+指纹吗  确定唯一数据库id,为了解决把数据库操作的瓶颈，通过将id设计为一定的规则进行分库分表；
            // 使用redis 进行原子性操作 保证幂等性（存在的问题是，如何保证数据的同步和更新缓存策略？）
        // 发送端收到 Mq节点确认的应答
        // 完善消息进行补偿的机制
}

