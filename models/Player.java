package models;
import java.util.Arrays;

public class Player implements Movable{
    private String name;
    private Sheep sheep;
    private Card[] hand;
    private String sleepTime;
    private int zzzs;
    private int winks;
    private boolean crossedTheFence;
    public Player(String name, String sheepColor, String sleepTime){
        this.name = name;
        this.sheep = new Sheep(sheepColor);
        this.sleepTime = sleepTime;
        hand = new Card[2];
        zzzs = 10;
        winks = 0;
        crossedTheFence = false;
    }
    public String getName() {
        return name;
    }
    public Sheep getSheep() {
        return sheep;
    }
    public Card getCard(int index) {
        return hand[index];
    }
    public int getNumOfZzzs() {
        return zzzs;
    }
    public String getSleepTime() {
        return sleepTime;
    }
    public void gainCard(Card newCard){
        if(hand[0] == null){
            hand[0] = newCard;
        } else if(hand[1] == null){
            hand[1] = newCard;
        } else {
            throw new IllegalStateException("Hand is full");
        }
    }
    public void resetWinks(){
        winks = 0;
    }

    public Card playCard(int index){
        Card playerCard = hand[index];
        hand[index] = null;
        return playerCard;
    }
    public void catchZZZs(int amount){
        if(amount > zzzs){
            throw new IllegalStateException("Not enough zzzs");
        }
        zzzs -= amount;
    }
    public boolean isScared(){
        return sheep.isScared();
    }
    
    public void becomeBrave(){
        sheep.becomeBrave();
    }
    public void gainWinks(int amount){
        winks += amount;
    }
    public int getWinks(){
        return winks;
    }
    public void discardHand() {
        Arrays.fill(hand, null); 
    }

    public void resetFence(){
        crossedTheFence = false;
    }
    public boolean hasCrossedFence(){
        return crossedTheFence;
    }
    @Override
    public void crossFence() {
        crossedTheFence = true;
    }
    @Override
    public void becomeScared(){
        sheep.scare();
    }
}
