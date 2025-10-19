package calculator;

import calculator.factory.CalculatorFactory;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        CalculatorFactory calculatorFactory = new CalculatorFactory();
        Calculator<Integer> calculator = calculatorFactory.createCalculator(Integer.class);
        calculator.run();
    }
}
