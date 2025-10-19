package calculator.io;

public interface IOHandler {

    Input<String> requestStringInput();

    void printCalculateResult(Number output);
}
