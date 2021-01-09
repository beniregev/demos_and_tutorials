package com.beniregev.demos_and_tutorials.project_lombok;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
public enum GenderType {
    FEMALE(1, "Female"),
    MALE(2, "Male");

    private int code;
    private String name;
}
