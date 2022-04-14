package baseball.model;

import baseball.code.ErrorCode;

public class Ball {
    private static final int MAX_NUMBER_RANGE = 9;
    private static final int MIN_NUMBER_RANGE = 1;

    private static final int MIN_INDEX_RANGE = 0;
    private static final int MAX_INDEX_RANGE = 2;

    private int number;
    private int index;

    private Ball() {

    }

    private Ball(int number, int index) {
        this.number = number;
        this.index = index;
    }

    public static Ball of(int number, int index) {
        isBetweenNumberRange(number);
        isBetweenIndexRange(index);
        return new Ball(number, index);
    }

    public int getNumber() {
        return this.number;
    }

    public int getIndex() {
        return this.index;
    }

    private static void isBetweenNumberRange(int number) {
        if (number > MAX_NUMBER_RANGE || number < MIN_NUMBER_RANGE) {
            throw new IllegalArgumentException(ErrorCode.BALL_OUT_OF_NUMBER_RANGE.getErrorMessage());
        }
    }

    private static void isBetweenIndexRange(int index) {
        if (index > MAX_INDEX_RANGE || index < MIN_INDEX_RANGE) {
            throw new IllegalArgumentException(ErrorCode.BALL_OUT_OF_INDEX_RANGE.getErrorMessage());
        }
    }

    private boolean isSameNumber(Ball ball) {
        return this.number == ball.getNumber();
    }

    private boolean isSameIndex(Ball ball) {
        return this.index == ball.getIndex();
    }

    public BallCount compareBall(Ball ball) {
        if (isSameIndex(ball) && isSameNumber(ball)) {
            return BallCount.STRIKE;
        }
        if (isSameNumber(ball) && !(isSameIndex(ball))) {
            return BallCount.BALL;
        }
        return BallCount.NOTHING;
    }

}
