package com.netty.client.module;

import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.EventLoop;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.util.ReferenceCountUtil;

import java.util.concurrent.TimeUnit;

@ChannelHandler.Sharable
public class ClientHandler extends SimpleChannelInboundHandler<Object> {

    private ClientBoot clientBoot;

    public ClientHandler (ClientBoot clientBoot) {
        this.clientBoot = clientBoot;
    }

    /**
     * 读取服务器消息
     */
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, Object msg) {
        // msg中为服务端推送到客户端的数据
        System.out.println(msg.toString());
        // TODO ..消息处理

        // 释放
        ReferenceCountUtil.release(msg);
    }

    /**
     * 连接成功
     */
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        super.channelActive(ctx);
    }

    /**
     * 断开连接
     */
    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        final EventLoop eventLoop = ctx.channel().eventLoop();
        eventLoop.schedule(() -> clientBoot.connect(), 3, TimeUnit.SECONDS);
        super.channelInactive(ctx);
    }

    /**
     * 结束读取
     */
    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        super.channelReadComplete(ctx);
    }

    /**
     * 异常捕获
     */
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        System.out.println("发生错误===>" + cause);
    }

}
