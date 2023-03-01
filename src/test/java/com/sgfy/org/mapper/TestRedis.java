package com.sgfy.org.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * project : pethome
 *
 * @author:Sakura
 * @date:2023-02-24-Friday
 */

@SpringBootTest //以这种方式启动的原因：是redis连接服务器时，需要读取application.yml中的配置
@RunWith(SpringRunner.class)
public class TestRedis {

    @Autowired
    private StringRedisTemplate redisTemplate;



    @Test
    public void test01(){
        redisTemplate.opsForValue().set("name","周枭",100, TimeUnit.SECONDS);
    }



    @Test
    public void testAddList() {
         /*
            redis的数据存储特点：
                   redis在存取数据是，它运行在一个 【单线程中】

               当使用list容器来存储数据时，符合list容器的特点：
                   1.先进先出
                   2.list中的元素是有序的

            示例图：
              左                                 右
                -----------------------------
                71.5 91.5 99.5 81.5 51.5
                -----------------------------
         */
        String listKey = "score";

        redisTemplate.opsForList().leftPush("listKey", "99");
        redisTemplate.opsForList().leftPush("listKey", "91");
        redisTemplate.opsForList().rightPush("listKey", "81");
        redisTemplate.opsForList().leftPush("listKey", "71");
        redisTemplate.opsForList().rightPush("listKey", "51");
        //集合中的元素如何取值
        //从redis中获取key=listKey的集合中包含多少个元素
        Long size = redisTemplate.opsForList().size(listKey);
        for (long i = 0; i < size; i++) {
            System.out.println(redisTemplate.opsForList().index(listKey, i));
        }
    }

    @Test //添加hashmap类型的数据 ----->它就是对象类型的原型
    public void testAddHash() {
        String redisHashkey = "stuInfo";
        //eg: {"name":"张三","age":22,"address":"湖北武汉长城科技园"}
        redisTemplate.opsForHash().put(redisHashkey, "name", "张三");
        redisTemplate.opsForHash().put(redisHashkey, "age", 22);
        redisTemplate.opsForHash().put(redisHashkey, "address", "湖北武汉长城科技园");

        //如何获取它的值
        String name = (String) redisTemplate.opsForHash().get(redisHashkey, "name");
        System.out.println("name=" + name);
        Integer age = (Integer) redisTemplate.opsForHash().get(redisHashkey, "age");
        System.out.println("age="+age);
    }

    @Test
    public void testAddSet(){
        String redisHashkey = "stuNameSet";
        redisTemplate.opsForSet().add(redisHashkey,"张三");
        redisTemplate.opsForSet().add(redisHashkey,"李四");
        redisTemplate.opsForSet().add(redisHashkey,"张三");
        redisTemplate.opsForSet().add(redisHashkey,"李四");

        //如何取值？
        Set members = redisTemplate.opsForSet().members(redisHashkey);
        //如何遍历set中的数据
        for (Object member : members) {
            System.out.println("member="+member);

        }
    }

}
