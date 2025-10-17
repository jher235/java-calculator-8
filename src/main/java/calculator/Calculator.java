package calculator;

import calculator.io.IOHandler;
import calculator.parser.Input;
import calculator.parser.Parser;
import java.util.List;

public class Calculator<T> {

    private final IOHandler ioHandler;
    private final Parser<T> parser;

    public void run(){
        Input<String> stringInput = Input.createStringInput(ioHandler.requestInput());
        List<T> list = parser.parseFromStringInput(stringInput);


    }

    public Calculator(
        IOHandler ioHandler,
        Parser<T> parser
    ) {
        this.ioHandler = ioHandler;
        this.parser = parser;
    }
}
