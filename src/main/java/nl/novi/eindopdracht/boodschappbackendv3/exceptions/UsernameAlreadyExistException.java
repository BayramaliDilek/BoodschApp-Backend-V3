package nl.novi.eindopdracht.boodschappbackendv3.exceptions;

public class UsernameAlreadyExistException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public UsernameAlreadyExistException() {

        super();

    }

    public UsernameAlreadyExistException(String message) {

        super(message);

    }
}
