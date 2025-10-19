package calculator.factory;

import calculator.Calculator;
import calculator.io.IOConsoleHandler;
import calculator.io.IOHandler;
import calculator.operator.IntegerAdder;
import calculator.operator.Operator;
import calculator.parser.IntegerParser;
import calculator.parser.Parser;
import java.util.Map;

public class CalculatorFactory {

    private static final Map<Class<?>, Parser<?>> parserHandler = Map.of(
        Integer.class, new IntegerParser()
    );

    private static final Map<Class<?>, Operator<?>> parserOperator = Map.of(
        Integer.class, new IntegerAdder()
    );

    public <T extends Number> Calculator<T> createCalculator(Class<T> type) {
        IOHandler<T> iOHandler = new IOConsoleHandler<>();
        Parser<T> parser = getParser(type);
        Operator<T> operator = getOperator(type);
        return new Calculator<>(
            iOHandler,
            parser,
            operator
        );
    }

    @SuppressWarnings("unchecked")
    private <T extends Number> Parser<T> getParser(Class<T> type){
        Parser<T> parser = (Parser<T>) parserHandler.get(type);

        if(parser == null){
            throw new IllegalArgumentException("Not Found Parser: " + type.getName());
        }

        return parser;
    }

    @SuppressWarnings("unchecked")
    private <T extends Number> Operator<T> getOperator(Class<T> type){
        Operator<T> operator = (Operator<T>) parserOperator.get(type);

        if(operator == null){
            throw new IllegalArgumentException("Not Found Operator: " + type.getName());
        }

        return operator;
    }

}
