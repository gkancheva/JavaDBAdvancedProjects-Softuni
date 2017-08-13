package com.softuni.commands;

import java.text.ParseException;

/**
 * Created on 31.7.2017 г..
 */
public interface Executable {
    String execute(String... args) throws ParseException;
}