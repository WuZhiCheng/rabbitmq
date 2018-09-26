package com.example.rabbitmq.config;

/**
 * All rights Reserved, Designed By a.96bill.com
 *
 * @version V1.0
 * @Title: *.java
 * @Package com
 * @Description: TODO(用一句话描述该文件做什么)
 * @author: wuzhicheng
 * @date: 17:27 2018/8/23
 * @company:北京今汇在线
 */
import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.ChannelAwareMessageListener;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {

  /*  @Bean
    public Queue QueueA() {
        return new Queue("hello");
    }

    @Bean
    public Queue QueueB() {
        return new Queue("helloObj");
    }

    *//**
     * Fanout 就是我们熟悉的广播模式或者订阅模式，给Fanout交换机发送消息，绑定了这个交换机的所有队列都收到这个消息。
     * @return
     *//*
    @Bean
    FanoutExchange fanoutExchange() {
        return new FanoutExchange("ABExchange");
    }


    @Bean
    Binding bindingExchangeA(Queue QueueA, FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(QueueA).to(fanoutExchange);
    }

    @Bean
    Binding bindingExchangeB(Queue QueueB, FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(QueueB).to(fanoutExchange);
    }*/

}
