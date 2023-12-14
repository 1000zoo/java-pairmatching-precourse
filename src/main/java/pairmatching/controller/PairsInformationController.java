package pairmatching.controller;

import pairmatching.constants.ErrorMessage;
import pairmatching.domain.Course;
import pairmatching.domain.Level;
import pairmatching.domain.Mission;
import pairmatching.domain.PairsInformation;
import pairmatching.view.Input;
import pairmatching.view.Output;

public class PairsInformationController {

    private final static Input input = new Input();

    public PairsInformation read() {
        Output.print("#############################################\n"
                + "과정: 백엔드 | 프론트엔드\n"
                + "미션:\n"
                + "  - 레벨1: 자동차경주 | 로또 | 숫자야구게임\n"
                + "  - 레벨2: 장바구니 | 결제 | 지하철노선도\n"
                + "  - 레벨3: \n"
                + "  - 레벨4: 성능개선 | 배포\n"
                + "  - 레벨5: \n"
                + "############################################\n"
                + "과정, 레벨, 미션을 선택하세요.\n"
                + "ex) 백엔드, 레벨1, 자동차경주\n"
        );
        String input = readLine();
        validate(input);
        String[] split = input.split(", ");
        Course course = Course.findByName(split[0]);
        Level level = Level.findLevelByString(split[1]);
        Mission mission = Level.findMissionByString(split[1], split[2]);
        return new PairsInformation(course, level, mission);
    }

    private void validate(String input) {
        String[] split = input.split(", ");
        if (split.length != 3) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_MENU_INPUT.getMessage());
        }
    }

    private String readLine() {
        return input.read();
    }
}
