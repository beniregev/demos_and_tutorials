package com.beniregev.demos_and_tutorials.demos.numbers.roman2arabic;

import java.util.List;

public class Roman2ArabicConverter {
    public static int roman2Arabic(String input) {
        String romanNum = input.toUpperCase();
        int result = 0;

        List<RomanNumber> romanNumbers = RomanNumber.getValuesReverseSorted();

        int i = 0;

        while ((romanNumbers.size() > 0) && (i < romanNumbers.size())) {
            RomanNumber symbol = romanNumbers.get(i);
            if (romanNum.startsWith(symbol.name())) {
                result += symbol.getValue();
                romanNum = romanNum.substring(symbol.name().length());
            } else {
                i++;
            }
        }

        if (romanNum.length() > 0) {
            throw new IllegalArgumentException(input + " cannot be converted to a Roman Numeral");
        }

        return result;
    }

    public static String arabic2Roman(int number) {
        if ((number <= 0) || (number > 4000)) {
            throw new IllegalArgumentException(number + " is not in range (0,4000]");
        }

        List<RomanNumber> romanNumerals = RomanNumber.getValuesReverseSorted();

        int i = 0;
        StringBuilder sb = new StringBuilder();

        while (number > 0 && i < romanNumerals.size()) {
            RomanNumber currentSymbol = romanNumerals.get(i);
            if (currentSymbol.getValue() <= number) {
                sb.append(currentSymbol.name());
                number -= currentSymbol.getValue();
            } else {
                i++;
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        List<RomanNumber> romanNumerals = RomanNumber.getValuesReverseSorted();
        for (RomanNumber romanNumber : romanNumerals) {
            System.out.println(romanNumber.name() + ' ' + romanNumber.getValue());

        }
    }
}
