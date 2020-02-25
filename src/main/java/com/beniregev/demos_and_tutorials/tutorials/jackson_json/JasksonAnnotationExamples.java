package com.beniregev.demos_and_tutorials.tutorials.jackson_json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.HashMap;

public class JasksonAnnotationExamples {
    public static void main(String[] args) throws JsonProcessingException {
        ExtendableBean bean = new ExtendableBean("My bean", new HashMap<>());
        bean.add("attr1", "val1");
        bean.add("attr2", "val2");

        String result = new ObjectMapper().writeValueAsString(bean);
        System.out.println(bean);
    }
}
