package stringCalculator;

public class StringCalculator {

    int add(String numbers) {
        int sum = 0;

        if (numbers.isEmpty()) {
            return 0;
        }

        String[] num = numbers.split(",");

        for (String x : num
        ) {
            sum += Integer.parseInt(x);
        }

        return sum;
    }

}
