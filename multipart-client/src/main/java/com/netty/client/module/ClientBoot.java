package com.netty.client.module;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import net.sf.json.JSONObject;

import java.util.concurrent.TimeUnit;


public class ClientBoot {

    private static final String HOST = "localhost";
    private static final int    PORT = 1239;

    private String mobile;
    private Bootstrap bootstrap;
    private ClientHandler clientHandler;

    public ClientBoot(String mobile) {
        this.mobile = mobile;
    }

    public void start() {
        clientHandler = new ClientHandler(this);
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
                            p.addLast("decoder", new StringDecoder());
                            p.addLast("encoder", new StringEncoder());
                            p.addLast(clientHandler);
                        }
                    });
            connect();
        } finally {
            group.spliterator();
        }
    }

    public void connect(){
        ChannelFuture future = bootstrap.connect();
        // 监听连接状态, 并添加失败重连
        future.addListener((ChannelFutureListener) f -> {
            if (f.isSuccess()) {
                f.channel().writeAndFlush(getMessage(f.channel()));
                f.channel().closeFuture();
            } else {
                f.channel().eventLoop().schedule(this::connect, 1, TimeUnit.SECONDS);
            }
        });

    }

    /**
     * 配对设备通道与地址等
     */
    public String getMessage(Channel channel) {
        ClientChannelMessage message = new ClientChannelMessage();
        message.setMobile(mobile);
        message.setChannelId(channel.id().asShortText());
        message.setPort(channel.localAddress().toString());
        JSONObject jsonObject = JSONObject.fromObject(message);
        return jsonObject.toString();
    }

    public static void main(String[] args) throws InterruptedException {
        ClientBoot clientBoot = new ClientBoot("13599917118");
        clientBoot.start();
    }

}
