package com.beniregev.demos_and_tutorials.examples.collections;

import com.github.javafaker.Faker;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 *  <div>
 *      <div></div>Here's the challenge:
 *      <h1>The Challenge: Update a Property Of All Objects in A List/Collection/Array When At Least One object Satisfies a Criteria Using a Single Pass Of The Loop</h1>
 *      <p>
 *          <h2>Requirements/Restrictions: </h2>
 *          <p>
 *              1. Streams should not be used
 *              2. Only one pass/iteration/loop
 *              3. Not allowed to used two loops, even not nested and that
 *                 math wise O(n) = O(2n) --> but time wise O(2n) takes double the time of O(n).
 *          </p>
 *          <p>
 *              <div>Given the Employee class to use: </div>
 *              <div>
 *                  <code>
 *                      public class employee {
 *                          private String name;
 *                          private Double salary;
 *                          private Boolean eligibleForHike;
 *                          //  All Getters, Setters, and constructors are created by Lombok
 *                      }
 *                  </code>
 *              </div>
 *
 *          </p>
 *      </p>
 *  </div>
 */
public class UpdatePropertyOfAllObjectsInListUsingSinglePass {
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    class Employee {
        private String name;
        private Double salary;
        private Boolean eligibleForHike;

    }

    private List<Employee> listEmployees = populateListEmployees();
    private Faker faker = Faker.instance();
    private Boolean isEligibleForHike = false;

    public List<Employee> solution(List<Employee> listToCheck, double salaryToCheck) {
        for (Employee employee : listToCheck) {
            if (employee.getSalary() >= salaryToCheck) {
                this.isEligibleForHike = true;
                employee.setEligibleForHike(this.getEligibleForHike());
            } else {
                this.isEligibleForHike = true;
                break;
            }
        }
        return listEmployees;
    }

    public static void main(String[] args) {
        UpdatePropertyOfAllObjectsInListUsingSinglePass example = new UpdatePropertyOfAllObjectsInListUsingSinglePass();
        example.solution(example.getListEmployees(), 900.0);
    }

    public List<Employee> getListEmployees() {
        return listEmployees;
    }

    public Boolean getEligibleForHike() {
        return isEligibleForHike;
    }

    private List<Employee> populateListEmployees() {
        faker = Faker.instance();
        List<Employee> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(new Employee(faker.name().firstName(), faker.random().nextDouble() * 10000.0, false));
        }
        return list;
    }
}
