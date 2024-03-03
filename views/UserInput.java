package views;

/**
 * Responsible for User Input
 */

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserInput {
    private Scanner scanner;

    public UserInput() {
        scanner = new Scanner(System.in);
    }

    public String getPlayerName() {
        System.out.println("Enter player name: ");
        return scanner.nextLine().trim();
    }

    public String getSheepColor() {
        System.out.println("Enter sheep color (yellow/pink/purple/blue): ");
        String input = scanner.nextLine().trim().toLowerCase();
        if (input.equals("yellow") || input.equals("pink") || input.equals("purple") || input.equals("blue")) {
            return input;
        } else {
            System.out.println("Invalid input. Please enter 'yellow', 'pink', 'purple' or 'blue'.");
            return getSheepColor();
        }
    }

    public boolean activateTilePrompt() {
        System.out.println("Do you want to activate this tile? (yes/no): ");
        String input = scanner.nextLine().trim().toLowerCase();

        if (input.equals("yes")) {
            return true;
        } else if (input.equals("no")) {
            return false;
        } else {
            System.out.println("Invalid input. Please enter 'yes' or 'no'.");
            return activateTilePrompt();
        }
    }

    public int getNumOfPlayers() {
        System.out.println("Enter number of players: ");
        int input = scanner.nextInt();
        if (input < 1 || input > 4) {
            System.out.println("Invalid input. Please enter a number between 1 and 4.");
            return getNumOfPlayers();
        } else {
            return input;
        }
    }

    public int pickOption(String option1, String option2) {
        System.out.println("Enter 1 for " + option1 + " or 2 for " + option2 + ": ");
        int input = scanner.nextInt();
        if (input == 1 || input == 2) {
            return input;
        } else {
            System.out.println("Invalid input. Please enter 1 or 2.");
            return pickOption(option1, option2);
        }
    }

    public int getCardSelection() {
        System.out.println("Enter the index of the card you want to play (0/1):");
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Please enter a number (0 or 1):");
            scanner.next(); // Consume the invalid input
        }
        int index = scanner.nextInt();
        scanner.nextLine(); // Consume the newline
        return index;
    }

    public boolean getCallItANightDecision() {
        System.out.println("Do you want to call it a night? (yes/no):");
        String input = scanner.nextLine().trim().toLowerCase();
        while (!input.equals("yes") && !input.equals("no")) {
            System.out.println("Invalid input. Please enter 'yes' or 'no':");
            input = scanner.nextLine().trim().toLowerCase();
        }
        return input.equals("yes");
    }
    public String getSleepTime() {
        System.out.println("Enter the time you went to bed last night in 24-hour format (HH:mm):");
        String input = scanner.nextLine().trim();

        // 24-hour format time
        Pattern pattern = Pattern.compile("^([01]\\d|2[0-3]):([0-5]\\d)$");
        Matcher matcher = pattern.matcher(input);

        while (!matcher.matches()) {
            System.out.println("Invalid time format. Please enter time in 24-hour format (HH:mm), e.g., '23:45' or '01:20':");
            input = scanner.nextLine().trim();
            matcher = pattern.matcher(input);
        }

        return input; 
    }
}