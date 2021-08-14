public class Calculator {
    public int Add(String input) {
        if(input.isEmpty())
            return 0;

        String delimiters = FindDelimiters(input);
        String[] spiltNumbersByDelimiters = StringSplitter(input,delimiters);

        return getAddition(spiltNumbersByDelimiters);
    }

    private String FindDelimiters(String input) {
        String delimiters;
        if(input.startsWith("//")) {
            delimiters = input.substring(2, input.indexOf('\n')).trim();
            return "[//\n," + delimiters + "]+";
        } else {
            return "[,\n]+";
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
