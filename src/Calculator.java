public class Calculator {
    public int Add(String input) {
       return input.isEmpty() ? 0 : Integer.parseInt(input);
    }
}
