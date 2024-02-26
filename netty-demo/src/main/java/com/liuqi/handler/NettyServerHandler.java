package com.liuqi.handler;

import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.CharsetUtil;
import io.netty.util.concurrent.EventExecutorGroup;

public class NettyServerHandler extends ChannelInboundHandlerAdapter
{
    //读取客户端发送的消息
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println("服务器读取线程 "+Thread.currentThread().getName());
        System.out.println("server ctx="+ctx);
        System.out.println("server 接收到的消息"+msg);
    }
    //数据读取完毕
    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        ctx.writeAndFlush(Unpooled.copiedBuffer("hello,客户端~_~", CharsetUtil.UTF_8));
        //ctx.writeAndFlush(Unpooled.copiedBuffer("hello,客户端~_~",CharsetUtil.UTF_8
        //        ));
        //writeAndFlush是write和flush的组合，将数据写入到缓存，并刷新
        //一般讲，我们对这个发送的数据进行编码

    }
    //处理异常，一般是需要关闭通道
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        ctx.close();
        super.exceptionCaught(ctx, cause);
    }


}
