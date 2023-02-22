package com.beniregev.demos_and_tutorials.examples.show_as_jason.model;

import com.beniregev.demos_and_tutorials.examples.show_as_jason.enums.AlaCarteType;
import com.beniregev.demos_and_tutorials.examples.show_as_jason.enums.BundleType;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class CustomerRequest {
    private String id;
    private String type;
    private List<IntegerRange> siteRanges;
    private List<AlaCarteType> alaCartes;
    private List<BundleType> bundles;
}
