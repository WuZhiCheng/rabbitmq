package com.example.rabbitmq.delay.service.impl;

/**
 * All rights Reserved, Designed By a.96bill.com
 *
 * @version V1.0
 * @Title: *.java
 * @Package com
 * @Description: TODO(用一句话描述该文件做什么)
 * @author: wuzhicheng
 * @date: 11:51 2018/8/3
 * @company:北京今汇在线
 */
import com.alibaba.fastjson.JSON;
import com.example.rabbitmq.delay.bean.DLXMessage;
import com.example.rabbitmq.delay.service.IMessageQueueService;
import com.example.rabbitmq.delay.util.MQConstant;
import org.springframework.amqp.AmqpException;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessagePostProcessor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author victor
 * @desc 消息队列服务接口实现
 */
@Service("messageQueueService")
public class MessageQueueServiceImpl implements IMessageQueueService {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Override
    public void send(String queueName, String msg) {
        //MQConstant.DEFAULT_EXCHANGE,
        rabbitTemplate.convertAndSend(queueName, msg);
    }

    @Override
    public void send(String queueName, String msg, long times) {
        DLXMessage dlxMessage = new DLXMessage(queueName,msg,times);
        MessagePostProcessor processor = new MessagePostProcessor(){
            @Override
            public Message postProcessMessage(Message message) throws AmqpException {
                message.getMessageProperties().setExpiration(times + "");
                return message;
            }
        };
        dlxMessage.setExchange(MQConstant.DEFAULT_EXCHANGE);
        rabbitTemplate.convertAndSend(MQConstant.DEFAULT_EXCHANGE,MQConstant.DEFAULT_DEAD_LETTER_QUEUE_NAME,
                JSON.toJSONString(dlxMessage), processor);
    }



}
