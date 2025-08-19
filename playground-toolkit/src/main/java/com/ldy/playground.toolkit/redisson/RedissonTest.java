package com.ldy.playground.toolkit.redisson;

import org.redisson.Redisson;
import org.redisson.api.*;
import org.redisson.client.codec.StringCodec;
import org.redisson.config.Config;

/**
 * <a href="https://github.com/redisson/redisson/wiki/Redisson%E9%A1%B9%E7%9B%AE%E4%BB%8B%E7%BB%8D">redisson 功能简介</a>
 */
public class RedissonTest {

    private static final RedissonClient REDISSON_CLIENT;

    static {
        //1、创建配置
        Config config = new Config();
        // 连接必须要以 redis 开头~ 有密码填密码
        config.useSingleServer().setAddress("redis://127.0.0.1:6379");

        //2、设置存储解析编码
        config.setCodec(new StringCodec());

        //3、根据Config创建出RedissonClient实例
        //Redis url should start with redis:// or rediss://
        REDISSON_CLIENT = Redisson.create(config);
    }

    public static RedissonClient getRedissonClient() {
        return REDISSON_CLIENT;
    }

    public static void closeCli() {
        getRedissonClient().shutdown();
    }

    public void kvTest() {
        System.out.println("=========kvTest========");
        RedissonClient redissonClient = getRedissonClient();
        RBucket<String> rBucket = redissonClient.getBucket("ldy");
        rBucket.set("hello");
        System.out.println(rBucket.get());
        System.out.println("=========kvTest========");
    }

    public void hashTest() {
        System.out.println("=========hashTest========");
        RedissonClient redissonClient = getRedissonClient();
        RMap<String, String> rMap = redissonClient.getMap("ldy-map");
        rMap.put("ldy-hash", "hello");
        System.out.println(rMap.get("ldy-hash"));
        System.out.println("=========hashTest========");
    }

    public void listTest() {
        System.out.println("=========listTest========");

        RedissonClient redissonClient = getRedissonClient();
        RList<String> rList = redissonClient.getList("ldy-list");
        rList.add("hello");
        rList.add("world");
        System.out.println(rList.readAll());
        System.out.println("=========listTest========");

    }

    public void setTest() {
        System.out.println("=========setTest========");

        RedissonClient redissonClient = getRedissonClient();
        RSet<String> rSet = redissonClient.getSet("ldy-set");
        rSet.add("hello");
        rSet.add("world");
        System.out.println(rSet.readAll());
        System.out.println("=========setTest========");

    }

    public void zsetTest() {
        System.out.println("=========zsetTest========");

        RedissonClient redissonClient = getRedissonClient();
        RSortedSet<String> rSortedSet = redissonClient.getSortedSet("ldy-zset");
        rSortedSet.add("world");
        rSortedSet.add("hello");
        System.out.println(rSortedSet.readAll());
        System.out.println("=========zsetTest========");

    }

    public static void main(String[] args) {
        RedissonTest redissonTest = new RedissonTest();
        redissonTest.kvTest();
        redissonTest.hashTest();
        redissonTest.listTest();
        redissonTest.setTest();
        redissonTest.zsetTest();

        closeCli();
    }
}
