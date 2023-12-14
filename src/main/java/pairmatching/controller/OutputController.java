package pairmatching.controller;

import pairmatching.domain.Pairs;
import pairmatching.view.Output;

public class OutputController {

    public void printMatchingResults(Pairs pairs) {
        Output.print("페어 매칭 결과입니다.");
        for (String pairString : pairs.pairString()) {
            Output.print(pairString);
        }
        System.out.println();
    }
}
