package calculator.parser;

import calculator.parser.converter.Converter;
import java.util.List;

public abstract class Parser <T, S> {

    protected final Converter<T, S> converter;

    protected Parser(Converter<T, S> converter) {
        this.converter = converter;
    }

    public abstract List<T> parseFromString(String input);

}
