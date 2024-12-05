package day2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

import aoc.DayChallenge;

public class Day2 implements DayChallenge {

    /*
     * According to the puzzle, isSafe if:
     *  - The levels are either all increasing or all decreasing.
     *  - Any two adjacent levels differ by at least one and at most three.
     */
    private boolean isSafe(final int[] values, final boolean isAscending) {

        for (int i = 0; i < (values.length - 1); i++) {
            final int diff = Math.abs(values[i] - values[i + 1]);

            if ((diff > 3) || (diff < 1)) {
                return false;
            }
            if (isAscending && (values[i + 1] <= values[i])) {
                return false;
            }
            if (!isAscending && (values[i + 1] >= values[i])) {
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

                // if the first 2 are equal, we don't even need to proceed calling the method, we can skip line
                if (report[0] != report[1]) {
                    // determine if it's ascending or not
                    final boolean isAscending = report[0] < report[1];

                    // call the isSafe method with the report and the growing order.
                    if (isSafe(report, isAscending)) {
                        safeReports++;
                    }
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
