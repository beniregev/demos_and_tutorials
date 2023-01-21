package com.beniregev.demos_and_tutorials.examples.history_of_enum;

/**
 * <div>
 *     <p>
 *         Note that we can better source code from {@link EnumExample2} by
 *         using an interface as this shape of code ({@code private final static})
 *         can be left out in it:
 *     </p>
 *     <p>
 *         Looks way better, doesn't it? Nonetheless, it has one trivial
 *         problem, where it cannot guarantee compile-time safety when you
 *         try comparing two different sets of constants like:
 *     </p>
 *     <pre>
 *         <code>
 *     if (Day.Monday == Month.January) {
 *         System.out.println("Mondays are bad");
 *     }
 *         </code>
 *     </pre>
 * </div>
 * @author binyamin.regev
 * @see EnumExample1
 * @see EnumExample2
 */
public class EnumExample3 {
    interface Day {
        int MONDAY = 1;
        int TUESDAY = 2;
        int WEDNESDAY = 3;
        int THURSDAY = 4;
        int FRIDAY = 5;
        int SATURDAY = 6;
        int SUNDAY = 7;
    }

    interface Month {
        int January = 1;
        int February = 2;
        int March = 3;
        int April = 4;
        int May = 5;
        int June = 6;
        int July = 7;
        int August = 8;
        int September = 9;
        int October = 10;
        int November = 11;
        int December = 12;

    }

    public static void main(String[] args) {
        int day = Day.MONDAY;

        switch (day) {
            case Day.MONDAY:
                System.out.println("Mondays are bad");
                break;
            case Day.TUESDAY:
                System.out.println("Tuesdays are still bad");
                break;
            case Day.WEDNESDAY:
                System.out.println("Wednesdays are so-so");
                break;
        }

        //  one trivial problem, where it cannot guarantee
        //  compile-time safety when you try comparing two
        //  different sets of constants like:
        if (Day.MONDAY == Month.January) {
            System.out.println("Mondays are bad");
        }
    }
}
