package com.example.rabbitmq.delay.send;

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

import com.example.rabbitmq.delay.service.IMessageQueueService;
import com.example.rabbitmq.delay.util.MQConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class DelaySender {

    @Autowired
    private IMessageQueueService messageQueueService;

//    @Scheduled(fixedDelay = 10000L)
    public void send() {
        Long  msg = System.currentTimeMillis();
        System.out.println("DelaySender "+msg+","+new Date());
        messageQueueService.send(MQConstant.DELAY,msg+"",5000);
    }

}