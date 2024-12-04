package day1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import aoc.DayChallenge;

public class Day1 implements DayChallenge {

    @Override
    public Integer solvePart1(final File inputFile) throws IOException {

        final ArrayList<Integer> leftList = new ArrayList<>();
        final ArrayList<Integer> rightList = new ArrayList<>();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(inputFile))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                final String[] numbers = line.split("\\s+");

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
    }

    @Override
    public Integer solvePart2(final File inputFile) throws IOException {

        final ArrayList<Integer> leftList = new ArrayList<>();
        final Map<Integer, Integer> map = new HashMap<>();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(inputFile))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                final String[] numbers = line.split("\\s+");

                final Integer leftValue = Integer.parseInt(numbers[0]);
                leftList.add(leftValue);

                final Integer rightValue = Integer.parseInt(numbers[1]);
                map.compute(rightValue, (k, v) -> (v == null) ? 1 : v + 1);
            }
        }

        int result = 0;
        for (final Integer leftValue : leftList) {
            if (map.containsKey(leftValue)) {
                result += (leftValue * map.get(leftValue));
            }
        }
        return result;
    }
}