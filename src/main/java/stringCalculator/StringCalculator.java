package stringCalculator;

public class StringCalculator {


    int add(String numbers) {
        String[] num = numbers.split(",");
        int sum = 0;

        if (numbers.isEmpty()) {
            return 0;
        }

        for (String x : num
        ) {
            sum += Integer.parseInt(x);
        }

        return sum;
    }


}
