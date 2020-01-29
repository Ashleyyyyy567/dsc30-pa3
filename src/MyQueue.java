/**
 * MyQueue class.
 * Implements Queue using Deque.
 * @ author Lehan Li
 */
public class MyQueue {

    private Deque queue;


    /** Constructor to create new MyQueue using default Deque */
    public MyQueue() {
        queue = new Deque();
    }

    /** Constructor to create a MyQueue using Deque */
    public MyQueue(int maxCap) {
        queue = new Deque(maxCap);
    }

    /**
     * Returns the capacity of this Queue, that is, the maximum number of
     * elements it can hold.
     *
     * @return the capacity of this Queue
     */
    public int capacity() {
        return queue.capacity();
    }

    /**
     * Returns the number of elements in this Queue.
     *
     * @return the number of elements in this Queue
     */
    public int size() {
        return queue.size();
    }

    /**
     * Returns whether or not the Queue is empty.
     * @return whether or not the Queue is empty.
     */
    public boolean isEmpty() {
        return queue.isEmpty();
    }

    /**
     * Returns whether or not the Queue is full.
     * @return whether or not the Queue is full.
     */
    public boolean isFull() {
        return queue.isFull();
    }

    /**
     * Adds the specified element to the tail of this Queue.
     *
     * @param i the element to add to the queue
     * @return true if the element was added, else false.
     * @throws NullPointerException if the specified element is null,
     * and size is less than capacity
     */
    public boolean enqueue(Integer i) {
        return queue.addBack(i);
    }

    /**
     * Removes the element at the head of this Queue.
     *
     * @return  the element removed, or null if the size was zero.
     */
    public Integer dequeue() {
        return queue.removeFront();
    }

    /**
     * Returns the element at the head of this BoundedQueue,
     * or null if there was no such element.
     *
     * @return  the element at the head, or null if the size was zero.
     */
    public Integer peek() {
        return queue.peekFront();
    }
}
