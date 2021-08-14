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

    public void twoDigits() {
        AssertJUnit.assertEquals(3, calculator.Add("1,2"));
        AssertJUnit.assertEquals(9, calculator.Add("4,5"));
    }

    public void multipleDigits() {
        AssertJUnit.assertEquals(15, calculator.Add("1,2,3,4,5"));
        AssertJUnit.assertEquals(14, calculator.Add("2,3,4,5"));
    }
}
