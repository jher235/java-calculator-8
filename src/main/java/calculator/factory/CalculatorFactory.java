package calculator.factory;

import calculator.Calculator;
import calculator.io.IOConsoleHandler;
import calculator.io.IOHandler;
import calculator.parser.IntegerParser;
import calculator.parser.Parser;

public class CalculatorFactory {

    public Calculator<Integer> createCalculator() {
        IOHandler iOHandler =  new IOConsoleHandler();
        Parser<Integer> parser  = new IntegerParser();
        return new Calculator<>(
            iOHandler,
            parser
        );
    }
}
