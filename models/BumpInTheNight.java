package models;

public class BumpInTheNight implements Nightmare {
    private String name;
    private String description;
    private int difficulty;
    
    public BumpInTheNight(){
        name = "Bump In The Night";
        description = "Big scary Bump In The Night";
        difficulty = 3;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }
    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }
    /**
     * @return the difficulty
     */
    public int getDifficulty() {
        return difficulty;
    }
}

