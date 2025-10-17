package calculator.parser;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class InputParser {

    private static final String CUSTOM_DELIMITER_RANGE_PARSER = "(?s)^(//.*\\\\n)(.*)$";
    private static final String CUSTOM_DELIMITER_PARSER = "//(.*?)\\\\n";

    private static final List<String> defaultDelimiters = List.of( ",", ";");
    private static final String CUSTOM_DELIMITER_START = "//";
    private static final String JOIN_STRING = "|";

    public List<Integer> parseToIntegers(Input<String> input){
        String inputValue = input.getValue();

        List<String> delimiters = new ArrayList<>(defaultDelimiters);
        String inputWithoutDelimiter = parseDelimiter(inputValue, delimiters);

        return Arrays.stream(inputWithoutDelimiter.split(getDelimiterRegex(delimiters)))
            .map(Integer::parseInt)
            .toList();
    }

    private String getDelimiterRegex(List<String> delimiters) {
        return delimiters.stream()
            .map(Pattern::quote)
            .collect(Collectors.joining(JOIN_STRING));
    }

    private String parseDelimiter(String input, List<String> delimiters){
        if(input != null && input.startsWith(CUSTOM_DELIMITER_START)){
            Pattern pattern = Pattern.compile(CUSTOM_DELIMITER_RANGE_PARSER);
            Matcher matcher = pattern.matcher(input);

            if(!matcher.matches())
                throw new IllegalArgumentException("invalid custom delimiter request");

            String delimiterInput = matcher.group(1);
            String inputWithoutDelimiter = matcher.group(2);

            parseDelimiters(delimiterInput, delimiters);
            return inputWithoutDelimiter;
        }
        return input;
    }

    private List<String> parseDelimiters(String input, List<String> delimiters){
        Pattern pattern = Pattern.compile(CUSTOM_DELIMITER_PARSER);
        Matcher matcher = pattern.matcher(input);

        while (matcher.find()) {
            delimiters.add(matcher.group(1));
        }

        return delimiters;
    }
}
