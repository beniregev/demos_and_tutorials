package com.beniregev.demos_and_tutorials.examples.arrays;

/**
 *
 * @author binyamin.regev
 * @since jdk-1.8.0_162
 */
public class ArraysOfIntegersExamples {
    /**
     * This method accepts an array of 10 integers (between 0 and 9), and prints a
     * string of those numbers in the form of a phone number.
     * example:
     *      Calling:    createPhoneNumber(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 0})
     *      result:     "(123) 456-7890"
     * @param numbers An array of 10 integers between 0 and 9
     */
    public void beforeJava8createPhoneNumber(int[] numbers) {
        System.out.println("beforeJava8createPhoneNumber(int[]): ");
        System.out.println(String.format("\tOption 1: (%1$d%2$d%3$d) %4$d%5$d%6$d-%7$d%8$d%9$d%10$d",
                numbers[0], numbers[1], numbers[2], numbers[3], numbers[4],
                numbers[5], numbers[6], numbers[7], numbers[8], numbers[9]));
        System.out.println(String.format("\tOption 2: (%s%s%s) %s%s%s-%s%s%s%s",
                numbers[0], numbers[1], numbers[2], numbers[3], numbers[4],
                numbers[5], numbers[6], numbers[7], numbers[8], numbers[9]));
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<numbers.length; i++) sb.append(numbers[i]);
        System.out.println(String.format("\tOption 3: (%s) %s-%s", sb.substring(0,3), sb.substring(3, 6), sb.substring(6,10)));
        System.out.println("-------------------------------------------------");
    }

    public void java8CreatePhoneNumber(int[] numbers) {
        System.out.println("java8CreatePhoneNumber(int[]): ");
        System.out.println(String.format("\t(%d%d%d) %d%d%d-%d%d%d%d", java.util.stream.IntStream.of(numbers).boxed().toArray()));
        System.out.println("-------------------------------------------------");
    }

    public static void main(String[] args) {
        ArraysOfIntegersExamples examples = new ArraysOfIntegersExamples();
        examples.beforeJava8createPhoneNumber(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 0});
        examples.java8CreatePhoneNumber(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 0});
    }
}