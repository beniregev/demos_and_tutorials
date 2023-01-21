package com.beniregev.demos_and_tutorials.demos.numbers.roman2arabic;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    private String[] roman4sAnd9s = { "CM", "CD", "XC", "XL", "IX", "IV" };
    private final Map<String, Integer> romanNumbers;

    public Solution() {
        romanNumbers = new HashMap<String, Integer>();
        romanNumbers.put("I", 1);
        romanNumbers.put("V", 5);
        romanNumbers.put("X", 10);
        romanNumbers.put("L", 50);
        romanNumbers.put("C", 100);
        romanNumbers.put("D", 500);
        romanNumbers.put("M", 1000);
    }

    public int romanToInt(String s) {
        String romanNumber = s.toUpperCase();
        int result = 0;

        for (int i=0; i<roman4sAnd9s.length; i++) {
            int p = romanNumber.indexOf(roman4sAnd9s[i]);
            if (p >= 0) {
                result += romanNumbers.get(romanNumber.substring(p+1,p+2)) - romanNumbers.get(romanNumber.substring(p,p+1));
                romanNumber = romanNumber.replace(roman4sAnd9s[i], "");
            }
        }
        if (romanNumber.length() > 0) {
            for (int i = 0; i < romanNumber.length(); i++) {
                result += romanNumbers.get(romanNumber.substring(i, i + 1));
            }
        }
        System.out.println(s.toUpperCase() + " = " + result);
        return result;

    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.romanToInt("III");
        solution.romanToInt("LVIII");
        solution.romanToInt("MCMXCIV");
        solution.romanToInt("MCDLIV");
        solution.romanToInt("MMXXIX");
    }
}
