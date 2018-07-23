package com.example.rabbitmq.process;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * All rights Reserved, Designed By a.96bill.com
 *
 * @version V1.0
 * @Title: *.java
 * @Package com
 * @Description: TODO(用一句话描述该文件做什么)
 * @author: wuzhicheng
 * @date: 22:08 2018/5/10/010
 * @company:北京今汇在线
 */
@Component
public class ProcessTest {
    @RabbitListener(queues = "foo")   
    public void process(String message){
        System.out.println("process  message::"+new Date()+":"+message);
    }
}
