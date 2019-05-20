package com.audio.audio.exception;

import javax.persistence.PersistenceException;

public class AlreadyExistException extends PersistenceException {
    public AlreadyExistException() {
    }

    public AlreadyExistException(String message) {
        super(message);
    }
}
