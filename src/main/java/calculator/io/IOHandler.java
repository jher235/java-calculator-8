package calculator.io;

public interface IOHandler<T> {

    String requestInput();

    void printResult(T output);
}
