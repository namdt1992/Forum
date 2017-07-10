package com.forum.util;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.hibernate5.Hibernate5Module;

/**
 * @author NamDT8
 *
 */

public class Jackson {

    public static  String java2Json(Object object, Class  <?>... viewClasses) {

        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new Hibernate5Module());
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        String json = "";
    try {

        if(viewClasses.length == 1) {

            json = mapper.writerWithView(viewClasses[0]).writeValueAsString(object);
        } else {
            json = mapper.writeValueAsString(object);
        }
    } catch (JsonProcessingException e) {
        e.printStackTrace();
    }

    return json;
}
/*
    public static <T extends Object> T json2Java(String json, Class<T> clazz) {

        ObjectMapper mapper = new ObjectMapper();
        T t = null;

        try {
            t = mapper.readValue(json, clazz);
        } catch(IOException ex) {
            //log ex
        }

        return t;
    }

    public static <T extends Object> T json2Java(InputStream json, Class<T> clazz) {

        ObjectMapper mapper = new ObjectMapper();
        T t = null;

        try {
            t = mapper.readValue(json, clazz);
        } catch(IOException ex) {
            //log ex
        }

        return t;
    }
    */
}
