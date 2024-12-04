package aoc;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class Main {

    public static void main(final String[] args) {
        runDay(1);

//        runDay(Day.DAY_1);

//        for (final Day day : Day.values()) {
//            runDay(day.getDayNumber());
//        }

    }

    // Método comum para processar o dia, usado por ambos os overloads
    private static void processDay(final String className, final File inputFile) {
        System.out.println("\nRunning " + className + ":\n");

        try {
            // Verifica se o input existe
            if (!inputFile.exists()) {
                System.out.println("Erro: O input '" + inputFile + "' não foi encontrado.");
                return;
            }
            // Se o arquivo estiver vazio, avisa
            final String input = new String(Files.readAllBytes(inputFile.toPath()));
            if (input.isBlank()) {
                System.out.println("Aviso: O arquivo '" + inputFile + "' está vazio.");
                return;
            }
            // Assegura que a classe implementa a Interface DayChallenge e processa o input
            try {
                final Class<?> clazz = Class.forName(className);
                final DayChallenge dayInstance = (DayChallenge) clazz.getDeclaredConstructor().newInstance();

                // Retorna as soluções:
                System.out.println("Solution Part1: " + dayInstance.solvePart1(inputFile));
                System.out.println("Solution Part2: " + dayInstance.solvePart2(inputFile));

            } catch (final ClassCastException e) {
                System.out.println("Erro: A classe " + className + " não implementa a interface DayChallenge.");
                return;
            }

        } catch (final IOException e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
        } catch (final ReflectiveOperationException e) {
            System.out.println("Erro ao executar a reflexão: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void runDay(final Day day) {
        final String dayN = "Day" + day.getDayNumber();
        final String className = "day" + day.getDayNumber() + "." + dayN;
        final String inputFile = "src/main/java/" + "day" + day.getDayNumber() + "/input.txt";
        final File file = new File(inputFile);
        processDay(className, file);
    }

    public static void runDay(final int day) {
        final String dayN = "Day" + day;
        final String className = "day" + day + "." + dayN;
        final String inputFile = "src/main/java/" + "day" + day + "/input.txt";
        final File file = new File(inputFile);
        processDay(className, file);
    }
}