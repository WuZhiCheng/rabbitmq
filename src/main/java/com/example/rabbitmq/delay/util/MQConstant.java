package com.example.rabbitmq.delay.util;

/**
 * All rights Reserved, Designed By a.96bill.com
 *
 * @version V1.0
 * @Title: *.java
 * @Package com
 * @Description: TODO(用一句话描述该文件做什么)
 * @author: wuzhicheng
 * @date: 11:43 2018/8/3
 * @company:北京今汇在线
 */
public class MQConstant {
    private MQConstant(){
    }

    //exchange name
    public static final String DEFAULT_EXCHANGE = "KSHOP";

    //DLX QUEUE
    public static final String DEFAULT_DEAD_LETTER_QUEUE_NAME = "kshop.dead.letter.queue";

    //DLX repeat QUEUE 死信转发队列
    public static final String DEFAULT_REPEAT_TRADE_QUEUE_NAME = "kshop.repeat.trade.queue";

    public static final String DELAY =  "delayProcess";
 
}
