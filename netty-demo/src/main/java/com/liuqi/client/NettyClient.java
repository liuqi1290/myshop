package com.liuqi.client;

import com.liuqi.handler.NettyClientHandler;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;


public class NettyClient {
    public static void main(String[] args) {
        // 创建客户端启动器
        NioEventLoopGroup loopGroup = new NioEventLoopGroup();
        // 创建客户端启动配置
        try {
        Bootstrap bootstrap = new Bootstrap();
        bootstrap.group(loopGroup).channel(NioSocketChannel.class).handler(new ChannelInitializer<SocketChannel>() {
            @Override
            protected void initChannel(SocketChannel socketChannel) throws Exception {
                socketChannel.pipeline().addLast(new NettyClientHandler());
            }
        });
        System.out.println("netty client start");
        //启动客户端去连接服务器端

            ChannelFuture channelFuture = bootstrap.connect("127.0.0.1", 8899).sync();
            //对关闭通道进行监听
            channelFuture.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            //关闭资源
            loopGroup.shutdownGracefully();
        }

    }
}
