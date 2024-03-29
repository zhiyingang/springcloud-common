package cn.v5cn.springboot.redisson.controller;

import org.redisson.api.RBlockingQueue;
import org.redisson.api.RDelayedQueue;
import org.redisson.api.RBlockingQueue;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

/**
 * @author ZYW
 * @version 1.0
 * @date 2019-08-02 21:29
 */
@Service
public class SendReadMsg {
    @Autowired
    private RedissonClient redisson;

    public void sendMsg(String msg){
        RBlockingQueue<String> demo = redisson.getBlockingQueue("demo");
        RDelayedQueue<String> delayedQueue = redisson.getDelayedQueue(demo);
        String format = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        delayedQueue.offerAsync("dda" + System.currentTimeMillis(),10, TimeUnit.SECONDS);
        System.out.println("消息发送完成：" + format);
        delayedQueue.destroy();
    }

    public String readMsg() throws InterruptedException {
        RBlockingQueue<String> demo = redisson.getBlockingQueue("demo");
        return demo.take();
    }
}
