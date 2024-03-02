public class Wolf implements Nightmare{
    private String name;
    private String description;
    private int difficulty;
    
    public Wolf(){
        name = "Wolf";
        description = "Big scary wolf";
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
