package com.example.rabbitmq.delay.process;

import com.example.rabbitmq.delay.util.MQConstant;
import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Date;

/**
 *
 * @author victor
 * @desc 死信接收处理消费者
 */
@Component
@RabbitListener(queues = MQConstant.DELAY)
public class DelayProcessor{

    @RabbitHandler
    public void process(String content, Channel channel, Message message) {
        System.out.println("DelayProcessor  process::"+new Date()+":"+content);
        try {
            channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
        } catch (IOException e) {
            e.printStackTrace();
        }
//        DLXMessage message =  JSON.parseObject(content, DLXMessage.class);
//        System.out.println(message);
    }

}
