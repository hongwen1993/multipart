package com.netty.netty_demo01.test.test03;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.Unpooled;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.DelimiterBasedFrameDecoder;
import io.netty.handler.codec.FixedLengthFrameDecoder;
import io.netty.handler.codec.LineBasedFrameDecoder;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

import javax.annotation.Resource;
import java.net.InetSocketAddress;


public class ServerBoot {

    private static final int PORT = 1239;
    private ServerBootstrap bootstrap;

    public void init() {
        // netty服务端ServerBootstrap启动的时候,默认有两个eventloop分别是bossGroup和 workGroup
        EventLoopGroup bossGroup = new NioEventLoopGroup(1);
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        try {
            bootstrap = new ServerBootstrap().group(bossGroup, workerGroup);
            bootstrap.channel(NioServerSocketChannel.class);
            bootstrap.localAddress(new InetSocketAddress(PORT));
            bootstrap.option(ChannelOption.SO_BACKLOG, 512);
            bootstrap.childOption(ChannelOption.SO_KEEPALIVE, true);
            bootstrap.childHandler(new ChannelInitializer<SocketChannel>() {
                        protected void initChannel(SocketChannel ch) throws Exception {
                            ChannelPipeline p = ch.pipeline();
                            p.addLast(new FixedLengthFrameDecoder(5));
                            p.addLast("decoder", new StringDecoder());
                            p.addLast("encoder", new StringEncoder());
                            p.addLast(new ServerHandler());
                        }
                    });
            bind();
        } catch (Exception e) {
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }
    }

    public void bind() throws InterruptedException {
        ChannelFuture future = bootstrap.bind(PORT).sync();
        // 监听连接状态, 并添加失败重连
        future.addListener((ChannelFutureListener) f -> {
            if (f.isSuccess()) {
                f.channel().closeFuture();
            } else {
//                logger.debug("长连接初始化失败");
            }
        });
    }

    public static void main(String[] args) {
        new ServerBoot().init();
    }


}
