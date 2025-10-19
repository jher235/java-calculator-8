package calculator;

import calculator.io.IOHandler;
import calculator.operator.Operator;
import calculator.parser.Input;
import calculator.parser.Parser;
import java.util.List;

public class Calculator<T extends Number> {

    private final IOHandler ioHandler;
    private final Parser<T> parser;
    private final Operator<T> operator;

    public void run() {
        Input<String> stringInput = ioHandler.requestStringInput();
        List<T> list = parser.parseNumberFromString(stringInput.getValue());
        T operatedValue = operator.operate(list);
        ioHandler.printCalculateResult(operatedValue);
    }

    public Calculator(
        IOHandler ioHandler,
        Parser<T> parser,
        Operator<T> operator
    ) {
        this.ioHandler = ioHandler;
        this.parser = parser;
        this.operator = operator;
    }
}
