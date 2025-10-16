package calculator.io;

import static calculator.constant.Message.GUIDE_MESSAGE;

import camp.nextstep.edu.missionutils.Console;

public class IOConsoleHandler implements IOHandler {

    public String requestInput() {
        printGuideMessage();
        return Console.readLine();
    }

    private void printGuideMessage(){
        System.out.println(GUIDE_MESSAGE.getMessage());
    }
}
