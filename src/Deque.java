import java.util.ArrayList;

/**
 * Deque Class.
 * A class of a deque implemented using a "circular" array.
 * @author Lehan Li
 * @Version 1.0
 */
public class Deque {

    private ArrayList list; // Stores the elements
    private int head; // Store the index of first & last elements respectively
    private int tail;
    private int size;

    /**
     * Default Deque constructor.
     * Creates a Deque Object
     * @throws IllegalArgumentException
     */
    public Deque() throws IllegalArgumentException {
        int defaultC = 5;
        list = new ArrayList<Integer>(defaultC);
        for(int i = 0; i < defaultC; i++){
            list.add(0);
        }
    }

    /**
     * Deque constructor.
     * Creates a Deque Object
     * @param cap - capacity of list
     * @throws IllegalArgumentException - if capacity is negative.
     */
    public Deque(int cap) throws IllegalArgumentException {
        if(cap < 0){
            throw new IllegalArgumentException();
        }
        this.list = new ArrayList<Integer>(cap);
        for(int i = 0; i < cap; i++){
            list.add(0);
        }
    }

    /**
     * Capacity method.
     * Returns the capacity of the Deque, that is,
     * the maximum number of objects it can hold.
     * @return the capacity of the list
     */
    public int capacity() {

        return list.size();
    }

    /**
     * Size method.
     * Returns the number of elements in the Deque.
     * @return the number of elements in the list
     */
    public int size() {
        return size;
    }

    /**
     * Is empty method.
     * Returns if the Deque is empty.
     * @return if the Deque is empty.
     */
    public boolean isEmpty() {
        if(size == 0){
            return true;
        }
        else{
            return false;
        }
    }

    /**
     * Is full method.
     * Returns if the Deque is full.
     * @return if the Deque is full.
     */
    public boolean isFull() {
        boolean status = false;
        if(this.isEmpty() == true){
            status = false;
        }
        else if(size == this.capacity()){
            status = true;
        }
        return status;
    }

    /**
     * Add Front Method.
     * Adds the specified element to the front the Deque.
     * @param i - the element to add to the front of the list
     * @return true if adding was successful, false if not
     * @throws NullPointerException if the specified element is null
     * and size is less than capacity
     */
    public boolean addFront(Integer i) throws NullPointerException {
        if(i == null){
            throw new NullPointerException();
        }
        //if cannot add, return false
        else if(list.size() <= size){
            return false;
        }
        // set head and tail for the beginning
        if(this.isEmpty()){
            head = 0;
            tail = 1;
            list.set(0, i);
            size += 1;
        }
        //move head one unit forward and insert into the list
        else if(head < tail && head != 0){
            head -= 1;
            list.set(head, i);
            size += 1;
        }
        //if head is at the first index, it then goes to the last one
        else if(head < tail && head == 0){
            head = capacity() - 1;
            list.set(head, i);
            size += 1;
        }
        //other condition which head moves forward.
        // it's the same as the first one above, just to be reassuring
        else if(head > tail){
            head -= 1;
            list.set(head,i);
            size += 1;
        }
        return true;
    }

    /**
     * Add Back Method.
     * Adds the specified element to the back of Deque.
     * Returns true if successful. False if not.
     * @param i - the new element to add to the back of the list
     * @return true if adding was successful, false if not
     * @throws NullPointerException if the specified element is null
     * and size is less than capacity
     */
    public boolean addBack(Integer i) throws NullPointerException {
        if(i == null){
            throw new NullPointerException();
        }
        //if cannot add, return false
        else if(this.isFull()){
            return false;
        }
        // set the head and tail for the beginning
        if(this.isEmpty()){
            head = 0;
            tail = 0;
            list.set(tail, i);
            tail += 1;
            size = 1;
        }
        //move tail backward
        else if(head < tail && tail != this.capacity() - 1){
            list.set(tail, i);
            tail += 1;
            size += 1;
        }
        // if tail is the last one, then it goes to the first
        else if(head < tail && tail == this.capacity() - 1){
            this.list.set(tail, i);
            tail = 0;
            size += 1;
        }
        //other condition which is the same as the first one
        // just to be reassuring
        else{
            this.list.set(tail, i);
            tail += 1;
            size += 1;
        }
        return true;
    }

    /**
     * Remove Front Method.
     * Removes the element at the front of Deque.
     * Returns the element removed or returns null if there is no element.
     * @return  the element removed, or null if the size was zero.
     */
    public Integer removeFront() {
        int element = 0;
        //if list is empty, return nothing
        if(this.isEmpty()){
            return null;
        }
        // if head is the last element, it then moves to the first one
        else if(head == this.capacity() - 1 && head > tail){
            element = (int)list.get(head);
            head = 0;
            size -= 1;
        }
        //head moves backwards
        else{
            element = (int)list.get(head);
            head += 1;
            size -= 1;
        }
        return element;
    }

    /**
     * Remove Back Method.
     * Removes the element at the back of Deque.
     * Returns the element removed or returns null if there is no element.
     * @return  the element removed, or null if the size was zero.
     */
    public Integer removeBack() {
        Integer element = 0;
        // return nothing is list is empty
        if(this.isEmpty()){
            return null;
        }
        // move tail forwards
        else if (head < tail || (head > tail && tail != 0)) {
            element = (Integer) list.get(tail - 1);
            list.set(tail - 1, 0);
            tail -= 1;
            this.size -= 1;
            return element;
        }
        // if the tail is the first one, it moves to the last
        else if(head > tail && tail == 0){
            element = (Integer) list.get(this.capacity() - 1);
            list.set(this.tail - 1, 0);
            this.tail = this.capacity() - 1;
            this.size -= 1;
            return element;
        }
        return element;
    }

    /**
     * Peek Front Method.
     * Returns the element at the front of the Deque
     * or null if such element does not exist.
     * @return the element at the front or null if the size was zero.
     */
    public Integer peekFront() {
        if(this.isEmpty()){
            return null;
        }
        //return the head, not modification for list
        Integer element  = (Integer) list.get(head);
        return element;
    }

    /**
     * Peek Back Method.
     * Returns the element at the back of the Deque
     * or null if such element does not exist.
     * @return the element at the back or null if the size was zero.
     */
    public Integer peekBack() {
        Integer element = 0;
        if(this.isEmpty()){
            return null;
        }
        //return the tail when tail is the first one, since the tail is pointing to the next new element
        // index need to be changed to the last one
        else if(tail == 0){
            element = (Integer) list.get(this.capacity() - 1);
        }
        //get the element in front of the tail
        else{
            element = (Integer) list.get(this.tail - 1);
        }
        return element;
    }
}
