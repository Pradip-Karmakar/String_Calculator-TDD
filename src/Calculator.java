public class Calculator {

    private  int invokeCount = 0;

    public int Add(String input) throws Exception {
        ++invokeCount;
        if(input.isEmpty())
            return 0;

        String delimiters = FindDelimiters(input);
        String[] spiltNumbersByDelimiters = StringSplitter(input,delimiters);

        findNegativeNumbers(spiltNumbersByDelimiters);

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

    private static void findNegativeNumbers(String[] extractedInputs) throws Exception {
        for (String extractedInput : extractedInputs) {
            if(!extractedInput.isEmpty() && Integer.parseInt(extractedInput) < 0) {
                throw new Exception("Negative Number Not Allowed : " + extractedInput);
            }
        }
    }

    public int getCalledCount() {
        return invokeCount;
    }
}
