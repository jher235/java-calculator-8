package calculator.factory;

import calculator.Calculator;
import calculator.io.IOConsoleHandler;
import calculator.io.IOHandler;
import calculator.operator.IntegerAdder;
import calculator.operator.Operator;
import calculator.parser.IntegerFromStringParser;
import calculator.parser.Parser;
import calculator.parser.converter.StringToPositiveIntegerConverter;
import java.util.Map;

public class CalculatorFactory {

    private static final Map<Class<?>, Parser<?, String>> stringParserHandler = Map.of(
        Integer.class, new IntegerFromStringParser(new StringToPositiveIntegerConverter())
    );

    private static final Map<Class<?>, Operator<?>> operatorHandler = Map.of(
        Integer.class, new IntegerAdder()
    );

    public <T extends Number> Calculator<T> createCalculator(Class<T> type) {
        IOHandler iOHandler = new IOConsoleHandler();
        Parser<T, String> parser = getParser(type);
        Operator<T> operator = getOperator(type);
        return new Calculator<>(
            iOHandler,
            parser,
            operator
        );
    }

    @SuppressWarnings("unchecked")
    private <T extends Number, S> Parser<T, S> getParser(Class<T> type){
        Parser<T, S> parser = (Parser<T, S>) stringParserHandler.get(type);

        if(parser == null){
            throw new IllegalArgumentException("Not Found Parser: " + type.getName());
        }

        return parser;
    }

    @SuppressWarnings("unchecked")
    private <T extends Number> Operator<T> getOperator(Class<T> type){
        Operator<T> operator = (Operator<T>) operatorHandler.get(type);

        if(operator == null){
            throw new IllegalArgumentException("Not Found Operator: " + type.getName());
        }

        return operator;
    }

}
