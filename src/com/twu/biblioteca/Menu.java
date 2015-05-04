package com.twu.biblioteca;

import com.twu.biblioteca.commands.Command;

import java.io.PrintStream;
import java.util.Map;

/**
 * Created by nzeplowi on 4/29/15.
 */
public class Menu {

    private final PrintStream printStream;
    private final Biblioteca biblioteca;
    private  boolean running;
    private UserInputStream userInputStream;
    private Map<String, Command> mapMenuCommand;

    public Menu(PrintStream printStream, Biblioteca biblioteca, UserInputStream userInputStream, Map<String, Command> mapMenuCommand) {
        this.printStream = printStream;
        this.biblioteca = biblioteca;
        this.userInputStream = userInputStream;
        this.mapMenuCommand = mapMenuCommand;
        this.running = true;
    }

    private void displayWelcomeMessage() {
        this.printStream.println("Welcome to Biblioteca!");
    }

    public void start() {
        displayWelcomeMessage();
        displayMenu();

        while (running) {
            String userInput = userInputStream.getUserInput();
            checkUserInput(userInput);
            printStream.println("---------------------------------------------------------------------------------------");
            displayMenu();
        }
        printStream.println("Thank you");
    }

    private void displayMenu() {
        int counter = 1;
        for (String option : mapMenuCommand.keySet()) {
            printStream.println(counter + ". " + option);
            counter++;
        }
        printStream.println(counter + ". Quit\n");
        printStream.print("Enter your option: ");
    }

    private void checkUserInput(String userInput) {

        if (mapMenuCommand.containsKey(userInput)){
            mapMenuCommand.get(userInput).execute();
        }
        else if(userInput.equals("Quit")) {
            running = false;
        }
        else{
                printStream.println("Select a valid option!");
        }
    }
}
