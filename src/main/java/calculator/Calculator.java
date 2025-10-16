package calculator;

import calculator.io.IOHandler;

public class Calculator {

    private final IOHandler ioHandler;

    public void run(){
        String input = ioHandler.requestInput();
    }

    public Calculator(IOHandler ioHandler) {
        this.ioHandler = ioHandler;
    }
}
