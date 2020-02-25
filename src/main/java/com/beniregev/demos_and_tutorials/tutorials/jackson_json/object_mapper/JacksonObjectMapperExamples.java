package com.beniregev.demos_and_tutorials.tutorials.jackson_json.object_mapper;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class JacksonObjectMapperExamples {
    private void generateJsonUsingObjectAndArrayNodes() {
        //create ObjectMapper instance
        ObjectMapper objectMapper = new ObjectMapper();
        ObjectNode root = objectMapper.createObjectNode();
        root.put("iSegmentId", "2936459873");
        root.put("SegmentGMTStartTime", "2020-01-05 12:34:56.789");
        root.put("SegmentGMTStopTime", "2020-01-05 12:34:56.789");
        ArrayNode recordingsArray = objectMapper.createArrayNode();
        recordingsArray.add("1").add("3");
        root.putPOJO("recordings", recordingsArray);
        root.put("BinaryValue", true);

        ArrayNode arrayNode = objectMapper.createArrayNode();
        ObjectNode objectNode1 = objectMapper.createObjectNode();
        objectNode1.put("bookName", "Java");
        objectNode1.put("price", "100");

        ObjectNode objectNode2 = objectMapper.createObjectNode();
        objectNode2.put("bookName", "Spring");
        objectNode2.put("price", "200");

        ObjectNode objectNode3 = objectMapper.createObjectNode();
        objectNode3.put("bookName", "Hibernate");
        objectNode3.put("price", "500");

        /**
         * Array contains JSON Objects
         */
        arrayNode.add(objectNode1)
                .add(objectNode2)
                .add(objectNode3);


        root.putPOJO("ArrayNodes", arrayNode);
        try {
            System.out.println(objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(root));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        JacksonObjectMapperExamples example = new JacksonObjectMapperExamples();
        example.generateJsonUsingObjectAndArrayNodes();
    }

}
