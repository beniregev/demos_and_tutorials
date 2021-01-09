package com.beniregev.demos_and_tutorials.project_lombok;

import lombok.*;

/**
 * <div>
 *     <p>
 *         <ul>Prerequisites:
 *         <li>Add {@code projectlombok} dependency to your project.</li>
 *         <li>Reimport your project dependencies to verify you have lombok support.</li>
 *         <li>Make sure your IDE can process annotations, e.g. In IntelliJ IDEA "Enable Annotation Processing.  </li>
 *         </ul>
 *     </p>
 * </div>
 * @author Binyamin Regev
 */
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class PersonBasic {
    private int id;
    private String name;
    private int age;

}
