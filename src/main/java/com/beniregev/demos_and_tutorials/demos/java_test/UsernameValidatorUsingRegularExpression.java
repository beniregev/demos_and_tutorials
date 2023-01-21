package com.beniregev.demos_and_tutorials.demos.java_test;

import java.util.Scanner;

/**
 * You are updating the username policy on your company's internal networking platform. According to the policy, a username is considered valid if all the following constraints are satisfied:
 *
 * <ul>
 *     <li>
 *         The username consists of 8 to 30 characters inclusive. If the username consists of less
 *         than 8 or greater than 30 characters, then it is an invalid username.
 *     </li>
 *     <li>
 *         The username can only contain alphanumeric characters and underscores (_). Alphanumeric
 *         characters describe the character set consisting of lowercase characters {@code [a-z]},
 *         uppercase characters {@code [A-Z]}, and digits {@code [0-9]}.
 *     </li>
 *     <li>
 *         The first character of the username must be an alphabetic character, i.e., either lowercase
 *         character {@code [a-z]} or uppercase character {@code [A-Z]}.
 *     </li>
 * </ul>
 * <p>
 *     Username         Validity
 *     Julia            INVALID; Username length < 8 characters
 *     Samantha         VALID
 *     Samantha_21      VALID
 *     1Samantha        INVALID; Username begins with non-alphabetic character
 *     Samantha?10_2A   INVALID; Character '?' is not allowed
 * </p>
 * <p>
 *     Program input    Expected Result
 *     --------------------------------
 *     8
 *     Julia            Invalid
 *     Samantha         Valid
 *     Samantha_21      Valid
 *     1Samantha        Invalid
 *     Samantha?10_2A   Invalid
 *     JuliaZ007        Valid
 *     Julia@007        Invalid
 *     _Julia007        Invalid
 * </p>
 * <p>
 *     <div>
 *         The first line of input contains an integer {@code n}, describing the total
 *         number of usernames.
 *     </div>
 *     <div>
 *         Each of the next {@code n} lines contains a string describing the username. The
 *         locked stub code reads the inputs and validates the username.
 *     </div>
 * </p>
 */
public class UsernameValidatorUsingRegularExpression {
    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
//        String[] usernames = {
//                "Julia",
//                "Samantha",
//                "Samantha_21",
//                "1Samantha",
//                "Samantha?10_2A",
//                "JuliaZ007",
//                "Julia@007",
//                "_Julia007",
//                "K-hdbR_",
//                "F5DhJ-SkaXLyfWAD",
//                "yJjiUfPG-TJi"
//        };
        int n = Integer.parseInt(scan.nextLine());
//        int n = usernames.length;
//        int i=0;
        while (n-- != 0) {
            String userName = scan.nextLine();
//            String userName = usernames[i];

            if (userName.matches(Solution.regularExpression)) {
                System.out.println("Valid\t\t" + userName);
            } else {
                System.out.println("Invalid\t\t" + userName);
            }
//            i++;
        }
    }
}

class Solution {
    public static final String regularExpression = "^[a-zA-Z]([._](?![._])|[a-zA-Z0-9]){7,29}$";
}
