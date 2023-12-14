package pairmatching.parser;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CrewParser {

    public static List<String> parser(String path) {
        List<String> nameList = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String name;
            while ((name = reader.readLine()) != null) {
                nameList.add(name);
            }
        } catch (IOException exception) {
            throw new IllegalArgumentException("CrewParser.java 에서 알 수 없는 에러 발생");
        }

        return nameList;
    }
}
