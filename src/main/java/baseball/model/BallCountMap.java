package baseball.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BallCountMap {

    private Map<BallCount, Integer> ballCountMap;

    private BallCountMap() {

    }

    private BallCountMap(Map<BallCount, Integer> ballCountMap) {
        this.ballCountMap = ballCountMap;
    }

    public static BallCountMap from(List<BallCount> ballCounts) {
        Map<BallCount, Integer> ballCountMap = new HashMap<>();
        for (BallCount ballCount : ballCounts) {
            ballCountMap.put(ballCount, ballCountMap.getOrDefault(ballCount, 0) + 1);
        }
        return new BallCountMap(ballCountMap);
    }

    public int getStrikeFromMap() {
        return ballCountMap.getOrDefault(BallCount.STRIKE, 0);
    }

    public int getBallFromMap() {
        return ballCountMap.getOrDefault(BallCount.BALL, 0);
    }

}
