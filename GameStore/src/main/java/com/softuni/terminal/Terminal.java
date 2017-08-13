package com.softuni.terminal;

import com.softuni.CommandInterpreter;
import com.softuni.commands.Executable;
import com.softuni.services.api.GameService;
import com.softuni.services.api.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Created on 31.7.2017 г..
 */
@Component
public class Terminal implements CommandLineRunner {
    private final UserService userService;
    private final GameService gameService;

    @Autowired
    public Terminal(GameService gameService, UserService userService) {
        this.gameService = gameService;
        this.userService = userService;
    }

    @Override
    public void run(String... strings) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        CommandInterpreter interpreter = new CommandInterpreter(this.userService, this.gameService);
        while(true) {
            String line = reader.readLine();
            if(line.equals("END")){
                break;
            }
            String[] inputArgs = line.split("\\|");
            String command = inputArgs[0];
            String[] args = new String[inputArgs.length - 1];
            if(inputArgs.length > 1) {
                args = Arrays.copyOfRange(inputArgs, 1, inputArgs.length);
            }
            Executable executable = interpreter.interpretCommand(command);
            String result = executable.execute(args);
            System.out.println(result);
        }
    }
}
