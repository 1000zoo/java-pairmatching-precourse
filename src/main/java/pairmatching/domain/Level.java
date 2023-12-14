package pairmatching.domain;

import java.util.Arrays;
import java.util.List;
import pairmatching.constants.ErrorMessage;

public enum Level {
    LEVEL1("레벨1", Missions.of(List.of("자동차경주", "로또", "숫자야구게임"))),
    LEVEL2("레벨2", Missions.of(List.of("장바구니", "결제", "지하철노선도"))),
    LEVEL3("레벨3", Missions.emptyMissions()),
    LEVEL4("레벨4", Missions.of(List.of("성능개선", "배포"))),
    LEVEL5("레벨5", Missions.emptyMissions());

    private final String level;
    private final Missions missions;

    Level(String level, Missions missions) {
        this.level = level;
        this.missions = missions;
    }

    public String getLevel() {
        return level;
    }

    public static Level findLevelByString(String lv) {
        return Arrays.stream(values())
                .filter(level -> lv.equals(level.getLevel()))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(ErrorMessage.INVALID_LEVEL.getMessage()));
    }
}
