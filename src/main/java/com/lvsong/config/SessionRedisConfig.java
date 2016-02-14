package com.lvsong.config;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
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
    private static Log LOG = LogFactory.getLog(SessionRedisConfig.class);

    @Value("${session_redis.host}")
    private String host;

    @Value("${session_redis.password}")
    private String password;

    @Value(("${session_redis.port}"))
    private String port;


//    这里必须声明placeholderConfigurer，如果在配置文件里面声明，启动server时保持
    @Bean
    public static PropertySourcesPlaceholderConfigurer placeholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    @Bean
    public JedisConnectionFactory sessionJedisConnectionFactory() {
        JedisConnectionFactory factory = new JedisConnectionFactory();

        LOG.info("--------------------------------------");
        LOG.info("session redis host: " + host);
        LOG.info("session redis port: " + port);
        LOG.info("session redis password: " + password);
        LOG.info("--------------------------------------");
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
