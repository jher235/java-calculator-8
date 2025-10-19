package calculator.io;

import static calculator.constant.Message.GUIDE_MESSAGE;
import static calculator.constant.Message.RESULT_MESSAGE;

import camp.nextstep.edu.missionutils.Console;

public class IOConsoleHandler implements IOHandler {

    @Override
    public Input<String> requestStringInput() {
        printGuideMessage();
        String input = Console.readLine();
        return Input.createStringInput(input);
    }

    @Override
    public void printCalculateResult(Number output) {
        System.out.println(RESULT_MESSAGE + output.toString());
    }

    private void printGuideMessage(){
        System.out.println(GUIDE_MESSAGE.getMessage());
    }

}
