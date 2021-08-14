public class Calculator {
    public int Add(String input) {
        if(input.isEmpty())
            return 0;

        String delimiters = FindDelimiters(input);
        String[] spiltNumbersByDelimiters = StringSplitter(input,delimiters);

        return getAddition(spiltNumbersByDelimiters);
    }

    private String FindDelimiters(String input) {
        if(input.contains("\n")) {
            return "[\n,]+";
        } else {
            return ",";
        }
    }

    private static String[] StringSplitter(String input, String delimiter) {
        return input.split(delimiter);
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
