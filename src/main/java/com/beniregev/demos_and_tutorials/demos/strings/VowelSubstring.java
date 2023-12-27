package com.beniregev.demos_and_tutorials.demos.strings;

/**
 * <div>
 *     <p>
 *         Given a {@link String} and a length of the substrings. Write
 *         the method {@code findSubstring} to find and return the first
 *         substring that contains to most vowels in it. Each vowel can
 *         appear more than once in any substring.
 *     </p>
 *     <p>
 *         In your method also find where in the {@link String} that
 *         substring starts from.
 *     </p>
 *     <p>
 *         Note: a vowel is only one of these 5 letters: a, e, i, o, u.
 *     </p>
 *     <p>
 *         If the string doesn't contain any vowels the your method will
 *         return &quot;Not found!&quot; without the quotes.
 *     </p>
 *  </div>
 */
public class VowelSubstring {
    public static String findSubstring(String s, int k) {
        // Write your code here
        String[] vowels = {"a","e", "i", "o", "u"};
        String matchVowels = String.join("", vowels);
        String stringRegEx = ".*[" + matchVowels + "].*";
        if (!s.matches(stringRegEx)) {
            return "Not found!";
        }
        int mostOccurrences = 0;
        int startsAt = -1;
        String result = null;
        for (int i=0; i<s.length()-k+1; i++) {
            String str = s.substring(i, i+k);
            if (!str.matches(stringRegEx)) continue;
            int count = 0;
            //Matcher matcher = Pattern.compile(stringRegEx).matcher(str);
            //Stream<MatchResult> streamMatchResult = matcher.results();
            //long count1 = streamMatchResult.count();
            for (int j=0; j<vowels.length; j++)
                for (int l=0; l<str.length(); l++)
                    if (str.charAt(l) == matchVowels.charAt(j))
                        count++;
            if (count > mostOccurrences) {
                mostOccurrences = count;
                startsAt = i;
                result = str;
            }
            System.out.println("found, count = " + str + ", " + count);
        }
        System.out.println("\"" + result + "\" is the first substring that contains " + mostOccurrences + " vowels, including duplicates, it  starts at position "  + startsAt);

        return result;
    }

    public static void main(String[] args) {
        String[] strings = {"azerdiiakoahsdiughzkxvcamn",
                "bcdfghjklm",
                "aldsodutnfnchjujf"
        };
        int[] lengths = { 5, 5, 5};
        if (strings.length != lengths.length) {
            System.out.println("The input arrays must be the same length!");
            System.exit(-1);
        }

        for (int i=0; i<strings.length; i++) {
            String result = VowelSubstring.findSubstring(strings[i], lengths[i]);
            System.out.println(result);
        }
    }
}
