package com.ldy.playground.start.web;

import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private RedissonClient redissonClient;

    @GetMapping("/test")
    public String test() {
        return "hello world";
    }

    @GetMapping("/lock")
    public String lock(String lockName) {
        RLock rLock = redissonClient.getLock(lockName);
        try {
            //尝试5秒内获取锁，如果获取到了，最长60秒自动释放
            boolean res = rLock.tryLock(5L, 60L, TimeUnit.SECONDS);
            if (res) {
                //成功获得锁，在这里处理业务
                return "lock success";
            } else {
                return "lock fail";
            }
        } catch (Exception e) {
            System.out.println("获取锁失败，失败原因：" + e.getMessage());
            return "lock fail";
        }
    }

    @GetMapping("/unlock")
    public String unlock(String lockName) {
        RLock rLock = redissonClient.getLock(lockName);
        try {
            rLock.unlock();
        } catch (Exception e) {
            return "unlock fail";
        }
        return "unlock success";
    }

}
