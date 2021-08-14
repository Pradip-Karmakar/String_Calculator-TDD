import org.testng.annotations.Test;
import org.testng.AssertJUnit;

@Test
public class CalculatorTest {
    private final Calculator calculator = new Calculator();

    public void emptyString() throws Exception {
        AssertJUnit.assertEquals(0, calculator.Add(""));
    }

    public void singleDigit() throws Exception {
        AssertJUnit.assertEquals(1, calculator.Add("1"));
        AssertJUnit.assertEquals(2, calculator.Add("2"));
    }

    public void twoDigits() throws Exception {
        AssertJUnit.assertEquals(3, calculator.Add("1,2"));
        AssertJUnit.assertEquals(9, calculator.Add("4,5"));
    }

    public void multipleDigits() throws Exception {
        AssertJUnit.assertEquals(15, calculator.Add("1,2,3,4,5"));
        AssertJUnit.assertEquals(14, calculator.Add("2,3,4,5"));
    }

    public void newLine() throws Exception {
        AssertJUnit.assertEquals(15, calculator.Add("1\n2,3,4\n5"));
        AssertJUnit.assertEquals(15, calculator.Add("1\n2\n3\n4\n5"));
    }

    public void differentDelimiters() throws Exception {
        AssertJUnit.assertEquals(15, calculator.Add("//;\n1;2;3;4;5"));
        AssertJUnit.assertEquals(15, calculator.Add("//)\n1)2)3)4)5"));
    }

    @Test(expectedExceptions = Exception.class)
    public void negativeOccurrence() throws Exception {
        calculator.Add("-1");
        calculator.Add("-1,-2");
        calculator.Add("//;\n-1;-2;5");
    }

    public void invokeAddMethodCount() throws Exception {
        Calculator calc = new Calculator();

        calc.Add("1");
        calc.Add("10,20");

        AssertJUnit.assertEquals(2, calc.getCalledCount());
    }
}
