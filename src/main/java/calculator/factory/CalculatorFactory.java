package calculator.factory;

import calculator.Calculator;
import calculator.io.IOConsoleHandler;
import calculator.io.IOHandler;
import calculator.parser.IntegerParser;
import calculator.parser.Parser;
import java.util.Map;

public class CalculatorFactory {

    private static final Map<Class<?>, Parser<?>> parserHandler = Map.of(
        Integer.class, new IntegerParser()
    );

    public <T> Calculator<T> createCalculator(Class<T> type) {
        IOHandler iOHandler =  new IOConsoleHandler();
        Parser<T> parser = getParser(type);
        return new Calculator<>(
            iOHandler,
            parser
        );
    }

    @SuppressWarnings("unchecked")
    private <T> Parser<T> getParser(Class<T> type){
        Parser<T> parser = (Parser<T>) parserHandler.get(type);

        if(parser == null){
            throw new IllegalArgumentException("Not Found Parser: " + type.getName());
        }

        return parser;
    }

}
