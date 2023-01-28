package com.beniregev.demos_and_tutorials.examples.java8_time_api;

import java.time.*;
import java.time.format.DateTimeFormatter;

/**
 * <p>
 * <div><h3>1. Overview</h3></div>
 * <div>
 * Java 8 introduced new APIs for Date and Time to address the shortcomings of the older
 * {@code java.util.Date} and {@code java.util.Calendar}.
 * </div>
 * <div>
 * As part of this article, let's start with the issues in the existing Date and Calendar
 * APIs and let's discuss how the new Java 8 Date and Time APIs address them.
 * </div>
 * <div>
 * We will also look at some of the core classes of the new Java 8 project that are part
 * of the java.time package like {@link LocalDate}, {@link LocalTime}, {@link LocalDateTime},
 * {@link ZonedDateTime}, {@link Period}, {@link Duration} and their supported APIs.
 * </div>
 * </p>
 * <p>
 * <div><h3>2. Issues with the Existing Date/Time APIs</h3></div>
 * <div>
 * <ul>
 *     <li>
 *         <b>Thread Safety</b> - The {@code Date} and {@code Calendar} classes are not thread safe,
 *         leaving developers to deal with the headache of hard to debug concurrency issues and to
 *         write additional code to handle thread safety. On the contrary the new Date and Time APIs
 *         introduced in Java 8 are immutable and thread safe, thus taking that concurrency headache
 *         away from developers.
 *     </li>
 *     <li>
 *         <b>APIs Design and Ease of Understanding</b> - The {@code Date} and {@code Calendar} APIs
 *         are poorly designed with inadequate methods to perform day-to-day operations. The new
 *         <i>Date/Time</i> APIs is ISO centric and follows consistent domain models for date, time,
 *         duration and periods. There are a wide variety of utility methods that support the commonest
 *         operations.
 *     </li>
 *     <li>
 *         <b>ZonedDate and Time</b> - Developers had to write additional logic to handle timezone
 *         logic with the old APIs, whereas with the new APIs, handling of timezone can be done with
 *         <i>Local</i> and <i>ZonedDate/Time</i> APIs.
 *     </li>
 * </ul>
 * </div>
 * </p>
 * <p>
 *     <h3>3. Using LocalDate, LocalTime and LocalDateTime</h3>
 *     <div>
 *         The most commonly used classes are LocalDate, LocalTime and LocalDateTime. As their
 *         names indicate, they represent the local Date/Time from the context of the observer.
 *     </div>
 *     <div>
 *         These classes are mainly used when timezone are not required to be explicitly specified
 *         in the context. As part of this section, we will cover the most commonly used APIs.
 *     </div>
 * </p>
 * <p>
 *     <h3>3.1. Working with LocalDate</h3>
 *     <div>
 *         The LocalDate represents <b>a date in ISO format (yyyy-MM-dd) without time</b>.
 *     </div>
 *     <div>
 *         It can be used to store dates like birthdays and paydays.
 *     </div>
 *      <div>
 *          An instance of current date can be created from the system clock as below:
 *      </div>
 *
 *
 *
 *
 *      </div>
 *      <div>
 *      <h1>Class DateTimeFormatter</h1>
 *          <h5>java.lang.Object</h5>
 *              <h6>java.time.format.DateTimeFormatter</h6>
 *              <h6>public final class DateTimeFormatter extends Object</h6>
 *              <br/>
 *         <h2>Patterns for Formatting and Parsing</h2>
 *         <div>
 *              Patterns are based on a simple sequence of letters and symbols. A pattern is used to create a Formatter using the ofPattern(String) and ofPattern(String, Locale) methods. For example, "d MMM uuuu" will format 2011-12-03 as '3 Dec 2011'. A formatter created from a pattern can be used as many times as necessary, it is immutable and is thread-safe.
 *              For example:
 *          </div>
 *          <code>
 *              LocalDate date = LocalDate.now();
 *              DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy MM dd");
 *              String text = date.format(formatter);
 *              LocalDate parsedDate = LocalDate.parse(text, formatter);
 *          </code>
 *          <div>
 *
 *         All letters 'A' to 'Z' and 'a' to 'z' are reserved as pattern letters. The following pattern letters are defined:
 *
 *   Symbol  Meaning                     Presentation      Examples
 *   ------  -------                     ------------      -------
 *    G       era                         text              AD; Anno Domini; A
 *    u       year                        year              2004; 04
 *    y       year-of-era                 year              2004; 04
 *    D       day-of-year                 number            189
 *    M/L     month-of-year               number/text       7; 07; Jul; July; J
 *    d       day-of-month                number            10
 *
 *    Q/q     quarter-of-year             number/text       3; 03; Q3; 3rd quarter
 *    Y       week-based-year             year              1996; 96
 *    w       week-of-week-based-year     number            27
 *    W       week-of-month               number            4
 *    E       day-of-week                 text              Tue; Tuesday; T
 *    e/c     localized day-of-week       number/text       2; 02; Tue; Tuesday; T
 *    F       week-of-month               number            3
 *
 *    a       am-pm-of-day                text              PM
 *    h       clock-hour-of-am-pm (1-12)  number            12
 *    K       hour-of-am-pm (0-11)        number            0
 *    k       clock-hour-of-am-pm (1-24)  number            0
 *
 *    H       hour-of-day (0-23)          number            0
 *    m       minute-of-hour              number            30
 *    s       second-of-minute            number            55
 *    S       fraction-of-second          fraction          978
 *    A       milli-of-day                number            1234
 *    n       nano-of-second              number            987654321
 *    N       nano-of-day                 number            1234000000
 *
 *    V       time-zone ID                zone-id           America/Los_Angeles; Z; -08:30
 *    z       time-zone name              zone-name         Pacific Standard Time; PST
 *    O       localized zone-offset       offset-O          GMT+8; GMT+08:00; UTC-08:00;
 *    X       zone-offset 'Z' for zero    offset-X          Z; -08; -0830; -08:30; -083015; -08:30:15;
 *    x       zone-offset                 offset-x          +0000; -08; -0830; -08:30; -083015; -08:30:15;
 *    Z       zone-offset                 offset-Z          +0000; -0800; -08:00;
 *
 *    p       pad next                    pad modifier      1
 *
 *    '       escape for text             delimiter
 *    ''      single quote                literal           '
 *    [       optional section start
 *    ]       optional section end
 *    #       reserved for future use
 *    {       reserved for future use
 *    }       reserved for future use
 *          </div>
 *     </div>
 * </p>
 * @author Binyamin Regev e-mail: beniregev@gmail.com
 * @since 1.8
 * @see LocalDate
 * @see LocalTime
 * @see LocalDateTime
 * @see DateTimeFormatter
 */
