package com.ldy.playground.start.config;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RedissionConfig {

    @Bean
    public RedissonClient redissonClient() {
        //1、创建配置
        Config config = new Config();
        // 连接必须要以 redis 开头~ 有密码填密码
        config.useSingleServer().setAddress("redis://127.0.0.1:6379");
        //2、根据Config创建出RedissonClient实例
        //Redis url should start with redis:// or rediss://
        return Redisson.create(config);
    }
}
