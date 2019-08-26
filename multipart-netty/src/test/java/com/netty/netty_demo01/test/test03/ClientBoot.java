package com.netty.netty_demo01.test.test03;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.LineBasedFrameDecoder;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import io.netty.handler.timeout.IdleStateHandler;
import net.sf.json.JSONObject;

import java.util.concurrent.TimeUnit;


public class ClientBoot {

    private static final String HOST = "localhost";
    private static final int    PORT = 1239; // 104服专用

    private String mobile;
    private Bootstrap bootstrap;

    public ClientBoot(String mobile) {
        this.mobile = mobile;
    }

    public void start() {
        EventLoopGroup group = new NioEventLoopGroup();
        try {
            bootstrap = new Bootstrap();
            bootstrap.group(group);
            bootstrap.channel(NioSocketChannel.class);
            bootstrap.remoteAddress(HOST, PORT);
            bootstrap.option(ChannelOption.SO_KEEPALIVE, true);
            bootstrap.option(ChannelOption.CONNECT_TIMEOUT_MILLIS, 1000);
            bootstrap.handler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        public void initChannel(SocketChannel ch) throws Exception {
                            ChannelPipeline p = ch.pipeline();
                            p.addLast(new LineBasedFrameDecoder(1024));
                            p.addLast("decoder", new StringDecoder());
                            p.addLast("encoder", new StringEncoder());
                            p.addLast(new ClientHandler());
                        }
                    });
            connect();
        } finally {

        }
    }

    public void connect(){
        ChannelFuture future = bootstrap.connect();
        // 监听连接状态, 并添加失败重连
        future.addListener((ChannelFutureListener) f -> {
            if (f.isSuccess()) {
                String text = "668899\n\r\n";
                f.channel().writeAndFlush(text);
                f.channel().closeFuture();
            } else {
                f.channel().eventLoop().schedule(this::connect, 1, TimeUnit.SECONDS);
            }
        });

    }



    public static void main(String[] args) {
        ClientBoot clientBoot = new ClientBoot("18732510926");
        clientBoot.start();
    }

}
