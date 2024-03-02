public class Sheep{
    private String color;
    private int position;
    private boolean isScared;
    private final int STARTER_POSITION = 1;

    public Sheep(String color){
        this.color = color;
        resetPosition();
        isScared = false;
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
    public boolean isScared(){
        return isScared;
    }
    public void scare(){
        isScared = true;
    }
    public void becomeBrave(){
        isScared = false;
    }
    
}
