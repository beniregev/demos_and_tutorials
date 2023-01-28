package com.beniregev.demos_and_tutorials.demos.strings;

import java.util.*;

/**
 * <div>
 *     <p>
 *         <div>
 *             Given a string {@code s}, find the length of the <b>longest substring</b> without repeating characters.
 *         </div>
 *         <ul><b>Constraints:</b>
 *             <li><code>0 <= s.length <= 5 * 10^4</code></li>
 *             <li>
 *                 {@code s} consists of English letters (UPPER and lower-case),
 *                 digits, symbols and spaces.
 *             </li>
 *         </ul>
 *     </p>
 *     <p>
 *         <div><b>Example 1:</b></div>
 *         <div><b>Input:</b> {@code s = "abcabcbb"}</div>
 *         <div><b>Output:</b> 3</div>
 *         <div><b>Explanation:</b> The answer is {@code "abc"} with the length of 3.</div>
 *     </p>
 *     <p>
 *         <div><b>Example 2:</b></div>
 *         <div><b>Input:</b> {@code s = "bbbbbbb"}</div>
 *         <div><b>Output:</b> 1</div>
 *         <div><b>Explanation:</b> The answer is {@code "b"} with the length of 1.</div>
 *     </p>
 *     <p>
 *         <div><b>Example 3:</b></div>
 *         <div><b>Input:</b> {@code s = "pwwkew"}</div>
 *         <div><b>Output:</b> 3</div>
 *         <div><b>Explanation:</b> The answer is {@code "wke"} with the length of 3.</div>
 *     </p>
 *     <p>
 *         <div><b>Example 4:</b></div>
 *         <div><b>Input:</b> {@code s = " "}</div>
 *         <div><b>Output:</b> 1</div>
 *         <div><b>Explanation:</b> The answer is {@code " "} with the length of 1.</div>
 *     </p>
 *     <p>
 *         <div><b>Example 5:</b></div>
 *          <div><b>Input:</b> {@code s = "au"}</div>
 *         <div><b>Output:</b> 2</div>
 *         <div><b>Explanation:</b> The answer is {@code "au"} with the length of 2.</div>
 *     </p>
 *     <p>
 *         <div><b>Example 6:</b></div>
 *         <div><b>Input:</b> {@code s = "uail"}</div>
 *         <div><b>Output:</b> 4</div>
 *         <div><b>Explanation:</b> The answer is {@code "uail"} with the length of 4.</div>
 *     </p>
 *     <p>
 *         <div><b>Example 7:</b></div>
 *         <div><b>Input:</b> {@code s = "dvdf"}</div>
 *         <div><b>Output:</b> 3</div>
 *         <div><b>Explanation:</b> The answer is {@code "vdf"} with the length of 3.</div>
 *     </p>
 * </div>
 */
public class FindLongestSubstringWithoutRepeatingCharacters {

    private static int solution(String s) {
        if (s.length() < 2) return s.length();
        char[] arrChars = s.toCharArray();
        //s = s.toLowerCase();
        String longestSubstring = new String(s.substring(0, 1));
        int maxLength = 0;
        int i = 1;
        while (i < arrChars.length) {
            CharSequence charSeq = new StringBuilder(1).append(arrChars[i]);
            int charIndex = longestSubstring.indexOf(charSeq.toString());
            if (charIndex >= 0) {
                maxLength = Math.max(maxLength, longestSubstring.length());
                longestSubstring = longestSubstring.substring(charIndex+1) + s.substring(i,i+1);
            } else {
                longestSubstring = longestSubstring + s.substring(i,i+1);
            }
            i++;
        }
        if (i >= arrChars.length && longestSubstring.length() > maxLength) {
            System.out.println(longestSubstring + " ==> " + longestSubstring.length());
            maxLength = longestSubstring.length();
        }
        return maxLength;
    }

    /**
     * "abcabcbb"   ==> 3 (abc)
     * "bbbbbbb"    ==> 1 (b)
     * "pwwkew"     ==> 3 (wke)
     * " "          ==> 1 (space)
     * "au"         ==> 2 (au)
     * "uail"       ==> 4 (uail)
     * "dvdf"       ==> 3 (vdf)
     * @param args
     */
    public static void main(String[] args) {
        List<String> inputs = Arrays.asList(
                "abcabcbb", "bbbbbb", "pwwkew", " ", "au", "uail", "dvdf"
                , "hijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789hijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789hijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789hijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789hijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789hijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789"
        );
        for (String input: inputs) {
            System.out.println("For \"" + input + "\" length of the longest substring without repeating is " + solution(input));
        }
    }
}
