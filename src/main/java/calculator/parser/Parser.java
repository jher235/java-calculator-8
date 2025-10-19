package calculator.parser;

import java.util.List;

public interface Parser <T extends Number> {
    List<T> parseFromString(String input);

}
