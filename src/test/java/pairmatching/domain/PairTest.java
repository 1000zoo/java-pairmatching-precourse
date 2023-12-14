package pairmatching.domain;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pairmatching.TestUtils;

class PairTest {

    @Test
    @DisplayName("같은 페어인 지 확인하는 메서드 테스트")
    void hasSamePairTest() {
        // given
        Pair pair1 = TestUtils.getPair(List.of("지우", "카노", "아메리"));
        Pair pair2 = TestUtils.getPair(List.of("카노", "아메리"));

        // when
        boolean result = pair1.hasSamePair(pair2);

        // then
        Assertions.assertThat(result).isEqualTo(true);

    }

    @Test
    @DisplayName("같은 페어를 포함하지 않는지 테스트")
    void hasNotSamePairTest() {
        // given
        Pair pair1 = TestUtils.getPair(List.of("지우", "아메리"));
        Pair pair2 = TestUtils.getPair(List.of("카노", "아메리"));

        // when
        boolean result = pair1.hasSamePair(pair2);

        // then
        Assertions.assertThat(result).isEqualTo(false);

    }
}