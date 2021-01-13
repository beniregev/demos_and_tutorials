package com.beniregev.demos_and_tutorials.parsing_yaml_with_snakeYAML;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <div>
 *     <p>  The library also provides a way to load the document as a custom
 *          class. This option would allow easy traversal of data in memory. </p>
 *     <p>  Let's define a Customer class and try to load the document again: <br/>
 *          (In {@code Customer} using <i>lombok</i> for repeating code) </p>
 *     <p>  Assuming the YAML document to be deserialized as a known type,
 *          we can specify an explicit global tag in the document. We'll also
 *          update the document and store it in a new file {@code customer_with_type.yaml}: </p>
 * </div>
 */
@Data
@NoArgsConstructor
public class Customer {
    private String firstName;
    private String lastName;
    private int age;

}
