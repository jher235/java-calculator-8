package calculator.operator;

import java.util.Collection;

public interface Operator<T extends  Number> {

    T operate(Collection<T> values);
}
