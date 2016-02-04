package com.lvsong.dao.redis;

import com.lvsong.domain.session.UserSession;
import com.lvsong.util.Serializer;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.BoundHashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

/**
 * Created by lvsong on 2/3/16.
 */
@Component
public class SessionRedis {
    private final static Log LOG = LogFactory.getLog(SessionRedis.class);
    private final static String SESSION_KEY = "session";

    @Autowired
    private RedisTemplate sessionRedisTemplate;

    public void put(UserSession userSession) {
        hashOperations().put(userSession.getId(), Serializer.serializeAsString(userSession));
    }

    public UserSession get(String userSessionId) {
        return Serializer.deserializeAsObject(hashOperations().get(userSessionId), UserSession.class);
    }

    private BoundHashOperations<String, String, String> hashOperations() {
        return sessionRedisTemplate.boundHashOps(SESSION_KEY);
    }
}
