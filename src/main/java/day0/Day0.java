package day0;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import aoc.DayChallenge;

/**
 * A classe Day0 é uma implementação de teste básico para assegurar que o main e a interface DayChallenge estão a funcionar.
 *
 * O objetivo desta classe é apenas validar a interação entre a implementação da interface e o processo de leitura de ficheiros,
 * além de garantir que os métodos da interface sejam chamados corretamente.
 * A parte 1 conta o número de palavras no ficheiro de entrada.
 * A parte 2 não foi implementada.
 */
public class Day0 implements DayChallenge {

    @Override
    public Integer solvePart1(final File inputFile) {
        int wordCount = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile))) {
            String line;

            while ((line = reader.readLine()) != null) {

                final String[] words = line.split("\\s+");
                wordCount += words.length;
            }

        } catch (final IOException e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
        }
        return wordCount;
    }

    @Override
    public Integer solvePart2(final File inputFile) throws IOException {
        // TODO Auto-generated method stub
        return null;
    }
}
