package baseball.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("게임 결과 문자열 생성 객체 단위 테스트")
class GameResultTest {

    @DisplayName("객체 생성 테스트")
    @Test
    void newTest() throws Exception {

        //given //when
        GameResult gameResult = new GameResult(1, 2);

        //then
        assertThat(gameResult).isInstanceOf(GameResult.class);
    }

    @DisplayName("게임 결과 문자열 테스트(1스트라이크 1볼)")
    @Test
    void gameResultStr1Strike1Ball() throws Exception {

        //given //when
        GameResult gameResult = new GameResult(1, 1);

        //when
        String resultStr = gameResult.getGameResultStr();

        //then
        assertThat(resultStr).isEqualTo("1볼 1스트라이크 ");
    }

    @DisplayName("게임 결과 문자열 테스트(낫싱)")
    @Test
    void gameResultStrNothingTest() throws Exception {

        //given //when
        GameResult gameResult = new GameResult(0, 0);

        //when
        String resultStr = gameResult.getGameResultStr();

        //then
        assertThat(resultStr).isEqualTo("낫싱");

    }

    @DisplayName("게임 결과 문자열 테스트(1스트라이크)")
    @Test
    void gameResultStr1StrikeTest() throws Exception {

        //given //when
        GameResult gameResult = new GameResult(1, 0);

        //when
        String resultStr = gameResult.getGameResultStr();

        //then
        assertThat(resultStr).isEqualTo("1스트라이크 ");
    }

    @DisplayName("게임 결과 문자열 테스트(1볼)")
    @Test
    void gameResultStr1BallTest() throws Exception {

        //given //when
        GameResult gameResult = new GameResult(0, 1);

        //when
        String resultStr = gameResult.getGameResultStr();

        //then
        assertThat(resultStr).isEqualTo("1볼 ");
    }

    @DisplayName("게임 결과 문자열 사용자가 이겼는지 확인")
    @Test
    void isPlayerWinTest() throws Exception {

        //given
        GameResult gameResult = new GameResult(3, 0);

        //when
        boolean isPlayerWin = gameResult.isPlayerWin();

        //then
        assertThat(isPlayerWin).isTrue();
    }
}
