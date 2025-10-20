package calculator.io;

/**
 * 인터페이스 네이밍이 IOHandler 지만... calculator.io.IOHandler 이므로 Calculate에 의존적인 메서드를 포함하도록 함
 */
public interface IOHandler {

    Input<String> requestStringInput();

    void printCalculateResult(Number output);
}
