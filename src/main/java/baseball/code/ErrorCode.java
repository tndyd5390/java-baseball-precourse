package baseball.code;

public enum ErrorCode {
    BALL_OUT_OF_NUMBER_RANGE("BALL001", "out of number range"),
    BALL_OUT_OF_INDEX_RANGE("BALL002", "out of index range"),
    BALLS_BALL_SIZE("BALL001", "ball size is not correct"),
    BALLS_DUPLICATED_NUMBER("BALLS002", "is duplicated number"),
    BALLS_DUPLICATED_INDEX("BALLS003", "is duplicated index"),
    BALLS_NUMBERIC("BALLS004", "input must be numberic"),
    BALLS_EMPTY("BALLS005", "input could not be empty"),
    BALLS_INPUT_LENGTH("BALL006", "invalid input length"),
    GAMESTATUS_INVALID_INPUT("GAMESTATUS001", "invalid input");

    private final String errorCode;
    private final String errorMessage;

    ErrorCode(String errorCode, String errorMessage) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return this.errorMessage;
    }
}
