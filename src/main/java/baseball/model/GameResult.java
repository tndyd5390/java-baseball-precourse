package baseball.model;

public class GameResult {
    private String SPACE = " ";
    private String EMPTY = "";
    private String NOTHING = "낫싱";
    private int ZERO = 0;
    private int THREE = 3;

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
            return strike + BallCount.STRIKE.getBallCount() + SPACE;
        }
        return EMPTY;
    }

    private String getBallStr() {
        if (ball != 0) {
            return ball + BallCount.BALL.getBallCount() + SPACE;
        }
        return EMPTY;
    }

    private String getNothingStr() {
        return NOTHING;
    }

    private boolean isNothing() {
        return strike == ZERO && ball == ZERO;
    }

    public boolean isPlayerWin() {
        return strike == THREE;
    }
}
