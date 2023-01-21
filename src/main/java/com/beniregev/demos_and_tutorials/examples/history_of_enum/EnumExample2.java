package com.beniregev.demos_and_tutorials.examples.history_of_enum;

/**
 * <div>
 *     <p>
 *         We can improve {@link EnumExample1} it if we get to know the
 *         meaning of the numbers by their own name.
 *     </p>
 *     <p>
 *         <div>
 *             Now each number has its own name that we can easily
 *             figure out so that the switch statement becomes more
 *             straightforward. Also, the variables become constant
 *             by the final keyword and are assigned only once on
 *             memory by the static keyword.
 *         </div>
 *         <div>
 *             Note that we can better source code in using an interface
 *             as this shape of code ({@code private final static}) can
 *             be left out in it, as you can see in {@link EnumExample3}:
 *         </div>
 *     </p>
 * </div>
 * @author binyamin.regev
 * @see EnumExample1
 * @see EnumExample3
 */
public class EnumExample2 {
    private final static int MONDAY = 1;
    private final static int TUESDAY = 2;
    private final static int WEDNESDAY = 3;
    private final static int THURSDAY = 4;
    private final static int FRIDAY = 5;
    private final static int SATURDAY = 6;
    private final static int SUNDAY = 7;

    public static void main(String[] args) {

        int day = MONDAY;

        switch (day) {
            case MONDAY:
                System.out.println("Mondays are bad");
                break;
            case TUESDAY:
                System.out.println("Tuesdays are still bad");
                break;
            case WEDNESDAY:
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