public class TimeApiExample {
    private static LocalTime time;
    private static LocalDate date;
    private static LocalDateTime dateTime;

    public static void main(String[] args) {
        TimeApiExample example = new TimeApiExample();
        example.convertStringToLocalDateTime("2019-12-16 23:24:25");
        example.getEndOfYearLocalDateTime();
        example.demoStringBuffer();
        example.spreadCallsInDay(22);
    }

    public void spreadCallsInDay(int callsPerDay) {
        final int HOURS_PER_DAY = 24;
        final int MINUTES_PER_HOUR = 60;
        final int AVERAGE_CALL_DURATION_IN_MINUTES = 5;
        final int numberOfMinutesPerDay = HOURS_PER_DAY * MINUTES_PER_HOUR;
        final int timeIntervalBetweenCallInMinutes = (numberOfMinutesPerDay - (AVERAGE_CALL_DURATION_IN_MINUTES * (callsPerDay + 1))) / (callsPerDay + 1);
        LocalDate dateOfCall = LocalDate.now();
        LocalTime timeCallStarted = LocalTime.MIN.plusMinutes(timeIntervalBetweenCallInMinutes);
        for (int i=1; i<=callsPerDay; i++) {
            System.out.println("Call #" + i + ": \n\tStarted at " + timeCallStarted +
                            "\n\tEnded at " + timeCallStarted.plusMinutes(AVERAGE_CALL_DURATION_IN_MINUTES) +
                            "\n\tContact Start Time: " + timeCallStarted +
                            "\n\tContact End Time: " + timeCallStarted.plusSeconds(150)
            );
            System.out.println("dateOfCall = " + dateOfCall + " ; timeCallStarted = " + timeCallStarted);
            timeCallStarted = timeCallStarted.plusMinutes(AVERAGE_CALL_DURATION_IN_MINUTES).plusMinutes(timeIntervalBetweenCallInMinutes);
            System.out.println("AFTER: dateOfCall = " + dateOfCall + " ; timeCallStarted = " + timeCallStarted);
        }

    }


    public void convertStringToLocalDateTime(String stringDateTime) {
        System.out.println("String Date: \"" + stringDateTime.substring(0, stringDateTime.indexOf(' ')) + "\"");
        System.out.println("String Time: \"" + stringDateTime.substring(stringDateTime.indexOf(' ') + 1) + "\"");

        DateTimeFormatter formatterDate = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String stringDate = stringDateTime.substring(0, stringDateTime.indexOf(' '));
        LocalDate localDate = LocalDate.parse(stringDate, formatterDate);
        System.out.println("LocalDate: " + localDate + " ==> " + DateTimeFormatter.ISO_LOCAL_DATE.format(localDate));

        DateTimeFormatter formatterTime = DateTimeFormatter.ofPattern("HH:mm:ss");
        String stringTime = stringDateTime.substring(stringDateTime.indexOf(' ') + 1);
        LocalTime localTime = LocalTime.parse(stringTime, formatterTime);
        System.out.println("LocalTime: " + localTime + " ==> " + DateTimeFormatter.ISO_LOCAL_TIME.format(localTime));

        DateTimeFormatter formatterDateTime = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime localDateTime = LocalDateTime.parse(stringDateTime, formatterDateTime);
        /*
        d = 9
        dd = 09
        eee = Mon, יום ב'
        eeee = Monday, יום שני
        M/L = 8
        MM/LL = 08
        MMM/LLL = Aug, אוג'
        MMMM/LLLL = August, אוגוסט
        yy = 19
        yyyy = 2019
         */
        System.out.println("LocalDateTime: " + localDateTime + " ==> " + localDateTime.format(DateTimeFormatter.ofPattern("eee eeee dd MM LLL LLLL yy yyyy")));
    }

    public void getEndOfYearLocalDateTime() {
        LocalDate currentDate = LocalDate.now();        //  e.h. 2019-12-16
        DayOfWeek dow = currentDate.getDayOfWeek();     // MONDAY
        int dom = currentDate.getDayOfMonth();          // 16
        int doy = currentDate.getDayOfYear();           // 350
        Month month = currentDate.getMonth();           // getValue() = 12 ; name() = "DECEMBER"
        int year = currentDate.getYear();               // 2019
        System.out.println("day of month = " + dom);
        System.out.println("day of year = " + doy);
        System.out.println("month of year = " + month.getValue() + ' ' + month.name());
        System.out.println("year = " + year);
    }

    public void demoStringBuffer() {
        StringBuffer strEndOfYear = new StringBuffer("-12-31 23:59:59.999").insert(0, LocalDate.now().getYear());
        System.out.println("End of year = \"" + strEndOfYear.toString() + "\"");

    }
}
