package com.softuni.exam.exceptions;

/**
 * Created by gery on 12.8.2017 г..
 */
public class SerializeException extends RuntimeException {
    public SerializeException(String message) {
        super(message);
    }

    public SerializeException(String message, Throwable cause) {
        super(message, cause);
    }
}
