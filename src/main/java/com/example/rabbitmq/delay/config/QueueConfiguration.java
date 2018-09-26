package com.example.rabbitmq.delay.config;

import com.example.rabbitmq.delay.util.MQConstant;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * All rights Reserved, Designed By a.96bill.com
 *
 * @version V1.0
 * @Title: *.java
 * @Package com
 * @Description: TODO(用一句话描述该文件做什么)
 * @author: wuzhicheng
 * @date: 11:34 2018/8/3
 * @company:北京今汇在线
 */
@Configuration
@EnableAutoConfiguration
public class QueueConfiguration {

    @Bean
    public Queue repeatTradeQueue() {
        Queue queue = new Queue(MQConstant.DEFAULT_REPEAT_TRADE_QUEUE_NAME,true,false,false);
        return queue;
    }

    @Bean
    public Binding  drepeatTradeBinding() {
        return BindingBuilder.bind(repeatTradeQueue()).to(defaultExchange()).with(MQConstant.DEFAULT_REPEAT_TRADE_QUEUE_NAME);
    }


    @Bean
    public Queue delyQueue() {
        Queue queue = new Queue(MQConstant.DELAY,true,false,false);
        return queue;
    }

    @Bean
    public Binding  delyQueueBinding() {
        return BindingBuilder.bind(delyQueue()).to(defaultExchange()).with(MQConstant.DELAY);
    }

    @Bean
    public Queue deadLetterQueue() {
        Map<String, Object> arguments = new HashMap<>();
        arguments.put("x-dead-letter-exchange", MQConstant.DEFAULT_EXCHANGE);
        arguments.put("x-dead-letter-routing-key", MQConstant.DEFAULT_REPEAT_TRADE_QUEUE_NAME);
        Queue queue = new Queue(MQConstant.DEFAULT_DEAD_LETTER_QUEUE_NAME,true,false,false,arguments);
        System.out.println("arguments :" + queue.getArguments());
        return queue;
    }

    @Bean
    public Binding  deadLetterBinding() {
        return BindingBuilder.bind(deadLetterQueue()).to(defaultExchange()).with(MQConstant.DEFAULT_DEAD_LETTER_QUEUE_NAME);
    }


    @Bean
    public DirectExchange defaultExchange() {
        return new DirectExchange(MQConstant.DEFAULT_EXCHANGE, true, false);
    }



}
