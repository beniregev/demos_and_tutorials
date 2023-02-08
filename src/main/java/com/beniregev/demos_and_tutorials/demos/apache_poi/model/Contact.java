package com.beniregev.demos_and_tutorials.demos.apache_poi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Contact {
    private String firstName;
    private String lastName;
    private String email;
    private String dateOfBirth;

}
