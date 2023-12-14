package pairmatching.domain;

import java.util.Arrays;
import pairmatching.constants.ErrorMessage;

public enum Level {
    LEVEL1("레벨1"),
    LEVEL2("레벨2"),
    LEVEL3("레벨3"),
    LEVEL4("레벨4"),
    LEVEL5("레벨5");

    private final String level;

    Level(String level) {
        this.level = level;
    }

    public String getLevel() {
        return level;
    }

    public static Level findByString(String lv) {
        return Arrays.stream(values())
                .filter(level -> lv.equals(level.getLevel()))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(ErrorMessage.INVALID_LEVEL.getMessage()));
    }
}
