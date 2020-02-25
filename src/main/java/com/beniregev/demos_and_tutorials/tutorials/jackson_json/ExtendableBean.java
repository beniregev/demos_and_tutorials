package com.beniregev.demos_and_tutorials.tutorials.jackson_json;

import com.fasterxml.jackson.annotation.JsonAnyGetter;

import java.util.Map;

public class ExtendableBean {
    private String name;
    private Map<String, String> properties;

    public ExtendableBean(String name) {
        this(name, null);
    }

    public ExtendableBean(String name, Map<String, String> properties) {
        this.name = name;
        this.setProperties(properties);
    }

    @JsonAnyGetter
    public Map<String, String> getProperties() {
        return properties;
    }

    public void setProperties(Map<String, String> properties) {
        this.properties = properties;
    }

    public void add(String key, String value) {
        this.properties.put(key, value);
    }
}
