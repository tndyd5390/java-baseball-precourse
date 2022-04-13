package baseball.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("Ball 일급 객체 단위 테스트")
class BallsTest {
    @DisplayName("Ball 일급 객체 인스턴스 생성 테스트")
    @Test
    void fromTest() throws Exception {

        //given
        Ball[] ballArray = new Ball[3];
        for (int i = 0; i < ballArray.length; i++) {
            ballArray[i] = Ball.of(i + 1, i);
        }

        //when
        Balls balls = Balls.from(ballArray);

        //then
        assertThat(balls).isInstanceOf(Balls.class);
    }

    @DisplayName("Ball 일급 객체 배열 크기 유효성 테스트")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 4, 5})
    void ballSizeTest(int ballSize) throws Exception {

        //given
        Ball[] ballArray = new Ball[ballSize];

        //when //then
        assertThatThrownBy(() -> Balls.from(ballArray)).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("Ball 일급 객체 배열 번호 겹침 유효성 테스트")
    @Test
    void checkDuplicateBallNumberTest() throws Exception {

        //given
        Ball[] ballArray = new Ball[3];
        for (int i = 0; i < ballArray.length; i++) {
            ballArray[i] = Ball.of(1, i);
        }

        //when //then
        assertThatThrownBy(() -> Balls.from(ballArray)).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("Ball 일급 객체 자리값 겹침 유효성 테스트")
    @Test
    void checkDuplicateBallIndexTest() throws Exception {

        //given
        Ball[] ballArray = new Ball[3];
        for (int i = 0; i < ballArray.length; i++) {
            ballArray[i] = Ball.of(i + 1, 0);
        }

        //when //then
        assertThatThrownBy(() -> Balls.from(ballArray)).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("Balls 일급 객체 무작위 값 생성 테스트")
    @Test
    void getRandomlyGeneratedBallsInstanceTest() throws Exception {

        //given //when
        Balls balls = Balls.getRandomlyGeneratedBallsInstance();

        //then
        assertAll(
                () -> assertThat(balls.getBalls()).hasSize(3),
                () -> {
                    for (Ball ball : balls.getBalls()) {
                        assertThat(ball).isNotNull();
                    }
                }
        );
    }

    @DisplayName("Balls 객체간 비교테스트(3스트라이크)")
    @Test
    void compareBallStrikeTest() throws Exception {

        //given
        Ball[] ballArray = new Ball[3];
        for (int i = 0; i < ballArray.length; i++) {
            ballArray[i] = Ball.of(i + 1, i);
        }
        Balls source = Balls.from(ballArray);
        Balls target = Balls.from(ballArray);

        //when
        List<BallCount> ballCounts = source.compareBalls(target);

        int result = 0;
        for (BallCount ballCount : ballCounts) {
            result += isStrike(ballCount);
        }

        //then
        assertThat(result).isEqualTo(3);
    }

    private int isStrike(BallCount ballCount) {
        if (ballCount == BallCount.STRIKE) {
            return 1;
        }
        return 0;
    }

}
