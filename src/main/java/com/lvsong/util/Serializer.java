package com.lvsong.util;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.data.redis.serializer.SerializationException;

/**
 * Created by lvsong on 2/3/16.
 */
public class Serializer {
    private static ObjectMapper objectMapper = new ObjectMapper();

    /**
     * Serialize java-object as json-string
     * @param object
     * @return json-string
     **/
    public static String serializeAsString(Object object){

        if (object== null) {
            return "{}";
        }

        try {
            return objectMapper.writeValueAsString(object);

        } catch (Exception ex) {
            throw new SerializationException("Could not write JSON: " + ex.getMessage(), ex);
        }
    }

    /**
     * Deserialize json-string to java-object
     * @param str
     * @return java-object
     **/
    public static <T> T deserializeAsObject(String str,Class<T> clazz){
        if(str == null || clazz == null){
            return null;
        }

        try{
            return objectMapper.readValue(str, clazz);
        }catch (Exception ex) {
            throw new SerializationException("Could not write JSON: " + ex.getMessage(), ex);
        }
    }
}
