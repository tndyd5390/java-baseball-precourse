package baseball.code;

public enum GameStatus {
    GAME_RESTART("1"), GAME_EXIT("2");

    private String gameStatus;

    GameStatus(String gameStatus) {
        this.gameStatus = gameStatus;
    }

    public static boolean isGameRestart(String gameStatus) {
        return gameStatus.equals(GAME_RESTART.gameStatus);
    }

    public static String validGameStatus(String gameStatus) {
        if (!(gameStatus.equals(GAME_RESTART.gameStatus) || gameStatus.equals(GAME_EXIT.gameStatus))) {
            throw new IllegalArgumentException(ErrorCode.GAMESTATUS_INVALID_INPUT.getErrorMessage());
        }
        return gameStatus;
    }
}
