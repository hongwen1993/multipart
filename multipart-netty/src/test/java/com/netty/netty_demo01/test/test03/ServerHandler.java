package com.netty.netty_demo01.test.test03;

import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;

@ChannelHandler.Sharable
public class ServerHandler extends ChannelInboundHandlerAdapter {

    public static ConcurrentHashMap<String, ChannelHandlerContext> CHANNELS = new ConcurrentHashMap<>();

    /**
     * Channel注册
     * - 无法在注册Channel时添加到Map中,因为没有唯一标识的处理,无法区分用户
     */
    @Override
    public void channelRegistered(ChannelHandlerContext ctx) throws Exception {
        System.err.println("channelRegistered()===>注册客户端Channel");
    }

    /**
     * 连接成功
     */
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        super.channelActive(ctx);
    }

    /**
     * 读消息
     * {"port":"/192.168.1.114:53262","mobile":"123","message":"","reMark":null,"channelId":"240f2fe7","mark":""}
     */
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        String text = "12345456456789$";
        ctx.writeAndFlush(text);
    }

    /**
     * 消息已读完
     */
    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        super.channelReadComplete(ctx);
    }

    /**
     * 连接闲置
     */
    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        super.channelInactive(ctx);
    }

    /**
     * 异常处理
     */
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        super.exceptionCaught(ctx, cause);
        //ctx.close();
    }

    /**
     * Channel卸载
     */
    @Override
    public void channelUnregistered(ChannelHandlerContext ctx) throws Exception {
        super.channelUnregistered(ctx);
        //ctx.close();
        //Collection<ChannelHandlerContext> collection = ServerHandler.CHANNELS.values();
        //collection.remove(ctx);
    }




}
