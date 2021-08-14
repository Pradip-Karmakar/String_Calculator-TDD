import org.testng.annotations.Test;
import org.testng.AssertJUnit;

@Test
public class CalculatorTest {
    private final Calculator calculator = new Calculator();

    public void emptyString(){
        AssertJUnit.assertEquals(0, calculator.Add(""));
    }

    public void singleDigit(){
        AssertJUnit.assertEquals(1, calculator.Add("1"));
        AssertJUnit.assertEquals(2, calculator.Add("2"));
    }
}
