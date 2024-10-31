package at.spengergasse.systemcalls.exception;

public class DateTimeCallException extends RuntimeException{
    public DateTimeCallException(String message){
        super(message);
    }

    public DateTimeCallException(String message,
                                 Throwable cause){
        super(message,
              cause);
    }
}
