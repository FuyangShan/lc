```java
class Logger {

    HashMap<String, Integer> printMap;
    /** Initialize your data structure here. */
    public Logger() {
        // store <string, timestamp> when should print
        printMap = new HashMap<>();
        
    }
    
    /** Returns true if the message should be printed in the given timestamp, otherwise returns false.
        If this method returns false, the message will not be printed.
        The timestamp is in seconds granularity. */
    public boolean shouldPrintMessage(int timestamp, String message) {
        // if message was never printed, add to map and return true;
        if (!printMap.containsKey(message)) {
            printMap.put(message, timestamp);
            return true;
        } else {
            // message was printed, check if curr_time - old_time >= 10
            if (timestamp - printMap.get(message) < 10) return false;
            else {
                printMap.put(message, timestamp);
                return true;
            }
        }
    }
}

/**
 * Your Logger object will be instantiated and called as such:
 * Logger obj = new Logger();
 * boolean param_1 = obj.shouldPrintMessage(timestamp,message);
 */
 ```