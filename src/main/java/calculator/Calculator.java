package calculator;

import calculator.io.IOHandler;
import calculator.parser.Input;
import calculator.parser.InputParser;
import java.util.List;

public class Calculator {

    private final IOHandler ioHandler;
    private final InputParser inputParser;

    public void run(){
        Input<String> stringInput = Input.createStringInput(ioHandler.requestInput());
        List<? extends Number> numbers = inputParser.parseToIntegers(stringInput);
    }

    public Calculator(
        IOHandler ioHandler,
        InputParser inputParser
    ) {
        this.ioHandler = ioHandler;
        this.inputParser = new InputParser();
    }
}
