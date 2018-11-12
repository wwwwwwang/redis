package com.madhouse.dsp;

import redis.clients.jedis.Jedis;

/**
 * Created by Madhouse on 2017/9/20.
 */
public class RedisJava {
    private void test() {
        //String host = "localhost";
        String host = "10.10.49.33";
        int port = 6379;
        Jedis jedis = new Jedis(host, port);
        System.out.println("服务正在运行: "+jedis.ping());
        System.out.println("连接成功");
    }
}
