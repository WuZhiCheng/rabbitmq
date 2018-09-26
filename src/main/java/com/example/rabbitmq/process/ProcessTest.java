package com.example.rabbitmq.process;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Date;

/**
 * All rights Reserved, Designed By a.96bill.com
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
    @RabbitListener(queues = "foo")   //@Payload  :hello1535019930360
//    public void process(String message){       hello1535079924992
    public void process(String msg, Channel channel, Message message) throws Exception{
        System.out.println("process  message::"+new Date()+":"+msg);
        try {
//            System.out.println(1/0);
            channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
        } catch (Exception e) {
            // 处理消息失败，将消息重新放回队列
//            try {
            // 开启retry的话    不能返回拒绝消息  否则会一直发送
//            api参考  https://www.cnblogs.com/piaolingzxh/p/5448927.html
//                channel.basicNack(message.getMessageProperties().getDeliveryTag(), false,true);
//            } catch (Exception e1) {
//                e1.printStackTrace();
//            }
            e.printStackTrace();
            throw new Exception();
        }
    }
}
