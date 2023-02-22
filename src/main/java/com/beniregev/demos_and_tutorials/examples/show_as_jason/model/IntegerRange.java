package com.beniregev.demos_and_tutorials.examples.show_as_jason.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class IntegerRange {
    private final Integer from;
    private final Integer to;

    public IntegerRange() {
        this.from = 0;
        this.to = Integer.MAX_VALUE;
    }

    public Boolean inRange(Integer i) {
        return i <= to && i >= from;
    }
}
