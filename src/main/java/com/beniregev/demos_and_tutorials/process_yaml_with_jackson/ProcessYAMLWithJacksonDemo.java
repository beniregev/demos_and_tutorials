package com.beniregev.demos_and_tutorials.process_yaml_with_jackson;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.fasterxml.jackson.dataformat.yaml.YAMLGenerator.Feature;

import java.io.File;
import java.io.IOException;

public class ProcessYAMLWithJacksonDemo {

    public Order readingYaml() throws IOException {
        //  Use Jackson's ObjectMapper to read our YAML file into an Order object
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        // Need to use the findAndRegisterModules method so that Jackson will handle our Date properly
        mapper.findAndRegisterModules();
        //  Populate Order object from file
        Order order = mapper.readValue(new File("src/test/resources/yaml/orderInput.yaml"), Order.class);
        //  The Order object is now populated from the file, including the list of OrderLine
        return order;
    }

    /**
     * @see "src/test/resources/yaml/orderOutput.yaml"
     */
    public void writingYaml() {
        //  Use ObjectMapper to write an Order out to a file.
        //  But first, let's add some configuration to it
        ObjectMapper mapper = new ObjectMapper().disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        //  The above line tells Jackson to just write our date as a String instead of individual numeric parts

        //  By default, the file starts with three dashes. That's perfectly valid for the YAML
        //  format, but it can be turned-off by disabling the feature on the YAMLFactory
        mapper = new ObjectMapper(new YAMLFactory().disable(Feature.WRITE_DOC_START_MARKER));

    }

    public static void main(String[] args) {
        ProcessYAMLWithJacksonDemo demo = new ProcessYAMLWithJacksonDemo();

        try {
            Order order = demo.readingYaml();
        } catch (IOException e) {
            e.printStackTrace();
        }
        demo.writingYaml();

    }
}
