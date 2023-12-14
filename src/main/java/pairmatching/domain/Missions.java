package pairmatching.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

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
}
