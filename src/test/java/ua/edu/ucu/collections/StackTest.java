package ua.edu.ucu.collections;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class StackTest {

    private Stack stack1;
    private Stack stack2;
    private Stack stack3;

    @Before
    public void setUp() {
        stack1 = new Stack(new Object[] {1, 2, 3, 4});
        stack2 = new Stack();
        stack3 = new Stack(new Object[] {7, 11, 56});
    }

    @Test
    public void testPeek() {
        Object first = stack1.peek();
        Object second = stack3.peek();
        assertEquals(first, 4);
        assertEquals(second, 56);
    }

    @Test
    public void testPop() {
        Object first = stack1.pop();
        Object second = stack3.pop();
        Stack expected1 = new Stack(new Object[] {1, 2, 3});
        assertEquals(first, 4);
        assertEquals(second, 56);
        assertEquals(stack1.peek(), expected1.peek());
    }

    @Test
    public void testPush() {
        stack2.push('w');
        stack2.push('s');
        assertEquals(stack2.pop(), 's');
        assertEquals(stack2.pop(), 'w');
    }
}
