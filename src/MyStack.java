/**
 * MyStack class.
 * Implements Stack using MyQueue.
 * @aithor: Lehan Li
 */
public class MyStack {

    private MyQueue list;

    /** Constructor for a MyStack object, using default MyQueue */
    public MyStack() {
        list = new MyQueue();
    }

    /** Constructor for a MyStack object, using MyQueue */
    public MyStack(int maxCap) {
        list = new MyQueue(maxCap);
    }

    /**
     * Returns the capacity of this Stack, that is, the maximum number of
     * elements it can hold.
     *
     * @return the capacity of this Stack
     */
    public int capacity() {
        return list.capacity();
    }

    /**
     * Returns the number of elements in this Stack.
     *
     * @return the number of elements in this Stack
     */
    public int size() {
        return list.size();
    }

    /**
     * Returns whether or not the Stack is empty.
     * @return whether or not the Stack is empty.
     */
    public boolean isEmpty() {
        return list.isEmpty();
    }

    /**
     * Returns whether or not the Stack is full.
     * @return whether or not the Stack is full.
     */
    public boolean isFull() {
        return list.isFull();
    }

    /**
     * Adds the specified element to the top of this Stack.
     *
     * @param i the element to add to the stack
     * @return true if the element was added, else false.
     * @throws NullPointerException if the specified element is null,
     * and size is less than capacity
     */
    public boolean push(Integer i) {
        if(i == null || list.size() < list.capacity()){
            throw new NullPointerException();
        }
        else if(list.size() >= list.capacity()){
            return false;
        }
        else{
            list.enqueue(i);
            return true;
        }
    }

    /**
     * Removes the element at the top of this Stack.
     *
     * @return  the element removed, or null if the size was zero.
     */
    public Integer pop() {
        MyQueue newqueue = new MyQueue();
        int number = 0;
        int finalNum = 0;
        if(list.size() == 0){
            return null;
        }
        else{
            for(int i = 0; i < list.size() - 1; i++){
                number = list.dequeue();
                newqueue.enqueue(number);
            }
            finalNum = list.dequeue();
            for(int i = 0; i < list.size(); i++){
                number = newqueue.dequeue();
                list.enqueue(number);
            }
            return finalNum;
        }
    }

    /**
     * Returns the element at the top of this Stack,
     * or null if there was no such element.
     *
     * @return the element at the top, or null if the size was zero.
     */
    public Integer peek() {
        MyQueue newqueue = new MyQueue();
        int number = 0;
        int finalNum = 0;
        if(list.size() == 0){
            return null;
        }
        else{
            for(int i = 0; i < list.size() - 1; i++){
                number = list.dequeue();
                newqueue.enqueue(number);
            }
            finalNum = list.dequeue();
            for(int i = 0; i < list.size(); i++){
                number = newqueue.dequeue();
                list.enqueue(number);
            }
            list.enqueue(finalNum);
            return finalNum;
        }
    }
}
