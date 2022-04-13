package baseball.model;

public class GameResult {
    private int strike;
    private int ball;

    public GameResult(int strike, int ball) {
        this.strike = strike;
        this.ball = ball;
    }

    public String getGameResultStr() {
        if (isNothing()) {
            return getNothingStr();
        }
        return getBallStr() + getStrikeStr();
    }

    private String getStrikeStr() {
        if (strike != 0) {
            return strike + BallCount.STRIKE.getBallCount() + " ";
        }
        return "";
    }

    private String getBallStr() {
        if (ball != 0) {
            return ball + BallCount.BALL.getBallCount() + " ";
        }
        return "";
    }

    private String getNothingStr() {
        return "낫싱";
    }

    private boolean isNothing() {
        return strike == 0 && ball == 0;
    }

    public boolean isPlayerWin() {
        return strike == 3;
    }
}
