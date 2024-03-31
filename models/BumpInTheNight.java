package models;
/**
 * Represents a nightmare called "Bump In The Night".
 * This nightmare is characterized by strange sounds and shadows in the dark.
 * It has a difficulty level of 1.
 *
 * @author Adil Alimzhanov, Tan Karageldi, Tolga Cohce, Derrick Ansah
 */
public class BumpInTheNight implements Nightmare {
    private String name;
    private String description;
    private int difficulty;
    
    public BumpInTheNight(){
        name = "Bump In The Night";
        description = "*THUD* WHAT WAS THAT SOUND? PROBABLY NOTHING, THERE'S ONLY SHADOWS. *THUD* I THINK I HEARD A BUMP IN THE NIGHT AGAIN. WAS IT CLOSER? MAYBE I SHOULD GO SEE IF THERE'S ANYTHING THERE... *THUD SQUEEELCH* THERE WAS DEFINITELY SOMETHING THERE!!!";
        difficulty = 1;
    }

    /**
     * Returns the name of the nightmare.
     *
     * @return the name of the nightmare
     */
    public String getName() {
        return name;
    }
    
    /**
     * Returns the description of the nightmare.
     *
     * @return the description of the nightmare
     */
    public String getDescription() {
        return description;
    }
    
    /**
     * Returns the difficulty level of the nightmare.
     *
     * @return the difficulty level of the nightmare
     */
    public int getDifficulty() {
        return difficulty;
    }
}

