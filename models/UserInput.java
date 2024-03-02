package models;
/**
 * Responsible for User Input
 */

import java.util.Scanner;

public class UserInput {
    private Scanner scanner;
    public UserInput(){
        scanner = new Scanner(System.in);
    }
    public String getPlayerName(){
        return scanner.nextLine();
        
    }
    public int getSelection(){
        return scanner.nextInt();
    }
    public String getSheepColor(){
        return scanner.nextLine();
    }

}
