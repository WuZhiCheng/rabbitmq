package com.example.rabbitmq.delay.service;

/**
 * All rights Reserved, Designed By a.96bill.com
 *
 * @version V1.0
 * @Title: *.java
 * @Package com
 * @Description: TODO(用一句话描述该文件做什么)
 * @author: wuzhicheng
 * @date: 11:50 2018/8/3
 * @company:北京今汇在线
 */
public interface IMessageQueueService {
    /**
     * 发送消息到队列
     * @param queueName 队列名称
     * @param message 消息内容
     */
    public void send(String queueName, String message);

    /**
     * 延迟发送消息到队列
     * @param queueName 转发至的队列名称
     * @param message 消息内容
     * @param times 延迟时间 单位毫秒
     */
    public void send(String queueName, String message, long times);
}
