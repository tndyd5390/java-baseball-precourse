package baseball.code;

public enum BallCode {
    MAX_NUMBER_RANGE(9),
    MIN_NUMBER_RANGE(1),
    MIN_INDEX_RANGE(0),
    MAX_INDEX_RANGE(2);

    private int ballCode;

    BallCode(int ballCode) {
        this.ballCode = ballCode;
    }

    public int getBallCode() {
        return this.ballCode;
    }

}
