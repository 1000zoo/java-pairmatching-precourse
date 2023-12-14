package pairmatching.constants;

public enum ErrorMessage {
    INVALID_LEVEL("잘못된 레벨입니다."),
    INVALID_MISSION("잘못된 레벨의 미션입니다."),
    INVALID_COURSE("잘못된 코스입니다."),
    MATCHING_FAILED("매칭에 실패하였습니다."),
    INVALID_MENU_INPUT("잘못된 입력입니다."),
    INVALID_PAIRS("해당 페어가 등록되지 않았습니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return "[ERROR]" + message;
    }
}
