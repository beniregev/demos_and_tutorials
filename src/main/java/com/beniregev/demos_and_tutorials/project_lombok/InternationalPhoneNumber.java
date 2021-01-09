package com.beniregev.demos_and_tutorials.project_lombok;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InternationalPhoneNumber {
    private int countryCode;
    private String carrierCode;
    private long nationalNumber;
}
