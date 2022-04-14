package baseball.controller;

import baseball.code.GameStatus;
import baseball.model.BallCountMap;
import baseball.model.Balls;
import baseball.model.GameResult;
import baseball.view.PlayerInputView;
import baseball.view.PlayerOutputView;

public class BaseballGameController {

    public void playBaseBall() {
        do {
            Balls computerBalls = Balls.getRandomlyGeneratedBallsInstance();
            playBaseBallRound(computerBalls);
            PlayerOutputView.printPlayerWin();
        } while (GameStatus.isGameRestart(validPlayerInput()));
    }

    private void playBaseBallRound(Balls computerBalls) {
        GameResult gameResult;
        do {
            Balls playerBalls = createPlayerBalls();
            BallCountMap ballCountMap = BallCountMap.from(computerBalls.compareBalls(playerBalls));
            gameResult = new GameResult(ballCountMap.getStrikeFromMap(), ballCountMap.getBallFromMap());
            PlayerOutputView.printGameResult(gameResult.getGameResultStr());
        } while (!gameResult.isPlayerWin());
    }

    private Balls createPlayerBalls() {
        String playerInput = PlayerInputView.inputNumbers();
        return Balls.from(playerInput);
    }

    private String validPlayerInput() {
        return GameStatus.validGameStatus(PlayerInputView.inputGameRestartOrExit());
    }
}
