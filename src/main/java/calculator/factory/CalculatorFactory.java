package calculator.factory;

import calculator.Calculator;
import calculator.io.IOConsoleHandler;
import calculator.io.IOHandler;
import calculator.parser.InputParser;

public class CalculatorFactory {

    public Calculator createCalculator() {
        IOHandler iOHandler =  new IOConsoleHandler();
        InputParser inputParser = new InputParser();
        return new Calculator(
            iOHandler,
            inputParser
        );
    }
}
