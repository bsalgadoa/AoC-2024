package day0;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import aoc.DayChallenge;

public class Day0 implements DayChallenge {

    @Override
    public void processInput(final File inputFile) {
        int wordCount = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile))) {
            String line;

            while ((line = reader.readLine()) != null) {

                final String[] words = line.split("\\s+");
                wordCount += words.length;
            }

            System.out.println("Total de palavras '" + inputFile.getName() + "': " + wordCount);

        } catch (final IOException e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
        }
    }
}
