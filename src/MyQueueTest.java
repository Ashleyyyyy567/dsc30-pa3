import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MyQueueTest {

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void main() {
        MyQueue test1 = new MyQueue(10);
        MyQueue test2 = new MyQueue(15);
        MyQueue test3 = new MyQueue();
    }

    @Test
    public void capacity() {
        MyQueue test1 = new MyQueue(10);
        assertEquals(10, test1.capacity());
        MyQueue test2 = new MyQueue(15);
        assertEquals(15, test2.capacity());
        MyQueue test3 = new MyQueue();
        assertEquals(5, test3.capacity());
    }

    @Test
    public void size() {
        MyQueue test1 = new MyQueue(10);
        test1.enqueue(10);
        test1.enqueue(15);
        assertEquals(2, test1.size());

        MyQueue test2 = new MyQueue(15);
        assertEquals(0, test2.size());

        MyQueue test3 = new MyQueue();
        test3.enqueue(0);
        test3.enqueue(1);
        test3.enqueue(2);
        test3.enqueue(3);
        test3.enqueue(4);
        assertEquals(5, test3.size());
    }

    @Test
    public void isEmpty() {
        MyQueue test1 = new MyQueue(10);
        test1.enqueue(10);
        test1.enqueue(15);
        assertFalse(test1.isEmpty());

        MyQueue test2 = new MyQueue(15);
        assertTrue(test2.isEmpty());

        MyQueue test3 = new MyQueue();
        test3.enqueue(0);
        test3.enqueue(1);
        test3.enqueue(2);
        test3.enqueue(3);
        test3.enqueue(4);
        assertFalse(test3.isEmpty());

    }


    @Test
    public void isFull() {
        MyQueue test1 = new MyQueue(10);
        test1.enqueue(10);
        test1.enqueue(15);
        assertFalse(test1.isFull());

        MyQueue test2 = new MyQueue(15);
        assertFalse(test2.isFull());

        MyQueue test3 = new MyQueue();
        test3.enqueue(0);
        test3.enqueue(1);
        test3.enqueue(2);
        test3.enqueue(3);
        test3.enqueue(4);
        assertTrue(test3.isFull());
    }

    @Test
    public void enqueue() {
        MyQueue test1 = new MyQueue(10);
        assertTrue(test1.enqueue(1));

        MyQueue test3 = new MyQueue();
        assertTrue(test3.enqueue(0));
        assertTrue(test3.enqueue(1));

    }

    @Test
    public void dequeue() {
        MyQueue test3 = new MyQueue();
        test3.enqueue(0);
        test3.enqueue(1);
        test3.enqueue(2);
        test3.enqueue(3);
        test3.enqueue(4);

        assertEquals(0, (int)test3.dequeue());
        assertEquals(1, (int)test3.dequeue());
        assertEquals(2, (int)test3.dequeue());

    }

    @Test
    public void peek() {
        MyQueue test3 = new MyQueue();
        test3.enqueue(0);
        test3.enqueue(1);
        test3.enqueue(2);
        test3.enqueue(3);
        test3.enqueue(4);

        assertEquals(0, (int)test3.peek());
        test3.dequeue();
        assertEquals(1, (int)test3.peek());
        test3.dequeue();
        assertEquals(2, (int)test3.peek());
    }
}