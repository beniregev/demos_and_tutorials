package com.beniregev.demos_and_tutorials.examples.history_of_enum;

/**
 * <div>
 *     <p>
 *         If the Java compiler doesn't find that kind of source
 *         code and doesn't mark it as an error, you might have
 *         an unexpected error in runtime. To get rid of the risk,
 *         one smart Java developer might suggest a way to change
 *         the interfaces to classes and to make the data type of
 *         each constant to neither int nor other things but to
 *         its class so that an instance of their class would be
 *         assigned to every single of them. If then, it’s certain
 *         that the compiler finds the error as {@code Day.Monday} and
 *         {@code Month.January} belong to different data types. But
 *         one constraint still remains in this amazing method that
 *         you cannot use the switch statement any longer because it
 *         does not support customized data types. Boom! Here is the
 *         reason why an enum type has been presented from
 *         <strong><em>Java 5</em></strong>.
 *     </p>
 *     <p>
 *         Everything has its own history. Millions of Java developers’
 *         outrages and tons of broken keyboards had been stacked up so
 *         long that Sun Microsystems decided to create the enum type.
 *         The next post will cover up what it is consisted of and how
 *         it works. Thanks for reading.
 *     </p>
 * </div>
 * @author binyamin.regev
 */
public class EnumExample4 {
    public static void main(String[] args) {
/*
        // a compile error will occur at the {@code if} statement
        // as we are trying to compare two different types
        if (Day.MONDAY == Month.JANUARY) {
            System.out.println("Both are same!");
        }

        Day day = Day.MONDAY;

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

 */
    }
}

class Day {
    public final static Day MONDAY = new Day();
    public final static Day TUESDAY = new Day();
    public final static Day WEDNESDAY = new Day();
}

class Month {
    public final static Month JANUARY = new Month();
    public final static Month FEBRUARY = new Month();
    public final static Month MARCH = new Month();
}
