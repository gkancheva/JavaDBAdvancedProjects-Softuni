package com.softuni.exam.exceptions;

/**
 * Created by gery on 12.8.2017 г..
 */
public class ReadFileException extends RuntimeException {
    public ReadFileException(String message) {
        super(message);
    }

    public ReadFileException(String message, Throwable cause) {
        super(message, cause);
    }
}
