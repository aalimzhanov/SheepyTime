import java.util.ArrayList;
import java.util.List;

public class ScoreBoard {
    private List<List<Token>> tokens;
    private PillowReferenceTile referenceTile;
    public ScoreBoard(int numOfPlayers){
        tokens = new ArrayList<>();
        populateScoreBoard();
        referenceTile = new PillowReferenceTile(numOfPlayers);
    }

    private void populateScoreBoard(){
        for (int i = 0; i < 40; i++){
            List<Token> temp = new ArrayList<>();
            tokens.add(temp);
        }
    }

    

}

