package stringCalculator;



import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
}