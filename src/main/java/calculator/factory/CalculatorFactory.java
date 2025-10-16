package calculator.factory;

import calculator.Calculator;
import calculator.io.IOConsoleHandler;
import calculator.io.IOHandler;

public class CalculatorFactory {

    public Calculator createCalculator() {
        IOHandler iOHandler =  new IOConsoleHandler();
        return new Calculator(
            iOHandler
        );
    }
}
