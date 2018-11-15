package redis;

import redis.clients.jedis.Jedis;

public class redis01 {

    public static void main(String[] args) {
        Jedis jedis = new Jedis("localhost");
        jedis.set("string", "hello");
        String string = jedis.get("string");
        System.out.println(string);
    }

}
