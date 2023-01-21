
// The UtilityClass defines a static abstract class,
// a static field with the type of the abstract class
// and a method that is a pass thru to the abstract method on
// the abstract class
class UtilityClass {

    // nested static abstract class
    static abstract class Logger {
        abstract void log(String logMessage);
    }

    // static field typed to the nested static abstract class
    static Logger logger;

    // static method (pass through method to the method on
    // the abstract class
    static void log(String logMessage) {
        logger.log(logMessage);
    }
}

// This class extends the UtilityClass and implements the log method
class CustomLogger extends UtilityClass.Logger {

    // overrides and implements the abstract method from
    // the abstract class
    void log(String logMessage) {
        logMessage = doSomethingCustomBeforeLogging(logMessage);
        System.out.println("I want to log " + logMessage
                + " my own great way");
    }

    // A custom private method used in log method
    private String doSomethingCustomBeforeLogging(String logMessage) {
        // code might search, replace, persist, whatever...
        logMessage = "'" + logMessage + "' (" + logMessage.split(" ").length
                + " words)";
        return logMessage;
    }
}

// This code tests the code from above.
public class StaticClassExample {

    public static void main(String[] args) {

        UtilityClass.logger = new CustomLogger();
        UtilityClass.log("An important message");
    }
}