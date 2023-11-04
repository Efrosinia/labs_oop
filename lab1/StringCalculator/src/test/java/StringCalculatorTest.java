import org.example.Calculator.IncorrectInput;
import org.example.Calculator.StringCalculator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class StringCalculatorTest {
    @Test
    void test () throws IncorrectInput {
        StringCalculator Object= new StringCalculator();
        Assertions.assertEquals(0,Object.add(""));

    }

}
