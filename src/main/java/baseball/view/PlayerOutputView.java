package baseball.view;

public final class PlayerOutputView {

    private PlayerOutputView() {
        
    }

    public static void printGameResult(String result) {
        System.out.println(result);
    }

    public static void printPlayerWin() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }
}
