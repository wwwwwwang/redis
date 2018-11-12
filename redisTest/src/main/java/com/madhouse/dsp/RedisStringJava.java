package com.madhouse.dsp;

import redis.clients.jedis.Jedis;

/**
 * Created by Madhouse on 2017/9/20.
 */
public class RedisStringJava {
    public void test() {
        Jedis jedis = new Jedis("localhost");
        System.out.println("连接成功");

        jedis.set("runoobkey", "www.runoob.com");

        System.out.println("redis : "+ jedis.get("runoobkey"));
    }
}
