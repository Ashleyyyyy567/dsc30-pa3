/**
 * Implement a fitting room queue using Deque.
 * @author
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
        return "With " + /* TODO */ + " rooms, the total time " +
                "for everyone to try on their items was " + /* TODO */ +
                " time units with idle time of " + /* TODO */ + " time units " +
                "and wasted time of " + /* TODO */ + " time units";
    }

    /**
     * Helper method to find the first empty changing room. Return null if all
     * changing rooms are occupied.
     * @return first empty changing room
     */
    private static MyQueue findFirstEmptyChangingRoom() {

    }

    /**
     * Helper method to determine if the shop is empty
     * @return true if the whole shop is empty
     */
    private static boolean storeIsEmpty() {

    }
}
