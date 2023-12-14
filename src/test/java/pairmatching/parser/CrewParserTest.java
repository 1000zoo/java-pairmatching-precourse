package pairmatching.parser;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CrewParserTest {

    @Test
    @DisplayName("md 파일에서 이름 불러오기")
    void parserTest() {
        // given
        String path = "src/main/resources/backend-crew.md";

        // when
        List<String> nameList = CrewParser.parser(path);

        // then
        System.out.println(nameList);

    }

}