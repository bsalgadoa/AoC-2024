package day2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

import aoc.DayChallenge;

public class Day2 implements DayChallenge {

    private boolean isSafe(final int[] values, final boolean isAscendig) {

        for (int i = 0; i < (values.length - 1); i++) {
            if (((Math.abs(values[i] - values[(i + 1)])) > 3) || ((Math.abs(values[i] - values[i + 1])) < 1)) {
                return false;
            }
            if (isAscendig && (values[i + 1] <= values[i])) {
                return false;
            }
            if (!isAscendig && (values[i + 1] >= values[i])) {
                return false;
            }
        }
        return true;
    }

    @Override
    public Integer solvePart1(final File inputFile) throws IOException {
        int safeReports = 0;
        try (final BufferedReader bufferedReader = new BufferedReader(new FileReader(inputFile))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {

                final int[] report = Arrays.stream(line.split("\\s+")).mapToInt(Integer::parseInt).toArray();

                if (report[0] == report[1]) {
                    continue;
                }
                boolean isAscendig = true;
                if (report[0] > report[1]) {
                    isAscendig = false;
                }
                if (isSafe(report, isAscendig)) {
                    safeReports += 1;
                }
            }
        }
        return safeReports;
    }

    @Override
    public Integer solvePart2(final File inputFile) throws IOException {
        // TODO Auto-generated method stub
        return null;
    }

}
