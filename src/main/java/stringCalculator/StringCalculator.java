package stringCalculator;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class StringCalculator {


    int add(String numbers) {

        numbers = numbers.replaceAll("[^0-9-]", ",");

        String[] num = numbers.split("[,]");

        int sum = 0;

        if (numbers.isEmpty()) {
            return 0;
        }


        for (String x : num
        ) {
            if (tryParseInt(x)) {
                int input = Integer.parseInt(x);
                if (input < 0) {
                    throw new IllegalArgumentException("Negatives not allowed");
                }
                if (input <= 1000) {
                    sum += Integer.parseInt(x);
                }
            }
        }

        return sum;
    }

    private boolean tryParseInt(String value) {
        try {
            int x = Integer.parseInt(value);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

}
