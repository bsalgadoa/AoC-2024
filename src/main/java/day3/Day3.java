package day3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import aoc.DayChallenge;

public class Day3 implements DayChallenge {

    private static List<String> extractDoDontBlocks(StringBuilder combinedLine) {
        final List<String> result = new ArrayList<>();

        // Regex para capturar o bloco entre "do()" e "don't()"
        final String regex = "do\\(\\)(.*?)don't\\(\\)";
        final Pattern pattern = Pattern.compile(regex);
        final Matcher matcher = pattern.matcher(combinedLine);

        while (matcher.find()) {
            result.add(matcher.group(1));
        }
        return result;
    }

    private int processMulPattern(String line) {
        int result = 0;
        final Pattern pattern = Pattern.compile("mul\\((\\d{1,3}),(\\d{1,3})\\)");
        final Matcher matcher = pattern.matcher(line);

        while (matcher.find()) {
            final Integer x = Integer.parseInt(matcher.group(1));
            final Integer y = Integer.parseInt(matcher.group(2));
            result += x * y;
        }
        return result;
    }

    @Override
    public Integer solvePart1(File inputFile) throws IOException {
        int result = 0;
        try (final BufferedReader bufferedReader = new BufferedReader(new FileReader(inputFile))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                result += processMulPattern(line);
            }
        }
        return result;
    }

    @Override
    public Integer solvePart2(File inputFile) throws IOException {
        int result = 0;
        // Make the input one single line starting with do() and ending with don't()
        final StringBuilder singleLine = new StringBuilder("do()");
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(inputFile))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                singleLine.append(line);
            }
            singleLine.append("don't()");
        }
        // Calculate the result
        for (final String block : extractDoDontBlocks(singleLine)) {
            result += processMulPattern(block);
        }
        return result;
    }
}