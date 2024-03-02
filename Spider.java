public class Spider implements Nightmare{
    private String name;
    private String description;
    private int difficulty;
    
    public Spider(){
        name = "Spider";
        description = "Big scary spider";
        difficulty = 2;
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
