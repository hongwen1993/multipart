package com.mq.entity;

public class ClientMessage {
    private String uuid;
    private String message;
    private Long time;
    private Long delay;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    public Long getDelay() {
        return delay;
    }

    public void setDelay(Long delay) {
        this.delay = delay;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"uuid\":\"")
                .append(uuid).append('\"');
        sb.append(",\"message\":\"")
                .append(message).append('\"');
        sb.append(",\"time\":")
                .append(time);
        sb.append(",\"delay\":")
                .append(delay);
        sb.append('}');
        return sb.toString();
    }
}
