package calculator.io;

import calculator.parser.Input;

public interface IOHandler {

    Input<String> requestStringInput();

    void printCalculateResult(Number output);
}
