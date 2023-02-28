import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        String filename = "FILE.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            int i = 0;
            while ((line = br.readLine()) != null) {
                i++;
                System.out.println("\nFILE LINE # ---------------" + i + "\n");
                lexicalAnalysis(line);
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }

    public static void lexicalAnalysis(String input) {
        List<String> tokens = new ArrayList<>();

        String regex = "FOR\\s+(?<var>[a-zA-Z])\\s*=\\s*(?<start>\\d+)\\s+TO\\s+(?<end>\\d+)";

        Matcher matcher = Pattern.compile(regex).matcher(input);

        if (matcher.matches()) {
            System.out.println("------------>>> The input is a valid FOR loop\n\n");

            String forKeyword = "FOR";
            tokens.add(forKeyword);

            String loopVariable = matcher.group("var");
            tokens.add(loopVariable);
            System.out.println("Loop variable found at position " + matcher.start("var") + " to " + matcher.end("var"));

            String assignmentOperator = "=";
            tokens.add(assignmentOperator);
            System.out.println("Assignment operator found at position " + input.indexOf(assignmentOperator) + " to " + (input.indexOf(assignmentOperator) + 1));

            String startValue = matcher.group("start");
            tokens.add(startValue);
            System.out.println("Start value found at position " + matcher.start("start") + " to " + matcher.end("start"));

            String toKeyword = "TO";
            tokens.add(toKeyword);

            String endValue = matcher.group("end");
            tokens.add(endValue);
            System.out.println("End value found at position " + matcher.start("end") + " to " + matcher.end("end"));

            System.out.println("---------------------------------------------\nTokens: \n");

            for (String token : tokens) {
                System.out.println(token);
            }

            parse(tokens);
        } else {
            parse(tokens);
            System.out.println("------------>>> The input is not a valid FOR loop");
        }
    }

    public static void parse(List<String> tokens) {
        if (tokens.size() != 6) {
            System.out.println("\n>>>> REJECTED; invalid number of tokens!");
        } else {
            System.out.println("\n>>>> ACCEPTED!");
        }

        System.out.println("\n----------------------------------------\n");

        try {
            switch (tokens.get(0)) {
                case "FOR":
                    break;
                default:
                    System.err.println("\n>>>> FOR keyword is missing or not found!");
                    return;
            } if (tokens.get(1).matches("[a-zA-Z]+")) {
                System.out.println("Loop variable: " + tokens.get(1));
            } else {
                System.err.println("\n>>>> Invalid loop variable name!");
                return;
            }

            if (tokens.get(2).equals("=")) {
                System.out.println("Assignment operator found!");
            } else {
                System.err.println("\n>>>> Invalid assignment operator!");
                return;
            }

            if (tokens.get(3).matches("\\d+")) {
                System.out.println("Start value: " + tokens.get(3));
            } else {
                System.err.println("\n>>>> Invalid start value!");
                return;
            }

            if (tokens.get(4).equals("TO")) {
                System.out.println("TO keyword found!");
            } else {
                System.err.println("\n>>>> 'TO' keyword missing or not found!");
                return;
            }

            if (tokens.get(5).matches("\\d+")) {
                System.out.println("End value: " + tokens.get(5));
            } else {
                System.err.println("\n>>>> Invalid end value!");
                return;
            }

            System.out.println("\n>>>> Valid FOR loop!");
        } catch (Exception e) {
            System.err.println("\n>>>> Error during parsing this FOR loop!");
        }
    }
}
