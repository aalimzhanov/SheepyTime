package models;
public class Spider implements Nightmare{
    private String name;
    private String description;
    private int difficulty;
    
    public Spider(){
        name = "Spider";
        description = "THIS WEB IS PRETTY RELAXING, KINDA LIKE A HAMMOCK! AND I'M SURE I CAN GET FREE BEFORE THE SINISTER SPIDER COMES BACK. *WEB SHAKES* IT IS RATHER STICKY, THOUGH. CAN SOMEONE HELP ME OUT? *SHAKING\r\n" + //
                        "INTENSIFIES* GET ME OUTTA HERE!!!";
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
