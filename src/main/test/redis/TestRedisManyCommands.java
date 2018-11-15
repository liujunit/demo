package redis;

import org.junit.Before;
import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.List;

public class TestRedisManyCommands {

    JedisPool jedisPool;
    Jedis jedis;

    @Before
    public void setUp() {
        jedis = new Jedis("localhost");
    }

    /**
     * 测试字符串CRUD
     */
    @Test
    public void testBasicString() {
        //添加数据
        jedis.set("name", "LiuJun");
        System.out.println(jedis.get("name"));
        //修改原数据 在后面添加
        jedis.append("name", "007");
        System.out.println(jedis.get("name"));
        //直接覆盖原先的数据
        jedis.set("name", "Ljun");
        System.out.println(jedis.get("name"));
        //删除原先的数据
        jedis.del("name");
        System.out.println(jedis.get("name"));
        //多个字符串的设置
        jedis.mset("1","one","2","two");
        System.out.println(jedis.get("1"));
        System.out.println(jedis.get("2"));
        //返回的是一个字符串的数组
        System.out.println(jedis.mget("1", "2"));
    }

}
