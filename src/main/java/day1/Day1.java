package day1;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import aoc.AbstractDayChallenge;

public class Day1 extends AbstractDayChallenge {

    @Override
    public Integer solvePart1(final File inputFile) throws IOException {
        List<String> lines = getInputAsListOfLines(inputFile);

        final ArrayList<Integer> leftList = new ArrayList<>();
        final ArrayList<Integer> rightList = new ArrayList<>();

        for (String line : lines) {
            String[] numbers = line.split("\\s+");
            leftList.add(Integer.parseInt(numbers[0]));
            rightList.add(Integer.parseInt(numbers[1]));
        }

        Collections.sort(leftList);
        Collections.sort(rightList);

        int total = 0;
        for (int i = 0; i < leftList.size(); i++) {
            total += Math.abs(leftList.get(i) - rightList.get(i));
        }
        return total;
    }

    @Override
    public Integer solvePart2(final File inputFile) throws IOException {
        List<String> lines = getInputAsListOfLines(inputFile);

        final ArrayList<Integer> leftList = new ArrayList<>();
        final Map<Integer, Integer> map = new HashMap<>();

        for (String line : lines) {
            String[] numbers = line.split("\\s+");

            final Integer leftValue = Integer.parseInt(numbers[0]);
            leftList.add(leftValue);

            final Integer rightValue = Integer.parseInt(numbers[1]);
            map.compute(rightValue, (k, v) -> (v == null) ? 1 : v + 1);
        }

        int result = 0;
        for (final Integer leftValue : leftList) {
            result += (leftValue * map.getOrDefault(leftValue, 0));
        }
        return result;
    }
}
