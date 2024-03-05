package models;
public class BumpInTheNight implements Nightmare {
    private String name;
    private String description;
    private int difficulty;
    
    public BumpInTheNight(){
        name = "Bump In The Night";
        description = "*THUD* WHAT WAS THAT SOUND? PROBABLY NOTHING, THERE'S ONLY SHADOWS. *THUD* I THINK I HEARD A BUMP IN THE NIGHT AGAIN. WAS IT CLOSER? MAYBE I SHOULD GO SEE IF THERE'S ANYTHING THERE... *THUD SQUEEELCH* THERE WAS DEFINITELY SOMETHING THERE!!!";
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

