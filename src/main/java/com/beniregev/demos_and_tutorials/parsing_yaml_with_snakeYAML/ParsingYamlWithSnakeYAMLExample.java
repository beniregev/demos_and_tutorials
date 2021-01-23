package com.beniregev.demos_and_tutorials.parsing_yaml_with_snakeYAML;

import org.yaml.snakeyaml.Yaml;

import java.io.InputStream;
import java.util.Map;

/**
 * <div>
 *     <p>
 *         <h1>Parsing YAML with SnakeYAML</h1>
 *     </p>
 *     <p>
 *         <h2>1. Overview </h2>
 *         <p>  In this example, we'll see how to use SnakeYAML library
 *              to <b>serialize Java objects to YAML documents and vice
 *              versa.</b></p>
 *     </p>
 *     <p>
 *         <h2>2. Project Setup</h2>
 *         <p>  In order to use SnakeYAML in our project, we'll add the
 *              following Maven dependency (the latest version can be
 *              found here): </p>
 *         <p>
 *         <code>
 *              &lt;dependency&gt;
 *                  &lt;groupId&gt;org.yaml&lt;/groupId&gt;
 *                  &lt;artifactId&gt;snakeyaml&lt;/artifactId&gt;
 *                  &lt;version&gt;1.21&lt;/version&gt;
 *              &lt;/dependency&gt;
 *         </code>
 *         </p>
 *     </p>
 *     <p>
 *         <h2>3. Entry Point</h2>
 *         <p>  The <em>Yaml</em> class is the entry point for the API: </p>
 *         <p>
 *             <code> Yaml yaml = new Yaml(); </code>
 *         </p>
 *         <p>  Since the implementation is not thread safe, different
 *              threads must have their own <em>Yaml</em> instance. </p>
 *     </p>
 *     <p>
 *         <h2>4. Loading a YAML Document</h2>
 *         <p>  The library provides support for loading the document from
 *              a String or an InputStream. Majority of the code samples
 *              here would be based on parsing the InputStream. </p>
 *         <p>  Let's start by defining a simple YAML document, and naming
 *              the file as <em>customer.yaml</em> - see {@link #loadingYamlBasicUsage()}: </p>
 *     </p>
 *     <p>
 *         <h2>4.1. Basic Usage</h2>
 *         <h2>4.2. Custom Type</h2>
 *         <h2>4.3. Implicit Types</h2>
 *         <h2>4.4. Nested Objects And Collections</h2>
 *         <h2>4.5. Type-Safe Collections</h2>
 *         <h2>4.6. Loading Multiple Documents</h2>
 *     </p>
 *     <p>
 *         <h2>5. Dumping YAML Document</h2>
 *     </p>
 *     <p>
 *         <h2>5.1. Basic Usage</h2>
 *         <h2>5.2. Custom Java Objects</h2>
 *     </p>
 *     <p>
 *         <h2>6. Conclusion</h2>
 *         <p>  This article illustrated usages of SnakeYAML library to serialize Java objects to YAML and vice versa.</p>
 *         <p>  All of the examples can be found in the GitHub project – this is a Maven based project, so it should be easy to import and run as it is. </p>
 *     </p>
 * </div>
 *
 * @author Binyamin Regev
 * @see #loadingYamlBasicUsage()
 */
public class ParsingYamlWithSnakeYAMLExample {
    /**
     * <div>
     *     <h2>4. Loading a YAML Document</h2>
     *     <h2>4.1. Basic Usage</h2>
     *     <p>  Parse the above YAML document with the <em>Yaml</em> class:</p>
     *     <p>  The method code will generates the following output: </p>
     *     <p>
     *         <code> {firstName=John, lastName=Doe, age=20} </code>
     *     </p>
     *     <p>  By default, the load() method returns a Map instance. Querying
     *          the Map object each time would require us to know the property
     *          key names in advance, and it's also not easy to traverse over
     *          nested properties.
     *     </p>
     * </div>
     */
    public void loadingYamlBasicUsage() {
        Yaml yaml = new Yaml();
        InputStream inputStream = this.getClass()
                .getClassLoader()
                .getResourceAsStream("yaml/customer_basic.yaml");
        Map<String, Object> obj = yaml.load(inputStream);
        System.out.println(obj);
    }

