package com.beniregev.demos_and_tutorials.examples;
import java.util.*;

/**
 *
 * @author binyamin.regev
 * @since jdk-1.8.0_162
 */
public class PrimitivesExamples {

    /**
     * This method takes any non-negative integer as an argument and
     * returns it with its digits in descending order. Essentially,
     * rearrange the digits to create the highest possible number.
     * @param num
     */
    public void generateLargestInteger(int num) {
        if (num < 1) return;
        int temp = num;
        List<Integer> list = new ArrayList<>();
        while (temp > 0) {
            list.add(temp % 10);
            temp /= 10;
        }
        System.out.println("list 1= " + list);
        list.sort(Collections.reverseOrder());
        System.out.println("list 2= " + list);
        int result = list.get(0);
        for (int i=1; i < list.size(); i++) {
            result = result * 10 + list.get(i);
        }
        System.out.println("result = " + result);
    }

    /**
     * <div>
     *     <p>
     *         You might know some pretty large perfect squares. But what about the NEXT one?
     *     </p>
     *     <p>
     *         Complete the {@code findNextSquare} method that finds the next integral
     *         perfect square after the one passed as a parameter. Recall that an integral
     *         perfect square is an integer n such that sqrt(n) is also an integer.
     *     </p>
     *     <p>
     *         If the parameter is itself not a perfect square then -1 should be returned. You may assume the parameter is non-negative.
     *     </p>
     *     <pre>
     *         <code>
     *             121 --> 144
     *             625 --> 676
     *             114 --> -1 since 114 is not a perfect square
     *         </code>
     *     </pre>
     * </div>
     * @param sq
     * @return
     */
    public long findNextSquare1(long sq) {
        System.out.println("findNextSquare(long): ");
        long temp = (long)Math.sqrt(sq);
        if (Math.pow(temp, 2) != sq) {
            System.out.println("\t" + sq + " --> -1");
            return -1;
        }
        temp++;
        long result = (long)Math.pow(temp, 2);
        System.out.println("\t" + sq + " --> " + result);
        System.out.println("-------------------------------------------------");
        return result;
    }

    public long findNextSquare2(long sq) {
        long root = (long) Math.sqrt(sq);
        return root * root == sq ? (root + 1) * (root + 1) : -1;
    }

    public static void main(String[] args) {
        PrimitivesExamples examples = new PrimitivesExamples();
        examples.generateLargestInteger(42145 );        //  54421
        examples.generateLargestInteger(145263 );       //  654321
        examples.generateLargestInteger(183654729 );    //  987654321
        examples.findNextSquare1(121);   //  144
        examples.findNextSquare2(121);   //  144
        examples.findNextSquare1(625);   //  676
        examples.findNextSquare2(625);   //  676
        examples.findNextSquare1(114);   //  -1
        examples.findNextSquare2(114);   //  -1
        examples.makeSecondsReadableTime(0);
        examples.makeSecondsReadableTime(5);
        examples.makeSecondsReadableTime(60);
        examples.makeSecondsReadableTime(86399);
        examples.makeSecondsReadableTime(359999);
    }

    /**
     * <div>
     *     <p>Write a function, which takes a non-negative integer (seconds) as input and returns the time in a human-readable format (HH:MM:SS)</p>
     *     <ul>
     *         <li>HH = hours, padded to 2 digits, range: 00 - 99</li>
     *         <li>MM = minutes, padded to 2 digits, range: 00 - 59</li>
     *         <li>SS = seconds, padded to 2 digits, range: 00 - 59</li>
     *     </ul>
     *     <p>The maximum time never exceeds 359999 (99:59:59)</p>
     *
     * </div>
     * @param seconds Integer. Value between 0 and 359999.
     * @return
     */
    public String makeSecondsReadableTime(int seconds) {
        int hours = seconds / 3600;
        int sec = seconds % 3600;
        int minutes = sec / 60;
        sec %= 60;
        StringBuilder result = new StringBuilder()
                .append(String.valueOf(100 + hours).substring(1))
                .append(":")
                .append(String.valueOf(100 + minutes).substring(1))
                .append(":")
                .append(String.valueOf(100 + sec).substring(1));
        System.out.println(result.toString());


        return result.toString();
    }
}
