package de.schulung.bibliothek;

import de.schulung.bibliothek.administration.Bibliothek;
import de.schulung.bibliothek.administration.Member;

import java.util.Scanner;

public class BibliothekConsole {

    private boolean running = true;
    private Scanner input;
    private Bibliothek bibliothek;
    private Member currentMember = null;

    public BibliothekConsole(Bibliothek bibliothek) {
        this.bibliothek = bibliothek;
    }

    public void start(){
        running = true;
        input = new Scanner(System.in);
        printHelp();
        while(running){
            System.out.println("Bibliothek Console");
            if(currentMember != null){
                System.out.print(currentMember.getId() + "> ");
            } else {
                System.out.print("> ");
            }
            // Read

            String line = input.nextLine();
            // Evaluate
            evaluate(line);
            // Print
            // Loop
        }
        input.close();
    }

    private void printHelp(){
        String helpLoggedIn =
                "How to use the Bibliothek Console?\n"+
                "Available commands:\n" +
                "   mediums:        Lists complete mediums stock\n" +
                "   logout:         Logs out the userd user id\n" +
                "   quit:           Exit the program\n" +
                "   help:           Show help page\n";
        String helpNotLoggedIn =
                "How to use the Bibliothek Console?\n"+
                        "Available commands:\n" +
                        "   mediums:        Lists complete mediums stock\n" +
                        "   login UserID:   Log in the user with provided user id\n" +
                        "   quit:           Exit the program\n" +
                        "   help:           Show help page\n";
        if (currentMember == null){
            System.out.println(helpNotLoggedIn);
        } else {
            System.out.println(helpLoggedIn);
        }
    }

    private void quit(){
        running = false;
        System.out.println("Goodbye!");
    }

    private void listMediums(){
        bibliothek.printStock();
    }

    private void login(String userId){
        if(currentMember != null){
            System.out.println(currentMember.getId() + " is already logged in");
            return;
        }
        Member member = bibliothek.findMemberById(userId);
        if(member == null){
            System.out.println("Invalid username");
            return;
        }
        currentMember = member;
        System.out.println("You have successfully logged in");
    }

    private void logout(){
        if (currentMember==null){
            System.out.println("No user logged in");
            return;
        }
        currentMember = null;
        System.out.println("You have successfully logged out");
    }



    private void evaluate(String line) {
        // lend return register quit
        String[] tokens = line.split(" ");
        String command = tokens[0].toLowerCase();
        String arg = null;
        if (tokens.length > 1) {
            arg = tokens[1];
        }
        switch (command) {
            case "login" -> login(arg);
            case "quit" -> quit();
            case "mediums" -> listMediums();
            case "help"  -> printHelp();
            case "logout"  -> logout();
            default -> System.out.println("Invalid command");
        }

        //login 3KP
    }

}
