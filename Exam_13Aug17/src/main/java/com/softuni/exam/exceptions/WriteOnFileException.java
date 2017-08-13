package com.softuni.exam.exceptions;

/**
 * Created by gery on 12.8.2017 г..
 */
public class WriteOnFileException extends RuntimeException {
    public WriteOnFileException(String message) {
        super(message);
    }

    public WriteOnFileException(String message, Throwable cause) {
        super(message, cause);
    }
}
