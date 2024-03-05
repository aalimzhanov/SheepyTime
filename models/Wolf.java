package models;
public class Wolf implements Nightmare{
    private String name;
    private String description;
    private int difficulty;
    
    public Wolf(){
        name = "Wolf";
        description = "THAT NIGHTMARE WOLF IS NO BIG DEAL. THREE EYES AND IT STILL DOESN'T SEE US SNEAKING PAST! NOPE, DEFINITELY NOT SCARY AT ALL... *HOOOOOOOOOOWL*\r\n" + //
                        "THE WOLF IS RIGHT BEHIND ME ISN'T IT?!?!";
        difficulty = 1;
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
