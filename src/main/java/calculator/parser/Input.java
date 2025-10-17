package calculator.parser;


public class Input <T> {

    private final T value;

    private Input(T value) {
        this.value = value;
    }

    public static Input<String> createStringInput(String stringInput){
        if(stringInput == null || stringInput.isBlank()){
            throw new IllegalArgumentException("input string is null or blank");
        }
        return new Input<>(stringInput);
    }

}
