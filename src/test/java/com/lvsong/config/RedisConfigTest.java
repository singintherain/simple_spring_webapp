package com.lvsong.config;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * Created by lvsong on 2/3/16.
 */
public class RedisConfigTest {
    private ApplicationContext applicationContext;

    @Before
    public void setUp() {
        applicationContext = new ClassPathXmlApplicationContext("conf/applicationContext.xml");
    }

    @Test
    public void sessionRedisConfigTest() {
        RedisTemplate redisTemplate = applicationContext.getBean("sessionRedisTemplate", RedisTemplate.class);
        System.out.println(redisTemplate.getConnectionFactory().getConnection());
        Assert.assertNotNull(redisTemplate);
    }

    @Test
    public void jedisConnectionFactoryTest() {
        JedisConnectionFactory jedisConnectionFactory = applicationContext.getBean(
                "sessionJedisConnectionFactory", JedisConnectionFactory.class);
        System.out.println(jedisConnectionFactory.getPort());
        Assert.assertEquals(jedisConnectionFactory.getPort(), 6379);
    }
}
