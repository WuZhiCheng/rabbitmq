package com.example.rabbitmq.config;

import com.rabbitmq.client.ConfirmCallback;
import org.springframework.amqp.rabbit.support.CorrelationData;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * All rights Reserved, Designed By a.96bill.com
 *
 * @version V1.0
 * @Title: *.java
 * @Package com
 * @Description: TODO(用一句话描述该文件做什么)
 * @author: wuzhicheng
 * @date: 11:42 2018/8/24
 * @company:北京今汇在线
 */
@Component
public class ConfirmCallBackListener implements ConfirmCallback {

    @Override
    public void handle(long deliveryTag, boolean multiple) throws IOException {
        System.out.println(deliveryTag+",,"+multiple);
    }
}
