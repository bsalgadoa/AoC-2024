package day2;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import aoc.AbstractDayChallenge;

public class Day2 extends AbstractDayChallenge {

    private boolean canBeMadeSafe(final ArrayList<Integer> report) {
        for (int i = 0; i < report.size(); i++) {
            final ArrayList<Integer> newReport = new ArrayList<>(report);
            newReport.remove(i);

            final boolean isAscending = newReport.get(0) < newReport.get(1);
            if (isSafe(newReport, isAscending)) {
                return true;
            }
        }
        return false;
    }

    /*
     * According to the puzzle, isSafe if:
     *  - The levels are either all increasing or all decreasing.
     *  - Any two adjacent levels differ by at least one and at most three.
     */
    private boolean isSafe(final ArrayList<Integer> report, final boolean isAscending) {
        for (int i = 0; i < (report.size() - 1); i++) {

            final Integer currentValue = report.get(i);
            final Integer nextValue = report.get(i + 1);

            final int diff = Math.abs(currentValue - nextValue);
            if ((diff < 1) || (diff > 3)) {
                return false;
            }
            if (isAscending && (currentValue >= nextValue)) {
                return false;
            }
            if (!isAscending && (currentValue <= nextValue)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public Integer solvePart1(final File inputFile) throws IOException {
        int safeReports = 0;

        // Use the method from AbstractDayChallenge to read the lines from the file
        List<String> lines = getInputAsListOfLines(inputFile);

        // Iterate through the lines to process the reports
        for (String line : lines) {
            final String[] values = line.split("\\s+");
            final ArrayList<Integer> report = new ArrayList<>();

            for (final String value : values) {
                report.add(Integer.parseInt(value));
            }
            // if the first 2 are equal, we don't even need to proceed calling the method, we can skip line
            if (report.get(0) != report.get(1)) {
                final boolean isAscending = report.get(0) < report.get(1);
                // call the isSafe method with the report and the growing order.
                if (isSafe(report, isAscending)) {
                    safeReports++;
                }
            }
        }
        return safeReports;
    }

    @Override
    public Integer solvePart2(final File inputFile) throws IOException {
        int safeReports = 0;

        // Use the method from AbstractDayChallenge to read the lines from the file
        List<String> lines = getInputAsListOfLines(inputFile);

        // Iterate through the lines to process the reports
        for (String line : lines) {
            final String[] values = line.split("\\s+");
            final ArrayList<Integer> report = new ArrayList<>();

            for (final String value : values) {
                report.add(Integer.parseInt(value));
            }

            final boolean isAscending = report.get(0) < report.get(1);

            if (isSafe(report, isAscending) || canBeMadeSafe(report)) {
                safeReports++;
            }
        }
        return safeReports;
    }

}
