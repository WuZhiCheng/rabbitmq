package com.example.rabbitmq.delay.process;

import com.alibaba.fastjson.JSON;
import com.example.rabbitmq.delay.bean.DLXMessage;
import com.example.rabbitmq.delay.service.IMessageQueueService;
import com.example.rabbitmq.delay.util.MQConstant;
import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Date;

/**
 *
 * @author victor
 * @desc 死信接收处理消费者
 */
@Component
@RabbitListener(queues = MQConstant.DEFAULT_REPEAT_TRADE_QUEUE_NAME)
public class TradeProcessor {

    @Autowired
    private IMessageQueueService messageQueueService;

    @RabbitHandler
    public void process(String content, Channel channel, Message messages) {
        System.out.println("TradeProcessor  message::"+new Date()+":"+content);
        DLXMessage message =  JSON.parseObject(content, DLXMessage.class);
        messageQueueService.send(message.getQueueName(), message.getContent());
        try {
            channel.basicAck(messages.getMessageProperties().getDeliveryTag(), false);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
