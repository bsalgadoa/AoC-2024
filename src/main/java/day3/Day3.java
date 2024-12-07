package day3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import aoc.DayChallenge;

public class Day3 implements DayChallenge {

    @Override
    public Integer solvePart1(File inputFile) throws IOException {

        int result = 0;

        try (final BufferedReader bufferedReader = new BufferedReader(new FileReader(inputFile))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {

                final Pattern pattern = Pattern.compile("mul\\((\\d{1,3}),(\\d{1,3})\\)");
                final Matcher matcher = pattern.matcher(line);

                while (matcher.find()) {
                    final Integer x = Integer.parseInt(matcher.group(1));
                    final Integer y = Integer.parseInt(matcher.group(2));
                    result += x * y;
                }
            }
        }
        return result;
    }

    @Override
    public Integer solvePart2(File inputFile) throws IOException {
        // TODO Auto-generated method stub
        return null;
    }

}
