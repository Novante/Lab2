package stringCalculator;

public class StringCalculator extends Exception{


    int add(String numbers) {
        String z = null;
        if (numbers.startsWith("//")) {
            numbers = numbers.substring(4);
            numbers = numbers.replace(';', ',');
        }
        String[] num = numbers.split("[,\n]");
        int sum = 0;


        if (numbers.isEmpty()) {
            return 0;
        }

        for (String x:num
             ) {
            if (Integer.parseInt(x) < 0){
                throw new IllegalArgumentException("Negatives not allowed");
            }
        }

        for (String x : num
        ) {
            sum += Integer.parseInt(x);
        }

        return sum;
    }


}
