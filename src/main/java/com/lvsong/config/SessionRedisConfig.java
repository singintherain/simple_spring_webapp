package com.lvsong.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Component;

/**
 * Created by lvsong on 2/3/16.
 */
@Configuration
@Component
@PropertySource("classpath:/conf/persistence.properties")
public class SessionRedisConfig {
    @Value("${session_redis.host}")
    private String host;

    @Value("${session_redis.password}")
    private String password;

    @Value(("${session_redis.port}"))
    private String port;

    @Bean
    public JedisConnectionFactory sessionJedisConnectionFactory() {
        JedisConnectionFactory factory = new JedisConnectionFactory();

        factory.setHostName(host);
        factory.setPassword(password);
        factory.setUsePool(true);
        factory.setPort(Integer.valueOf(port));

        return factory;
    }

    @Bean
    public RedisTemplate sessionRedisTemplate() {
        RedisTemplate redisTemplate = new RedisTemplate();

        redisTemplate.setConnectionFactory(sessionJedisConnectionFactory());
        redisTemplate.setDefaultSerializer(new StringRedisSerializer());

        return redisTemplate;
    }


}
