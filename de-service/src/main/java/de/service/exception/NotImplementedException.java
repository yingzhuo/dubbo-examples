package de.service.exception;

public class NotImplementedException extends UnsupportedOperationException {

    private final String owner;

    public NotImplementedException(String owner) {
        this.owner = owner;
    }

    public String getOwner() {
        return owner;
    }

}
