package com.beniregev.demos_and_tutorials.examples.show_as_jason.model;

import com.beniregev.demos_and_tutorials.examples.show_as_jason.enums.AlaCarteType;
import com.beniregev.demos_and_tutorials.examples.show_as_jason.enums.BundleType;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.List;

public class ShowAsJsonExample {

    public static void main(String[] args) {
        List<AlaCarteType> alaCarteTypeList = new ArrayList<AlaCarteType>();
        alaCarteTypeList.add(AlaCarteType.create(1));
        alaCarteTypeList.add(AlaCarteType.create(3));
        alaCarteTypeList.add(AlaCarteType.create(5));
        alaCarteTypeList.add(AlaCarteType.create(0));

        List<IntegerRange> siteRangesList = new ArrayList<IntegerRange>();
        siteRangesList.add(new IntegerRange());
        siteRangesList.add(new IntegerRange());
        siteRangesList.add(new IntegerRange());

        List<BundleType> bundlesList = new ArrayList<BundleType>();
        bundlesList.add(BundleType.ENHANCED_VOICE);
        bundlesList.add(BundleType.SHARED_WORKSPACE);
        bundlesList.add(BundleType.CONTACT_CENTER);
        bundlesList.add(BundleType.BASIC);

        CustomerRequest customerRequest = new CustomerRequest();
        customerRequest.setId("cr-id-12345");
        customerRequest.setType("customer-request-type");
        customerRequest.setAlaCartes(alaCarteTypeList);
        customerRequest.setSiteRanges(siteRangesList);
        customerRequest.setBundles(bundlesList);

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            String json = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(customerRequest);
            System.out.println(json);
        } catch(Exception e) {
            e.printStackTrace();
        }

    }
}
