package calculator.operator;

import java.util.Collection;

public class IntegerAdder implements Adder<Integer> {

    @Override
    public Integer operate(Collection<Integer> values) {
        return values.stream().mapToInt(Integer::intValue).sum();
    }

}
