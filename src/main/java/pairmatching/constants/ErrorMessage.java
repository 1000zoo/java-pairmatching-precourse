package pairmatching.constants;

public enum ErrorMessage {
    INVALID_LEVEL("잘못된 레벨입니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return "[ERROR]" + message;
    }
}
