package com.liuqi.handler;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.CharsetUtil;
import io.netty.util.concurrent.EventExecutorGroup;

public class NettyClientHandler extends ChannelInboundHandlerAdapter {
    volatile private int count;
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("client active");
        ctx.writeAndFlush(Unpooled.copiedBuffer("hello server",CharsetUtil.UTF_8));
    }
    //private EventExecutorGroup group
    @Override
    public void channelRead(ChannelHandlerContext ctx,Object msg) throws Exception {
        System.out.println("client read");
        ByteBuf buf = (ByteBuf) msg;
        System.out.println("client receive server message:"+buf.toString(CharsetUtil.UTF_8));
        System.out.println("client receive server address:"+ctx.channel().remoteAddress());
        ctx.channel().writeAndFlush(Unpooled.copiedBuffer("hello server!",CharsetUtil.UTF_8));

    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx,Throwable cause) throws Exception {
        ctx.close();
    }
}
