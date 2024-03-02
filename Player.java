import java.util.Arrays;

public class Player implements Movable{
    private String name;
    private Sheep sheep;
    private Card[] hand;
    private int zzzs;
    private int winks;
    public Player(String name, String sheepColor){
        this.name = name;
        this.sheep = new Sheep(sheepColor);
        hand = new Card[2];
        zzzs = 10;
        winks = 0;
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
    public void pickUpCard(int index, Card newCard){
        hand[index] = newCard;
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
    @Override
    public void crossTheFence() {
    //    Do something
    }
    @Override
    public void move(int newPos) {
        sheep.move(newPos);
    }
    public boolean isScared(){
        return sheep.isScared();
    }
    public void scareSheep(){
        sheep.scare();
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

}
