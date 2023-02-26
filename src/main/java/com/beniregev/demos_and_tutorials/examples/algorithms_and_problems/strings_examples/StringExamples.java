package com.beniregev.demos_and_tutorials.examples.algorithms_and_problems.strings_examples;

import java.util.HashMap;
import java.util.Map;

/**
 * <div>
 *     This class contains examples about {@link String} class.
 * </div>
 * @author binyamin.regev
 */
public class StringExamples {

    /**
     * Check is 2 Strings received as parameters are permutations of each other.
     * @param str1 First {@link String} to compare.
     * @param str2 Second {@link String} to compare.
     * @return {@link Boolean}, {@code true} if the strings are permutations, othersie {@code false}.
     */
    public boolean isPermutation(String str1, String str2) {
        if (str1.length() != str2.length())
            return false;
        Map<Character, Integer> map1 = this.stringToMap(str1);
        Map<Character, Integer> map2 = this.stringToMap(str2);
        return map1.equals(map2);
    }

    public static void main(String[] args) {
        StringExamples example = new StringExamples();
        System.out.println("Is permutation? " + example.isPermutation("abc", "abc1"));      //  False. Strings are NOT permutations, length is different.
        System.out.println("Is permutation? " + example.isPermutation("Abca", "abAc"));     //  True. Strings are permutations
        System.out.println("Is permutation? " + example.isPermutation("Abca", "abac"));     //  False. Strings are NOT permutations
        System.out.println("Is permutation? " + example.isPermutation("AbCccA", "AcAcbC")); //  True. Strings are permutations
    }

    private Map<Character, Integer> stringToMap(String str) {
        char[] chars = str.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            if (map.containsKey(chars[i])) {
                map.put(chars[i], map.get(chars[i]) + 1);
            } else {
                map.put(chars[i], 1);
            }
        }
        return map;
    }

}
