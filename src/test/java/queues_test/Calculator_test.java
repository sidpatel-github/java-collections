package queues_test;

import org.junit.Test;
import queue.stack.Calculator;

import static org.junit.Assert.assertEquals;

public class Calculator_test {
    private Calculator calculator = new Calculator();

    @Test
    public void shouldEvaluateConstants() {
        int result = calculator.evalute("1");
        assertEquals(1, result);
    }

    @Test
    public void shouldSupportAdding() {
        int result = calculator.evalute("1 + 2");
        assertEquals(3, result);
    }

    @Test
    public void shouldSupportSubtraction() {
        int result = calculator.evalute("1 - 2");
        assertEquals(-1, result);
    }

    @Test
    public void shouldComplexStatements() {
        int result = calculator.evalute("1 - 3 + 2 + 4");
        assertEquals(4, result);
    }

    @Test
    public void shouldComplexStatements2() {
        int result = calculator.evalute("1 * 3 + 2");
        assertEquals(5, result);
    }
}
