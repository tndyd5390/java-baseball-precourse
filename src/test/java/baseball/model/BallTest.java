package baseball.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("Ball 객체 단위 테스트")
class BallTest {

    @DisplayName("Ball 인스턴스 생성 테스트")
    @Test
    void ofTest() throws Exception {

        //given //when
        Ball ball = Ball.of(1, 1);

        //then
        assertThat(ball).isInstanceOf(Ball.class);
    }

    @DisplayName("Ball 숫자 범위 테스트")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6, 7, 8, 9})
    void ballRangeTest(int number) throws Exception {

        //given
        int index = 0;

        //when
        Ball ball = Ball.of(number, index);

        //then
        assertThat(ball).isInstanceOf(Ball.class);
    }

    @DisplayName("Ball 숫자 범위 유효성 검증 테스트")
    @ParameterizedTest
    @ValueSource(ints = {0, 10, -1, 100, Integer.MAX_VALUE, Integer.MIN_VALUE})
    void ballOutOfRangeTest(int number) throws Exception {

        //given
        int index = 0;

        //when //then
        assertThatThrownBy(() -> Ball.of(number, index)).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("Ball 자리수 범위 테스트")
    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2})
    void indexRangeTest(int index) throws Exception {

        //given
        int number = 1;

        //when
        Ball ball = Ball.of(number, index);

        //then
        assertThat(ball).isInstanceOf(Ball.class);
    }

    @DisplayName("Ball 자리수 유효성 검사 테스트")
    @ParameterizedTest
    @ValueSource(ints = {-1, 3, Integer.MIN_VALUE, Integer.MIN_VALUE})
    void indexOutOfRangeTest(int index) throws Exception {

        //given
        int number = 1;

        //when //then
        assertThatThrownBy(() -> Ball.of(number, index)).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("Ball 숫자 가져오는 함수 테스트")
    @Test
    void getNumberTest() throws Exception {

        //given
        int number = 1;
        Ball ball = Ball.of(number, 0);

        //when
        int result = ball.getNumber();

        //then
        assertThat(result).isEqualTo(number);
    }

    @DisplayName("Ball 자리수 가져오는 테스트")
    @Test
    void getIndexTest() throws Exception {

        //given
        int index = 0;
        Ball ball = Ball.of(1, index);

        //when
        int result = ball.getIndex();

        //then
        assertThat(result).isEqualTo(index);
    }

    @DisplayName("Ball 숫자 비교 테스트")
    @Test
    void isSameNumberTest() throws Exception {

        //given
        Ball source = Ball.of(1, 0);
        Ball target = Ball.of(1, 1);

        //when
        boolean result = source.isSameNumber(target);

        //then
        assertThat(result).isTrue();
    }

    @DisplayName("Ball 자리수 비교 테스트")
    @Test
    void isSameIndexTest() throws Exception {

        //given
        Ball source = Ball.of(1, 0);
        Ball target = Ball.of(2, 0);

        //when
        boolean result = source.isSameIndex(target);

        //then
        assertThat(result).isTrue();
    }

}
