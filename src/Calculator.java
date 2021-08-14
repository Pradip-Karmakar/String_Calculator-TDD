public class Calculator {
    public int Add(String input) {
        if(input.isEmpty())
            return 0;
        String[] spiltNumbersByDelimiters = StringSplitter(input);
        return getAddition(spiltNumbersByDelimiters);
    }

    private static String[] StringSplitter(String input) {
        return input.split(",");
    }

    private static int getAddition(String[] extractedInputs) {
        int addition = 0;
        for (String extractedInput : extractedInputs) {
            if (!extractedInput.isEmpty())
                addition += Integer.parseInt(extractedInput);
        }
        return addition;
    }
}
