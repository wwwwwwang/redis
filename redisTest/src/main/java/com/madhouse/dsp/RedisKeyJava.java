package com.madhouse.dsp;

import com.madhouse.dsp.Utils.RedispoolUtils;
import redis.clients.jedis.Jedis;

import java.util.Set;

/**
 * Created by Madhouse on 2017/9/20.
 */
public class RedisKeyJava {
    public static void main(String[] args){
        /*String host = "10.10.49.33";
        int port = 6379;
        Jedis jedis = new Jedis(host, port);
        System.out.println("连接成功");*/

        RedispoolUtils.init();
        Jedis jedis = RedispoolUtils.jedisPoll.getResource();
        Set<String> keys = jedis.keys("*");
        for (String key : keys) {
            System.out.println(key);
            String type = jedis.type(key);
            System.out.print("type = " + type);
            if(type.equalsIgnoreCase("string")){
                String value = jedis.get(key);
                System.out.println(", value = " + value);
            }else{
                System.out.println("");
            }
        }

        jedis.close();
        RedispoolUtils.close();
    }
}
