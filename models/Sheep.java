package models;
public class Sheep{
    private String color;
    private boolean isScared;

    public Sheep(String color){
        this.color = color;
        isScared = false;
    }
    public String getColor() {
        return color;
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
