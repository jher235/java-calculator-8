package calculator.parser.converter;

public interface Converter<T, S> {

    T convert(S source);
}
