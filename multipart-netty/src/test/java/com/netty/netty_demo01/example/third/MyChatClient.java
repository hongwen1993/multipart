package com.netty.netty_demo01.example.third;

import com.netty.netty_demo01.example.second.MyClientInitalizer;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MyChatClient {

    public static void main(String[] args) throws InterruptedException, IOException {

        EventLoopGroup workerGroup = new NioEventLoopGroup();

        try {
            Bootstrap bootstrap = new Bootstrap();
            bootstrap.group(workerGroup).channel(NioSocketChannel.class)
                    .handler(new MyChatClientInitializer());

            Channel channel = bootstrap.connect("localhost", 8899).sync().channel();

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            for(;;) {
                channel.writeAndFlush(br.readLine() + "\r\n");
            }
        } finally {
            workerGroup.shutdownGracefully();
        }
    }

}

