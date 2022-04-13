package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Balls {
    private static final int BAll_SIZE = 3;

    private Ball[] balls;
    private List<BallCount> ballCounts;

    private Balls() {

    }

    private Balls(Ball[] balls) {
        this.balls = balls;
    }

    public static Balls from(Ball[] balls) {
        checkBallSize(balls);
        checkDuplicateBallNumber(balls);
        checkDuplicateBallIndex(balls);
        return new Balls(balls);
    }

    private static void checkBallSize(Ball[] balls) {
        if (balls.length != BAll_SIZE) {
            throw new IllegalArgumentException("out of ball size");
        }
    }

    private static void checkDuplicateBallNumber(Ball[] balls) {
        List<Integer> ballNumbers = new ArrayList<>();
        for (Ball ball : balls) {
            ballNumbers.add(ball.getNumber());
        }
        if (new HashSet<>(ballNumbers).size() != ballNumbers.size()) {
            throw new IllegalArgumentException("is duplicated number");
        }
    }

    private static void checkDuplicateBallIndex(Ball[] balls) {
        List<Integer> ballIndexs = new ArrayList<>();
        for (Ball ball : balls) {
            ballIndexs.add(ball.getIndex());
        }
        if (new HashSet<>(ballIndexs).size() != ballIndexs.size()) {
            throw new IllegalArgumentException("is duplicated index");
        }
    }

    public static Balls from(String playerInput) {
        checkNumber(playerInput);
        checkEmpty(playerInput);
        checkInputLength(playerInput);
        return Balls.from(createBallArray(playerInput));
    }

    private static void checkNumber(String playerInput) {
        if (!playerInput.matches("[1-9]+")) {
            throw new IllegalArgumentException("input must be numberic");
        }
    }

    private static void checkEmpty(String playerInput) {
        if (playerInput.isEmpty()) {
            throw new IllegalArgumentException("input could not be empty");
        }
    }

    private static void checkInputLength(String playerInput) {
        if (playerInput.length() != BAll_SIZE) {
            throw new IllegalArgumentException("input length must be 3");
        }
    }

    private static Ball[] createBallArray(String playerInput) {
        Ball[] balls = new Ball[BAll_SIZE];
        int i = 0;
        for (char number : playerInput.toCharArray()) {
            balls[i] = Ball.of(Character.getNumericValue(number), i);
            i++;
        }
        return balls;
    }

    public static Balls getRandomlyGeneratedBallsInstance() {
        Ball[] balls = new Ball[BAll_SIZE];
        Set<Integer> randomNumberSet = createRandomNumberSet();
        int index = 0;
        for (int randomNumber : randomNumberSet) {
            balls[index] = Ball.of(randomNumber, index);
            index++;
        }
        return Balls.from(balls);
    }

    private static Set<Integer> createRandomNumberSet() {
        Set<Integer> numberSet = new HashSet<>();
        while (numberSet.size() < BAll_SIZE) {
            numberSet.add(Randoms.pickNumberInRange(1, 9));
        }
        return numberSet;
    }

    public Ball[] getBalls() {
        return this.balls;
    }

    public List<BallCount> compareBalls(Balls targetBalls) {
        this.ballCounts = new ArrayList<>();
        for (Ball source : balls) {
            compareEachBalls(source, targetBalls);
        }
        return this.ballCounts;
    }

    private void compareEachBalls(Ball source, Balls targetBalls) {
        for (Ball target : targetBalls.getBalls()) {
            ballCounts.add(source.compareBall(target));
        }
    }

}
