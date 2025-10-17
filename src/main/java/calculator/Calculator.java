package calculator;

import calculator.io.IOHandler;
import calculator.parser.Input;
import calculator.parser.InputParser;
import java.util.List;

public class Calculator {

    private final IOHandler ioHandler;

    public void run(){
        Input<String> stringInput = Input.createStringInput(ioHandler.requestInput());

    }

    public Calculator(IOHandler ioHandler) {
        this.ioHandler = ioHandler;
    }
}
