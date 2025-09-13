package az.aliyev_nijat.electrofix.exception;

public class StatusNotExistException extends RuntimeException {

    public StatusNotExistException() {
        super("The requested status does not exist.");
    }
}
