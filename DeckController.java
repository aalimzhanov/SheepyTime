public class DeckController implements Controller{
    private Deck deck;
    private DeckView view;
    public DeckController(){
        deck = new Deck();
        populateDeck();
        view = new DeckView();
    }
    public void populateDeck(){
        
    }
    @Override
    public void initialize() {
        
    }
    @Override
    public void updateModel() {
     
    }
    @Override
    public void updateView() {
     
    }
}
