package com.beniregev.demos_and_tutorials.project_lombok;

import lombok.Builder;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PersonAdvanced {
    private int id;
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private GenderType gender;
    private String email;
    private InternationalPhoneNumber internationalPhoneNumber;

}
