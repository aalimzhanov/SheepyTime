package factories;

import java.util.List;
import java.util.stream.Collectors;

import controllers.PlayerController;
import controllers.ScoreBoardController;
import models.Player;
import models.ScoreBoard;
import views.ScoreBoardView;

public class ScoreBoardFactory {
    public static ScoreBoardController initializeScoreBoard(List<PlayerController> playerControllers) {
        List<Player> players = playerControllers.stream().map(PlayerController::getModel).collect(Collectors.toList());
        ScoreBoard scoreBoard = new ScoreBoard(players);
        ScoreBoardView scoreBoardView = new ScoreBoardView();
        ScoreBoardController scoreBoardController = new ScoreBoardController(scoreBoard, scoreBoardView);

        return scoreBoardController;
    }
}