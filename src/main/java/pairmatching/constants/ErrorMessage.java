package pairmatching.constants;

public enum ErrorMessage {
    INVALID_LEVEL("잘못된 레벨입니다."),
    INVALID_MISSION("잘못된 레벨의 미션입니다."),
    INVALID_COURSE("잘못된 코스입니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return "[ERROR]" + message;
    }
}
