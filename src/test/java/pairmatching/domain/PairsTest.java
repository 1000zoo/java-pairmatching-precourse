package pairmatching.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pairmatching.TestUtils;

class PairsTest {

    private final PairsInformation information = new PairsInformation(Course.BACKEND, Level.LEVEL1, new Mission(""));


    @Test
    @DisplayName("중복되는 페어를 가졌는 지 확인하는 메서드 테스트")
    void hasSamePairTest() {
        // given
        Pair pair1 = TestUtils.getPair(List.of("지우", "카노"));
        Pair pair2 = TestUtils.getPair(List.of("형섭", "대만"));

        Pair pair3 = TestUtils.getPair(List.of("지우", "카노"));
        Pair pair4 = TestUtils.getPair(List.of("대만", "카노"));

        // when
        Pairs pairs1 = new Pairs(List.of(pair1, pair2), information);
        Pairs pairs2 = new Pairs(List.of(pair3, pair4), information);

        boolean result = pairs1.hasSamePair(pairs2);

        // then
        assertThat(result).isEqualTo(true);

    }

    @Test
    @DisplayName("중복되는 페어를 가지지 않았는 지 테스트")
    void hasNotSamePairTest() {
        // given
        Pair pair1 = TestUtils.getPair(List.of("지우", "카노"));
        Pair pair2 = TestUtils.getPair(List.of("형섭", "대만"));

        Pair pair3 = TestUtils.getPair(List.of("지우", "형섭"));
        Pair pair4 = TestUtils.getPair(List.of("대만", "카노"));

        // when
        Pairs pairs1 = new Pairs(List.of(pair1, pair2), information);
        Pairs pairs2 = new Pairs(List.of(pair3, pair4), information);

        boolean result = pairs1.hasSamePair(pairs2);

        // then
        assertThat(result).isEqualTo(false);

    }
}