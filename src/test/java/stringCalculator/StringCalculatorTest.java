package stringCalculator;



import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class StringCalculatorTest {

   @Test
    void takeZeroNumbers(){
        StringCalculator str = new StringCalculator();
        assertEquals(0, str.add(""));
    }

    @Test
    void takeOneNumber(){
       StringCalculator str = new StringCalculator();
       assertEquals(1, str.add("1"));
    }

    @Test
    void takeTwoNumbers(){
       StringCalculator str = new StringCalculator();
       assertEquals(2, str.add("1,1"));
    }

    @Test
    void takeMoreThanTwoNumbers(){
       StringCalculator str = new StringCalculator();
       assertEquals(3, str.add("1,1,1"));
    }

    @Test
    void handleNewLinesBetweenNumbers(){
       StringCalculator str = new StringCalculator();
       assertEquals(3, str.add("1\n1,1"));
    }

    @Test
    void handleDifferentDelimiters(){
       StringCalculator str = new StringCalculator();
       assertEquals(3, str.add("//;\n1;2"));
    }

    @Test
    void addWithNegativeNumber(){
       StringCalculator str = new StringCalculator();
       assertThrows(IllegalArgumentException.class, () -> str.add("-1,2"));
    }
}