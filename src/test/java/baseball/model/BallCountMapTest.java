package baseball.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("게임 결과 집계 객체 단위 테스트")
class BallCountMapTest {

    private List<BallCount> ballCounts;


    @BeforeEach
    void setUp() {
        ballCounts = new ArrayList<>();
        ballCounts.add(BallCount.STRIKE);
        ballCounts.add(BallCount.NOTHING);
        ballCounts.add(BallCount.BALL);
    }

    @DisplayName("인스턴스 생성 테스트")
    @Test
    void fromTest() throws Exception {

        //given //when
        BallCountMap ballCountMap = BallCountMap.from(ballCounts);

        //then
        assertThat(ballCountMap).isInstanceOf(BallCountMap.class);
    }

    @DisplayName("스트라이크 집계 테스트")
    @Test
    void getStrikeFromMapTest() throws Exception {

        //given
        BallCountMap ballCountMap = BallCountMap.from(ballCounts);

        //when
        int strike = ballCountMap.getStrikeFromMap();

        //then
        assertThat(strike).isEqualTo(1);
    }

    @DisplayName("볼 집계 테스트")
    @Test
    void getBallFromMapTest() throws Exception {

        //given
        BallCountMap ballCountMap = BallCountMap.from(ballCounts);

        //when
        int ball = ballCountMap.getBallFromMap();

        //then
        assertThat(ball).isEqualTo(1);
    }

}
