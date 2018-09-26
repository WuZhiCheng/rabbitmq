package com.example.rabbitmq.controller;

import com.example.rabbitmq.Sender;
import com.example.rabbitmq.delay.send.DelaySender;
import com.example.rabbitmq.sender.HelloSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * All rights Reserved, Designed By a.96bill.com
 *
 * @version V1.0
 * @Title: *.java
 * @Package com
 * @Description: TODO(用一句话描述该文件做什么)
 * @author: wuzhicheng
 * @date: 17:40 2018/8/23
 * @company:北京今汇在线
 */
@RestController
public class TestController {
    @Autowired(required = false)
    private HelloSender helloSender;

    @Autowired(required = false)
    private Sender sender;

    @Autowired(required = false)
    private DelaySender delaySender;

    /**
     * 单生产者-单个消费者
     */
    @GetMapping("/test")
    public String hello() throws Exception {
        helloSender.send();
        return "hahahahahhhahhah";
    }

    /**
     * 单生产者-单个消费者
     */
    @GetMapping("/delay")
    public String delay() throws Exception {
        delaySender.send();
        return "hahahahahhhahhah";
    }


    @GetMapping("/foo")
    public String foo() throws Exception {
        sender.send();
        return "hahahahahhhahhah";
    }

}
