package calculator.parser.converter;

public class StringToPositiveIntegerConverter implements Converter<Integer, String> {

    @Override
    public Integer convert(String source) {
        try {
            int convertedValue = Integer.parseInt(source);

            if(convertedValue < 0){
                throw new IllegalArgumentException("input cannot be negative");
            }
            return convertedValue;
        }catch (NumberFormatException e){
            throw new IllegalArgumentException("invalid input format");
        }
    }
}
