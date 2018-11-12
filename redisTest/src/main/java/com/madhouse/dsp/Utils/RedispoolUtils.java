package com.madhouse.dsp.Utils;

import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * Created by Madhouse on 2017/9/21.
 */
public class RedispoolUtils {
    public static JedisPool jedisPoll;

    private static JedisPoolConfig getPollConfig() {
        JedisPoolConfig jpc = new JedisPoolConfig();
        jpc.setMaxTotal(100);
        jpc.setMaxIdle(10);
        jpc.setMaxWaitMillis(3000);
        return jpc;
    }

    private static JedisPool getPoll(String host, int port, int timeout, int database) {
        JedisPoolConfig poolConfig = getPollConfig();
        return new JedisPool(poolConfig, host, port, timeout, (String) null, database, (String) null);
    }

    public static void init() {
        String host = "10.10.49.33";
        int port = 6379;
        int timeout = 1000;
        int database = 0;
        jedisPoll = getPoll(host, port, timeout, database);
    }

    public static void close() {
        if (jedisPoll != null)
            jedisPoll.close();
    }
}
