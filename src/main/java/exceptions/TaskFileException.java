package exceptions;

public class TaskFileException extends RuntimeException {

    public TaskFileException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
