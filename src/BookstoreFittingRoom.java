import javax.xml.namespace.QName;

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
        MyQueue holder = null;
        int nextCustomer;
        int timeRemain;
        int totalTime = closingTime;
        int idleTime = 0;
        int wasteTime = 0;
        int number = -1;

        int test = -1;
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
        for(int j = 0; j < changingRooms.length ; j++ ){
            tempCus = customersQueue.dequeue();
            changingRooms[j].enqueue(tempCus);
        }


        //use closing time as a count, for every minute, check if there are any empty room
        for(int i = 0; i < closingTime; i++){
            holder = findFirstEmptyChangingRoom();
            if( !(holder == null)){
                emptyRoom = findFirstEmptyChangingRoom();
            }
            else{
                continue;
            }

            //check if the customer in line is empty
            // if so, check each room if it's empty, plus one min
            if(customersQueue.size() == 0){
                for(int j = 0; j < changingRooms.length; j ++){
                    number = changingRooms[j].dequeue();
                    if(number <= -1){
                        idleTime += 1;
                        changingRooms[j].enqueue(number);

                    }
                }
            }
            //loop through every customer waiting in line
            //if the time range fits, add it into the room
            //if not, reject and add to waste time and change to other customer 
            else{
                for(int j = 0; j < customersQueue.size(); j++){
                    nextCustomer = customersQueue.dequeue();
                    timeRemain = closingTime - i;
                    if(timeRemain >= nextCustomer){
                        emptyRoom.dequeue();
                        emptyRoom.enqueue(nextCustomer);
                        break;
                    }
                    else{
                        wasteTime += nextCustomer;
                    }
                }
            }
        }

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
        MyQueue tempRoom = new MyQueue(1);
        int timeRemain;
        int newTime;

        // store each changing room into tempRoom,
        // the integer represents time needed, subtract 1 that is passed
        // if integer equals to zero, it means the room is empty
        for(int i = 0; i < changingRooms.length; i++) {
            tempRoom = changingRooms[i];
            if(tempRoom.size() <= 0){
                tempRoom.enqueue(0);
            }
            timeRemain = tempRoom.dequeue() - 1;
            tempRoom.enqueue(timeRemain);
        }

        for(int i = 0; i < changingRooms.length; i++){
            tempRoom = changingRooms[i];
            timeRemain = tempRoom.dequeue();
            if(timeRemain <= -1){
                tempRoom.enqueue(0);
                return tempRoom;
            }
            tempRoom.enqueue(timeRemain);
        }
        return null;

    }

    /**
     * Helper method to determine if the shop is empty
     */
    private static boolean storeIsEmpty() {
        //declare variables
        MyQueue tempRoom;
        int number = -1;
        //check if customer in line is empty, if not, return false
        if(customersQueue.isEmpty()) {
            //loop through every fitting room, if any room is not empty, return false
            for (int i = 0; i < changingRooms.length; i++) {
                tempRoom = changingRooms[i];
                number = tempRoom.dequeue();
                if (number != 0) {
                    tempRoom.enqueue(number);
                    return false;
                }
                //after checking every room and none has customer, return true
            }
            return true;
        }
        else{
            return false;
        }
    }
}