package de.schulung.bibliothek;

import java.util.Scanner;

public class BibliothekConsole {

    private boolean running = true;
    private Scanner input;

    public void start(){
        running = true;
        input = new Scanner(System.in);
        while(running){
            System.out.println("Bibliothek Console");
            System.out.println("> ");
            // Read

            String line = input.nextLine();
            // Evaluate
            evaluate(line);
            // Print
            // Loop
        }
        input.close();
    }
    private void evaluate(String line){

    if (line.equalsIgnoreCase("quit")) {
        running = false;
        System.out.println("Goodbye!");
    }
    }
}