    /**
     * <div>
     *     <h2>4. Loading a YAML Document</h2>
     *     <h2>4.2. Custom Type</h2>
     *     <p>  The library also <b>provides a way to load the document as a custom
     *          class</b>. This option would allow easy traversal of data in memory. </p>
     *     <p>  Using the {@link Customer} class and try to load the document again. </p>
     *     <p>  Assuming the YAML document to be deserialized as a known type, we
     *          can specify an explicit global tag in the document. </p>
     *     <p>  Update the document and store it as a new file <em>customer_with_type.yaml</em>: </p>
     *     <p>  Note the first line in the document, which holds the info about the
     *          class to be used when loading it. </p>
     *     <p>  Next, update the code used in method {@link #loadingYamlBasicUsage()},
     *          and pass the new file name as input. </p>
     *     <p>  The {@code load()} method now returns an instance of <em>Customer</em> type.
     *          <b>The drawback to this approach is that the type has to be exported as a
     *          library in order to be used where needed</b>. </p>
     *     <p>  Although, we could use the explicit local tag for which we aren't required to export libraries. </p>
     *     <p>  <b>Another way of loading a custom type is by using the <em>Constructor</em>
     *          class</b>. This way we can specify the root type for a YAML document to be
     *          parsed. Let us create a <em>Constructor</em> instance with the <em>Customer</em>
     *          type as root type and pass it to the <em>Yaml</em> instance.</p>
     *     <p>  Now on loading the <em>customer_basic.yaml</em>, we'll get the Customer object: </p>
     *     <p>
     *         <code> Yaml yaml = new Yaml(new Constructor(Customer.class)); </code>
     *     </p>
     * </div>
     */
    public void loadingYamlCustomTypes() {
        Yaml yaml = new Yaml();
        InputStream inputStream = this.getClass()
                .getClassLoader()
                .getResourceAsStream("yaml/customer_with_type.yaml");
        Customer customer = yaml.load(inputStream);
        System.out.println(customer);
    }

    /**
     * <div>
     *     <h2>4. Loading a YAML Document</h2>
     *     <h2>4.3. Implicit Types</h2>
     *     <p><b>In case there's no type defined for a given property, the library automatically converts the value to an implicit type.</b></p>
     *     <p>
     *         <div>For example:</div>
     *         <code>
     *             1.0 -> Float
     *             42 -> Integer
     *             2009-03-30 -> Date
     *         </code>
     *     </p>
     *     <p>  Let's test this implicit type conversion using a test case: </p>
     * </div>
     */
    public void loadingYamlImplicitTypes() {
        Yaml yaml = new Yaml();
        Map<Object, Object> document = yaml.load("3.0: 2018-07-18");
        //assertNotNull(document);
        if (document != null) {
            //assertEquals(1, document.size());
            if (document.size() == 1) {
                //assertTrue(document.containsKey(3.0d));
                System.out.println("document.containsKey(3.0d) --> " + document.containsKey(3.0d));
            }
        }
    }

    /**
     * <div>
     *     <h2>4. Loading a YAML Document</h2>
     *     <h2>4.4. Nested Objects And Collections</h2>
     *     <p>  <b>Given a top-level type, the library automatically detects the types
     *          of nested objects</b>, unless they're an interface or an abstract class,
     *          and deserializes the document into the relevant nested type.</p>
     *     <p>  Let's add Contact and Address details to the <em>customer_basic.yaml</em>,
     *          and save the new file as <em>customer_with_contact_details_and_address.yaml</em>. </p>
     *     <p>  Now we'll parse the new YAML document: </p>
     *     <p>
     *         <code>
     *             firstName: "John"
     *             lastName: "Doe"
     *             age: 31
     *             contactDetails:
     *                - type: "mobile"
     *                  number: 123456789
     *                - type: "landline"
     *                  number: 456786868
     *             homeAddress:
     *                line: "Xyz, DEF Street"
     *                city: "City Y"
     *                state: "State Y"
     *                zip: 345657
     *         </code>
     *     </p>
     *     <p>  <em>Customer</em> class should also reflect these changes. Here's
     *          the updated class: </p>
     *     <p>
     *
     *     </p>
     *     <p></p>
     *     <p></p>
     *     <p></p>
     *     <p></p>
     * </div>
     */
    public void loadingYamlTypeSafeCollections() {

    }

    /**
     * <div>
     *     <p>
     *         <h2>4. Loading a YAML Document</h2>
     *         <h2>4.5. Type-Safe Collections</h2>
     *     </p>
     * </div>
     */
    public void loadingYamlNestedObjectsAndCollections() {

    }

    /**
     * <div>
     *     <p>
     *         <h2>4. Loading a YAML Document</h2>
     *         <h2>4.6. Loading Multiple Documents</h2>
     *     </p>
     * </div>
     */
    public void loadingYamlMultipleDocuments() {

    }

    /**
     * <div>
     *     <p>
     *         <h2>5. Dumping YAML Document</h2>
     *         <h2>5.1. Basic Usage</h2>
     *     </p>
     * </div>
     */
    public void dumpingYamlBasicUsage() {

    }

    /**
     * <div>
     *     <p>
     *         <h2>5. Dumping YAML Document</h2>
     *         <h2>5.2. Custom Java Objects</h2>
     *     </p>
     * </div>
     */
    public void dumpingYamlCustomJavaObjects() {

    }

    public static void main(String[] args) {
        ParsingYamlWithSnakeYAMLExample example = new ParsingYamlWithSnakeYAMLExample();
        example.loadingYamlBasicUsage();
        example.loadingYamlCustomTypes();
        example.loadingYamlImplicitTypes();
        example.loadingYamlTypeSafeCollections();
        example.loadingYamlNestedObjectsAndCollections();
        example.loadingYamlMultipleDocuments();
        example.dumpingYamlBasicUsage();
        example.dumpingYamlCustomJavaObjects();

    }
}
