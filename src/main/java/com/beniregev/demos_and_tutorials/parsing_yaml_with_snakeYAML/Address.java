package com.beniregev.demos_and_tutorials.parsing_yaml_with_snakeYAML;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Address {
    private String line;
    private String city;
    private String state;
    private Integer zip;
}
