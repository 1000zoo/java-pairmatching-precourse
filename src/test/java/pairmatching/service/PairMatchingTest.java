package pairmatching.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pairmatching.domain.Course;
import pairmatching.domain.CrewMembers;
import pairmatching.domain.Level;
import pairmatching.domain.Pairs;
import pairmatching.domain.PairsInformation;
import pairmatching.repository.CrewRepository;

class PairMatchingTest {

    private CrewMembers crewMembers;
    private final PairMatching pairMatching = new PairMatching();
    private final PairsInformation information = new PairsInformation(
            Course.FRONTEND, Level.LEVEL1, Level.findMissionByString("레벨1", "로또")
    );

    @BeforeEach
    private void setUp() {
        CrewRepository repository = new CrewRepository();
        repository.init();
        crewMembers = repository.findCrewMembersByCourseName("프론트엔드");
    }

    @Test
    @DisplayName("PairMatching 테스트")
    void pairmatchingTest() {
        Pairs pairs = pairMatching.createPairs(information, crewMembers);

        System.out.println("pairs = " + pairs);

    }
}