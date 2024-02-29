public class Sheep{
    private String color;
    private int position;
    private final int STARTER_POSITION = 1;

    public Sheep(String color){
        this.color = color;
        resetPosition();
    }
    public String getColor() {
        return color;
    }
    public int getPosition() {
        return position;
    }
    public void move(int newPosition) {
        this.position = newPosition;
    }
    public void resetPosition(){
        position = STARTER_POSITION;
    }
}
