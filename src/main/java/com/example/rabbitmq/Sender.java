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
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.support.CorrelationData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Date;
//@Component
@Service
public class Sender implements RabbitTemplate.ConfirmCallback/*,
        RabbitTemplate.ReturnCallback*/ {

 /*   @Override
    public void returnedMessage(Message message, int replyCode, String replyText, String exchange, String routingKey) {
        System.out.println("callback confirm :");
    }*/
    private RabbitTemplate rabbitTemplate;
    /**
     * 构造方法注入
     */
     @Autowired
    public Sender(RabbitTemplate rabbitTemplate) {
         // 设置callBack 只能判断成功还是失败  不能知道是哪条消息
        rabbitTemplate.setConfirmCallback(this);
        this.rabbitTemplate = rabbitTemplate;
        //rabbitTemplate如果为单例的话，那回调就是最后设置的内容
//        rabbitTemplate.setReturnCallback(this);
    }

    
    // 设置callBack 只能判断成功还是失败  不能知道是哪条消息
    @Override
    public void confirm(CorrelationData correlationData, boolean ack, String cause) {
        System.out.println("send confirm :");
        if (ack) {
            System.out.println("消息成功消费");
        } else {
            System.out.println("消息消费失败:" + cause);
        }
        }


//    @Scheduled(fixedDelay = 10000L)
    public void send() {
       /* if (rabbitTemplate.isConfirmListener()) {
            rabbitTemplate.setConfirmCallback(new RabbitTemplate.ConfirmCallback() {
                @Override
                public void confirm(CorrelationData correlationData, boolean b, String s) {
                    System.out.println("send success");
                }
            });
        }*/
        String msg = "hello"+System.currentTimeMillis();
        System.out.println("send date:"+new Date()+",,"+msg);
        this.rabbitTemplate.convertAndSend("foo", msg);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}