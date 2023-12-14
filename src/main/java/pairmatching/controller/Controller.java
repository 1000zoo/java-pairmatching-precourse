package pairmatching.controller;

import pairmatching.constants.ErrorMessage;
import pairmatching.domain.CrewMembers;
import pairmatching.domain.Pairs;
import pairmatching.domain.PairsInformation;
import pairmatching.repository.CrewRepository;
import pairmatching.service.PairMatching;
import pairmatching.view.Input;
import pairmatching.view.Output;

public class Controller {
    private final static Input input = new Input();
    private final static OutputController outputController = new OutputController();

    private final PairMatching pairMatching = new PairMatching();
    private final CrewRepository repository;

    public Controller() {
        repository = new CrewRepository();
        repository.init();
    }

    public void start() {
        int menu;
        try {
            while ((menu = readMenu()) != 0) {
                run(menu);
            }
        } catch (IllegalArgumentException exception) {
            Output.print(exception.getMessage());
            start();
        }
    }

    private void run(int menu) {
        if (menu == 1) {
            matching();
            return;
        }
        if (menu == 2) {
            searching();
            return;
        }
        clear();

    }

    private void matching() {
        PairsInformation information = readInformation();
        if (pairMatching.hasSameInformationsPair(information) && !askRematching()) {
            return;
        }
        CrewMembers crewMembers = repository.findCrewMembersByCourseName(information.course().getName());
        Pairs pairs = pairMatching.createPairs(information, crewMembers);
        outputController.printMatchingResults(pairs);
    }

    private PairsInformation readInformation() {
        try {
            PairsInformationController controller = new PairsInformationController();
            return controller.read();
        } catch (IllegalArgumentException exception) {
            Output.print(exception.getMessage());
            return readInformation();
        }
    }

    private boolean askRematching() {
        Output.print("매칭 정보가 있습니다. 다시 매칭하시겠습니까?\n"
                + "네 | 아니오");
        try {
            String line = input.read();
            validateAskRematching(line);
            return line.equals("네");
        } catch (IllegalArgumentException exception) {
            Output.print(exception.getMessage());
            return askRematching();
        }
    }

    private void validateAskRematching(String input) {
        if (!input.equals("네") && !input.equals("아니오")) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_MENU_INPUT.getMessage());
        }
    }

    private void searching() {
        PairsInformationController controller = new PairsInformationController();
        PairsInformation information = controller.read();
        outputController.printMatchingResults(pairMatching.findPairsByInformation(information));
    }

    private void clear() {
        pairMatching.clear();
    }

    private int readMenu() {
        Output.print("기능을 선택하세요.\n"
                + "1. 페어 매칭\n"
                + "2. 페어 조회\n"
                + "3. 페어 초기화\n"
                + "Q. 종료");
        String line = input.read();
        validateMenuInput(line);
        if (line.equals("Q")) {
            return 0;
        }
        return Integer.parseInt(line);
    }

    private void validateMenuInput(String input) {
        try {
            int menu = Integer.parseInt(input);
            if (menu < 1 || menu > 3) {
                throw new IllegalArgumentException(ErrorMessage.INVALID_MENU_INPUT.getMessage());
            }
        } catch (NumberFormatException exception) {
            if (!input.equals("Q")) {
                throw new IllegalArgumentException(ErrorMessage.INVALID_MENU_INPUT.getMessage());
            }
        }
    }

}
