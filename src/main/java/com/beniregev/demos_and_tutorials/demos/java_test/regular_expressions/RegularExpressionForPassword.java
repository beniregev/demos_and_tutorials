package com.beniregev.demos_and_tutorials.demos.java_test.regular_expressions;

/**
 * The registration form in the site of a certain organization has certain rules
 * that must be strictly followed when creating a password to access the site.
 * Which variable declaration will create a password string that has at least:
 * <ul>
 *     <li>One digit.</li>
 *     <li>One UPPERCASE letter.</li>
 *     <li>One lowercase letter.</li>
 *     <li>Password length of 6 to 20 characters.</li>
 * </ul>
 */
public class RegularExpressionForPassword {
    private static String REGEX_PASSWORD_PATTERN_A = "((?=.[0-9])(?=.[a-z])(?=.[A-Z]).{6,20})";
    private static String REGEX_PASSWORD_PATTERN_B = "((?=.*d)(?=.*[a-z])(?=.*[A-Z]).(?=.*[6-20]))";
    private static String REGEX_PASSWORD_PATTERN_C = "((?=.*d)(?=.*[a-z])(?=.*[A-Z]).{6-20})";
    private static String REGEX_PASSWORD_PATTERN_D = "((?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{6,20})";

    public static void main(String[] args) {

    }
}
