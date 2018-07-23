package com.example.rabbitmq;

/**
 * All rights Reserved, Designed By a.96bill.com
 *
 * @version V1.0
 * @Title: *.java
 * @Package com
 * @Description: TODO(用一句话描述该文件做什么)
 * @author: wuzhicheng
 * @date: 22:04 2018/5/10/010
 * @company:北京今汇在线
 */

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.support.CorrelationData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.Date;

public class Sender {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Scheduled(fixedDelay = 1000L)
    public void send() {
        if (rabbitTemplate.isConfirmListener()) {
            rabbitTemplate.setConfirmCallback(new RabbitTemplate.ConfirmCallback() {
                @Override
                public void confirm(CorrelationData correlationData, boolean b, String s) {
//                    System.out.println("ack: " + correlationData + ". correlationData: " + correlationData + "cause : " + cause);
                }
            });
        }
        System.out.println("send date:" + new Date());
        this.rabbitTemplate.convertAndSend("foo", "hello");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}