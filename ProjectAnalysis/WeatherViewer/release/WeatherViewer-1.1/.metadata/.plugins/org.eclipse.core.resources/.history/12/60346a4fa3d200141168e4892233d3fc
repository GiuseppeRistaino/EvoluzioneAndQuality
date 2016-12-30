package group17.weatherviewer;

/**
 * Personalized Exception for handling problems with this app, right now only used for locations but there may be other uses
 */
public class WeatherException extends Exception {

    //message printed in stackTrace
    private String message;
    //cause printed in stackTrace, allows much clearer exception messages
    private Throwable cause;

    /**
     * Constructor for WeatherException taking only a message string
     * @param msg the message to be printed in this exception's stackTrace
     */
    public WeatherException(String msg) {
        super(msg);
        this.message = msg;
    }

    /**
     * Construtor for WeatherException taking only a cause
     * @param cause the Throwable object causing this exception to be thrown
     */
    public WeatherException(Throwable cause) {
        super(cause);
        this.cause = cause;
    }

    /**
     * Constructor for WeatherException taking both possible parameters
     * @param msg the message to be printed in this exception's stackTrace
     * @param cause the Throwable object causing this exception to be thrown
     */
    public WeatherException(String msg, Throwable cause) {
        super(msg, cause);
        this.message = msg;
        this.cause = cause;
    }

    /**
     * Returns this WeatherException's message string
      * @return the message associated with this exception
     */
    public String getMessage() {
        return this.message;
    }

    /**
     * Returns this WeatherException's cause
     * @return the cause associated with this exception
     */
    public Throwable getCause() {
        return this.cause;
    }
}
