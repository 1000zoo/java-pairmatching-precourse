package pairmatching.domain;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PairTest {

    @Test
    @DisplayName("같은 페어인 지 확인하는 메서드 테스트")
    void hasSamePairTest() {
        // given
        Pair pair1 = getPair(List.of("지우", "카노", "아메리"));
        Pair pair2 = getPair(List.of("카노", "아메리"));

        // when
        boolean result = pair1.hasSamePair(pair2);

        // then
        Assertions.assertThat(result).isEqualTo(true);

    }

    @Test
    @DisplayName("같은 페어를 포함하지 않는지 테스트")
    void hasNotSamePairTest() {
        // given
        Pair pair1 = getPair(List.of("지우", "아메리"));
        Pair pair2 = getPair(List.of("카노", "아메리"));

        // when
        boolean result = pair1.hasSamePair(pair2);

        // then
        Assertions.assertThat(result).isEqualTo(false);

    }

    private Pair getPair(List<String> names) {
        return new Pair(getCrewMembers(names));
    }

    private List<Crew> getCrewMembers(List<String> names) {
        return names.stream().map(this::getBackendCrew).toList();
    }

    private Crew getBackendCrew(String name) {
        return new Crew(name, Course.BACKEND);
    }
}