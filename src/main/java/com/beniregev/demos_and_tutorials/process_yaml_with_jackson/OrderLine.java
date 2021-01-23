package com.beniregev.demos_and_tutorials.process_yaml_with_jackson;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderLine {
    private String item;
    private int quantity;
    private BigDecimal unitPrice;

}
