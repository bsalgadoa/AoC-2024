package day4;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import aoc.DayChallenge;

public class Day4 implements DayChallenge {

    @Override
    public Integer solvePart1(File inputFile) throws IOException {

        int result = 0;

        try (final BufferedReader bufferedReader = new BufferedReader(new FileReader(inputFile))) {

            final List<char[]> lines = new ArrayList<>();
            String line;

            // cada linha um array de chars, adicionado à lista
            while ((line = bufferedReader.readLine()) != null) {
                lines.add(line.toCharArray());
            }
            // list to Matrix
            final char[][] matrix = new char[lines.size()][];
            for (int i = 0; i < lines.size(); i++) {
                matrix[i] = lines.get(i);
            }
            final int rows = matrix.length;
            final int cols = matrix[0].length;
            // iterar a matriz à procura de X
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    if ((matrix[i][j] == 'X')) {
                        //contar palavras ao redor desse X
                        result += countSurroundingWords(matrix, i, j);
                    }
                }
            }
            return result;
        }
    }

    @Override
    public Integer solvePart2(File inputFile) throws IOException {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * Verifica se as coordenadas (i, j) estão dentro dos limites da matriz
     */
    private static boolean isWithinBounds(char[][] matrix, int i, int j) {
        return (((i >= 0) && (i < matrix.length)) && ((j >= 0) && (j < matrix[0].length)));
    }

    /**
     * Conta o número de palavras existentes nas 8 direções ao redor da posição (i,j).
     */
    private int countSurroundingWords(char[][] matrix, int i, int j) {
        int surroundingWords = 0;
        int[][] directions = { { -1, -1 }, { -1, 0 }, { -1, 1 }, { 0, -1 }, { 0, 1 }, { 1, -1 }, { 1, 0 }, { 1, 1 } };

        for (int[] direction : directions) {
            int di = direction[0];
            int dj = direction[1];

            if (isWithinBounds(matrix, i + di, j + dj) && (matrix[i + di][j + dj] == 'M')
                    && isWithinBounds(matrix, i + (2 * di), j + (2 * dj)) && (matrix[i + (2 * di)][j + (2 * dj)] == 'A')
                    && isWithinBounds(matrix, i + (3 * di), j + (3 * dj)) && (matrix[i + (3 * di)][j + (3 * dj)] == 'S')) {
                surroundingWords++;
            }
        }
        return surroundingWords;
    }
}
