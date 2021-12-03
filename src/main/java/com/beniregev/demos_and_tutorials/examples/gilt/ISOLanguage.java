package com.beniregev.demos_and_tutorials.examples.gilt;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ISOLanguage {
    private String name;
    private String codeIso2;
    private String codeIso3;
    private String tag;
}
