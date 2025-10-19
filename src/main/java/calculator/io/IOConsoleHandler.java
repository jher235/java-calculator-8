package calculator.io;

import static calculator.constant.Message.GUIDE_MESSAGE;
import static calculator.constant.Message.RESULT_MESSAGE;

import camp.nextstep.edu.missionutils.Console;

public class IOConsoleHandler<T> implements IOHandler<T> {

    @Override
    public String requestInput() {
        printGuideMessage();
        return Console.readLine();
    }

    @Override
    public void printResult(T output) {
        System.out.println(RESULT_MESSAGE + output.toString());
    }

    private void printGuideMessage(){
        System.out.println(GUIDE_MESSAGE.getMessage());
    }

}
