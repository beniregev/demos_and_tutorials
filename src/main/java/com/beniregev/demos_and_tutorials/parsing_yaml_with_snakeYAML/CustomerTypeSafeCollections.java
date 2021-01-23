package com.beniregev.demos_and_tutorials.parsing_yaml_with_snakeYAML;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * <div>
 *     <p>  The library also provides a way to load the document as a custom
 *          class. This option would allow easy traversal of data in memory. </p>
 *     <p>  Let's define a Customer class and try to load the document again: <br/>
 *          (In {@code Customer} using <i>lombok</i> for repeating code) </p>
 *     <p>  Assuming the YAML document to be deserialized as a known type,
 *          we can specify an explicit global tag in the document. We'll also
 *          update the document and store it in a new file <em>customer_with_contact_details_and_address.yaml</em>: </p>
 * </div>
 */
@Data
@NoArgsConstructor
public class CustomerTypeSafeCollections {
    private String firstName;
    private String lastName;
    private int age;
    private List<Contact> contactDetails;
    private Address homeAddress;

}
