package aoc;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public abstract class AbstractDayChallenge {

    // Métodos abstratos a serem implementados pelos DayN
    public abstract Integer solvePart1(File inputFile) throws IOException;

    public abstract Integer solvePart2(File inputFile) throws IOException;

    // Métodos de leitura do input:

    /*
    * Lê o input e retorna as linhas como uma lista de strings.
    */
    protected List<String> getInputAsListOfLines(File inputFile) throws IOException {
        List<String> lines = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(inputFile))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                lines.add(line);
            }
        }
        return lines;
    }

    /*
    * Lê o input e converte as linhas numa matriz de tipo genérico T.
    * @param converter Uma função que converte cada linha de String num array do tipo T[].
    */
//    protected <T> T[][] getInputAsMatrix(File inputFile, Function<String, T[]> converter) throws IOException {
//        List<String> lines = getInputAsListOfLines(inputFile);
//
//        @SuppressWarnings("unchecked")
//        T[][] matrix = (T[][]) Array.newInstance(converter.apply("").getClass(), lines.size());
//
//        return lines.stream().map(converter) // Aplica a transformação para cada linha
//                .toArray(size -> matrix); // Cria a matriz final
//    }

    protected <T> T[][] getInputAsMatrix(File inputFile, Function<String, T[]> converter) throws IOException {
        // Lê o arquivo como uma lista de linhas
        List<String> lines = getInputAsListOfLines(inputFile);

        // Inicializa a matriz com o tipo T
        @SuppressWarnings("unchecked")
        T[][] matrix = (T[][]) Array.newInstance(converter.apply(lines.get(0)).getClass(), lines.size());

        // Preenche a matriz com as linhas convertidas
        for (int i = 0; i < lines.size(); i++) {
            matrix[i] = converter.apply(lines.get(i));  // Converte cada linha
        }

        return matrix;
    }

}