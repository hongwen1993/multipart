package com.netty.client.module;

import java.io.Serializable;
import java.util.Objects;

public class ClientChannelMessage implements Serializable {


    /**
     * 客户端手机号
     */
    private String mobile;
    /**
     * 消息内容
     */
    private String message;
    /**
     * 客户端ChannelId
     */
    private String channelId;
    /**
     * 客户的端口
     */
    private String port;
    /**
     * 备注
     */
    private String mark;
    /**
     * 备用字段
     */
    private Object reMark;

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public Object getReMark() {
        return reMark;
    }

    public void setReMark(Object reMark) {
        this.reMark = reMark;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClientChannelMessage message = (ClientChannelMessage) o;
        return Objects.equals(mobile, message.mobile);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mobile);
    }
}
