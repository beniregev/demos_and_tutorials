package com.beniregev.demos_and_tutorials.examples.history_of_enum;

/**
 * <div>
 *     <p>
 *         Until the enum type was presented, Java developers used
 *         to define constants with extra comments, as shown below.
 *     </p>
 *     <p>
 *         In this code, Monday should be fixed at 1, Tuesday at 2,
 *         and Wednesday at 3. As this rule is set on a comment, it
 *         would be a problem to divide the comment and the code or
 *         to delete one of them, especially the comment, as you can
 *         see in (@link EnumExample2).
 *     </p>
 * </div>
 * @author binyamin.regev
 * @see EnumExample2
 */
public class EnumExample1 {
    public static void main(String[] args) {
        /*
         * Monday == 1
         * Tuesday == 2
         * Wednesday == 3
         * Thursday == 4
         * ...
         * Sunday == 7
         * */
        int day = 1;

        switch (day) {
            case 1:
                System.out.println("Mondays are bad");
                break;
            case 2:
                System.out.println("Tuesdays are still bad");
                break;
            case 3:
                System.out.println("Wednesdays are so-so");
                break;
            case 4:
                System.out.println("Thursdays are when you smell the weekend");
                break;
            case 5:
                System.out.println("Fridays are the busiest days");
                break;
            case 6:
                System.out.println("Saturdays are the best!");
                break;
            case 7:
                System.out.println("Sundays are the worst");
                break;
        }

    }
}
