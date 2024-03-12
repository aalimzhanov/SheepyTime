package models;
/**
 * The Nightmare interface represents a nightmare in the game.
 * Nightmares have a name, description, and difficulty level.
 * 
 * @author Adil Alimzhanov, Tan Karageldi, Tolga Cohce, Derrick Ansah
 */
public interface Nightmare {
    
    /**
     * Gets the name of the nightmare.
     * 
     * @return the name of the nightmare
     */
    public String getName();
    
    /**
     * Gets the description of the nightmare.
     * 
     * @return the description of the nightmare
     */
    public String getDescription();
    
    /**
     * Gets the difficulty level of the nightmare.
     * 
     * @return the difficulty level of the nightmare
     */
    public int getDifficulty();
}