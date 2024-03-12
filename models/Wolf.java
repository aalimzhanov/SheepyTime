package models;
/**
 * Represents a Wolf nightmare.
 * 
 * @author Adil Alimzhanov, Tan Karageldi, Tolga Cohce, Derrick Ansah
 */
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
     * Returns the name of the Wolf.
     * 
     * @return the name of the Wolf
     */
    public String getName() {
        return name;
    }
    
    /**
     * Returns the description of the Wolf.
     * 
     * @return the description of the Wolf
     */
    public String getDescription() {
        return description;
    }
    
    /**
     * Returns the difficulty level of the Wolf.
     * 
     * @return the difficulty level of the Wolf
     */
    public int getDifficulty() {
        return difficulty;
    }
}
