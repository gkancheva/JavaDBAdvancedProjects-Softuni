package com.softuni.exam.exceptions;

/**
 * Created by gery on 12.8.2017 г..
 */
public class DeserializeException extends RuntimeException {
    public DeserializeException(String message) {
        super(message);
    }

    public DeserializeException(String message, Throwable cause) {
        super(message, cause);
    }
}
