package com.beniregev.demos_and_tutorials.project_lombok;

import lombok.Data;

/**
 * <div>
 *     <p>
 *         <ul>Prerequisites:
 *         <li>Add {@code projectlombok} dependency to your project.</li>
 *         <li>Reimport your project dependencies to verify you have lombok support.</li>
 *         <li>Make sure your IDE can process annotations, e.g. In IntelliJ IDEA "Enable Annotation Processing.  </li>
 *         </ul>
 *     </p>
 *     <p>  Drill-Down {@code @Data} annotation to see what annotations it includes,
 *          and what annotations you need to complete to make this class the same
 *          as class {@link PersonBasic}.
 *     </p>
 * </div>
 * @author Binyamin Regev
 */
@Data
//  TODO - Complete the missing annotations here
public class PersonIntermediate {
    private int id;
    private String firstName;
    private String lastName;
    private int age;
}
