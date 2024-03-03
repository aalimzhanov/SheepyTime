package models;

import java.time.LocalTime;
import java.time.format.DateTimeParseException;

public class TimeParser {
    // HH:MM format
    public static LocalTime parseSleepTime(String input) {
        try {
            return LocalTime.parse(input); 
        } catch (DateTimeParseException e) {
            System.err.println("Error parsing time: " + e.getMessage());
            return null; 
        }
    }
}
