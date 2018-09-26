package com.example.rabbitmq.sender;

/**
 * All rights Reserved, Designed By a.96bill.com
 *
 * @version V1.0
 * @Title: *.java
 * @Package com
 * @Description: TODO(用一句话描述该文件做什么)
 * @author: wuzhicheng
 * @date: 17:28 2018/8/23
 * @company:北京今汇在线
 */
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Date;
@Component
//@Service
public class HelloSender implements RabbitTemplate.ReturnCallback {

    @Autowired
    private RabbitTemplate rabbitTemplate;
    
//    @Scheduled(fixedDelay = 10000L)
    public void send() {
        String context = "你好现在是 " + new Date() +"";
        System.out.println("HelloSender发送内容 : " + context);
        this.rabbitTemplate.setReturnCallback(this);
    /*    this.rabbitTemplate.setConfirmCallback((correlationData, ack, cause) -> {
            if (!ack) {
                System.out.println("HelloSender消息发送失败" + cause + correlationData.toString());
            } else {
                System.out.println("HelloSender 消息发送成功 ");
            }
        });*/
        this.rabbitTemplate.convertAndSend("hello", context);
    }

    /*public void sendObj() {
        MessageObj obj = new MessageObj();
        obj.setACK(false);
        obj.setId(123);
        obj.setName("zhangsan");
        obj.setValue("data");
        System.out.println("发送 : " + obj);
        this.rabbitTemplate.convertAndSend("helloObj", obj);
    }*/

    @Override
    public void returnedMessage(Message message, int i, String s, String s1, String s2) {
        System.out.println("sender return success" + message.toString()+"==="+i+"==="+s1+"==="+s2);
    }

//    @Override
//    public void confirm(CorrelationData correlationData, boolean b, String s) {
//        System.out.println("sender success");
//    }


}
