package com.madhouse.dsp;

import redis.clients.jedis.Jedis;

import java.util.List;

/**
 * Created by Madhouse on 2017/9/20.
 */
public class RedisListJava {
    public void test() {
        Jedis jedis = new Jedis("localhost");
        System.out.println("连接成功");
        jedis.lpush("site-list", "Runoob");
        jedis.lpush("site-list", "Google");
        jedis.lpush("site-list", "Taobao");
        List<String> list = jedis.lrange("site-list", 0 ,2);
        for(int i=0; i<list.size(); i++) {
            System.out.println("列表项为: "+list.get(i));
        }
    }
}
