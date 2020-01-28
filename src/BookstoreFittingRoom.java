/**
 * Implement a fitting room queue using Deque.
 * @author Lehan Li
 */
public class BookstoreFittingRoom {

    private static MyQueue customersQueue;
    private static MyQueue[] changingRooms;

    /**
     * Main method to run simulations from.
     * @param args command line arguments.
     */
    public static void main(String[] args) {
        /*MyQueue room1 = new MyQueue(1);
        MyQueue room2 = new MyQueue(1);
        //MyQueue room3 = new MyQueue(1);
        room1.enqueue(2);
        room2.enqueue(2);
        //room3.enqueue(3);

        changingRooms = new MyQueue[2];
        changingRooms[0] = room1;
        changingRooms[1] = room2;
        //changingRooms[2] = room3;

        System.out.println(findFirstEmptyChangingRoom());


        room1.dequeue();
        room2.dequeue();
        //room3.dequeue();
        customersQueue = new MyQueue(2);
        customersQueue.enqueue(1);
        customersQueue.dequeue();

        System.out.println(storeIsEmpty());*/

        int[][] customers = {{1, 2, 1}, {2, 2, 0}, {1, 0, 2}};
        System.out.println(timeInfo(customers, 2, 10));

    }

    /**
     * Returns a string that contains information about total time
     * for checking out all customers and changing room idle time.
     * @param customers the customer queue
     * @param numberOfChangingRooms number of changing rooms opened
     * @param closingTime amount of time the store is open
     * @return a string that contains information about total time
     *         for checking out all customers and changing room idle time.
     */
    public static String timeInfo(int[][] customers, int numberOfChangingRooms, int closingTime) {

        // to initialize the changingRooms with MyQueue with the size of closingTime
        int timeNeed = 0;
        int shoes = 1;
        int shirt = 2;
        int pants = 3;
        int tempCus;
        MyQueue emptyRoom;
        int nextCustomer;
        int timeRemain;
        int totalTime = 0;
        int idleTime = 0;
        int wasteTime = 0;
        changingRooms = new MyQueue[numberOfChangingRooms];
        for(int j = 0; j < numberOfChangingRooms; j ++){
            changingRooms[j] = new MyQueue(1); //one room can only fit one customer
        }

        //calculate the time need to complete the try on and enqueue them into customerQueue
        customersQueue = new MyQueue(customers.length);
        for(int k = 0; k < customers.length; k++){
            timeNeed = 1 + shoes * customers[k][0] + shirt * customers[k][1] + pants * customers[k][1 + 1];
            customersQueue.enqueue(timeNeed);
        }


        // assign the customer into empty fitting rooms from the customersQueue
        for(int j = 0; j < changingRooms.length; j++ ){
            tempCus = customersQueue.dequeue();
            changingRooms[j].enqueue(tempCus);
        }
        //use closing time as a count, for every minute, check if there are any empty room
        for(int i = 0; i < closingTime; i++){

            System.out.println(findFirstEmptyChangingRoom());




            if(!(findFirstEmptyChangingRoom() == null)){
                emptyRoom = findFirstEmptyChangingRoom();
            }
            else{
                continue;
            }
            if(storeIsEmpty()){
                System.out.println("d");
                idleTime = (closingTime - i) * changingRooms.length;
                break;
            }
            else{
                for(int j = 0; j < customersQueue.size(); j++){
                    nextCustomer = customersQueue.dequeue();
                    timeRemain = closingTime - i;
                    if(timeRemain >= nextCustomer){
                        System.out.println("e");
                        emptyRoom.enqueue(nextCustomer);
                        break;
                    }
                    else{
                        System.out.println("f");
                        wasteTime += nextCustomer;
                    }
                }

            }
            totalTime += 1;
        }
        System.out.println("g");
        // after closing time, check if there are any customer in line,
        //if so, add their time to waste time
        if(!customersQueue.isEmpty()){
            for(int j = 0; j < customersQueue.size(); j ++){
                wasteTime += customersQueue.dequeue();
            }
        }

        return "With " + numberOfChangingRooms + " rooms, the total time " +
                "for everyone to try on their items was " + totalTime +
                " time units with idle time of " + idleTime + " time units " +
                "and wasted time of " + wasteTime + " time units";
    }

    /**
     * Helper method to find the first empty changing room. Return null if all
     * changing rooms are occupied.
     * @return first empty changing room
     */
    private static MyQueue findFirstEmptyChangingRoom() {
        // declare variables
        MyQueue tempRoom;
        int timeRemain;

        // store each changing room into tempRoom,
        // the integer represents time needed, subtract 1 that is passed
        // if integer equals to zero, it means the room is empty
        for(int i = 0; i < changingRooms.length; i++){
            tempRoom = changingRooms[i];
            timeRemain = tempRoom.dequeue();
            timeRemain -= 1;
            if(timeRemain == 0){
                return tempRoom;
            }
            tempRoom.enqueue(timeRemain);
        }
        return null;
    }

    /**
     * Helper method to determine if the shop is empty
     * @return true if the whole shop is empty
     */
    private static boolean storeIsEmpty() {
        //declare variables
        MyQueue tempRoom;

        //check if customer in line is empty, if not, return false
        if(customersQueue.isEmpty()){
            //loop through every fitting room, if any room is not empty, return false
            for(int i = 0; i < changingRooms.length; i++){
                tempRoom = changingRooms[i];
                if(!tempRoom.isEmpty()){
                    return false;
                }
            }
            //after checking every room and none has customer, return true
            return true;
        }
        else{
            return false;
        }
    }
}
