package calculator.operator;

import java.util.Collection;

public interface Operator<T> {

    T operate(Collection<T> values);
}
