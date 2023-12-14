package pairmatching.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import pairmatching.constants.ErrorMessage;

public class Missions {

    private final List<Mission> missions;

    private Missions(List<Mission> missions) {
        this.missions = missions;
    }

    public static Missions of(List<String> missionNames) {
        return new Missions(
                missionNames.stream().map(Mission::new).collect(Collectors.toList())
        );
    }

    public static Missions emptyMissions() {
        return new Missions(Collections.emptyList());
    }

    public Mission findMissionByName(String name) {
        return missions.stream()
                .filter(mission -> name.equals(mission.name()))
                .findAny()
                .orElseThrow(ErrorMessage.INVALID_MISSION.getMessage());
    }
}
