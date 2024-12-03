package aoc;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class Main {

    public static void main(final String[] args) {
        runDay(0);

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
                dayInstance.processInput(inputFile);

            } catch (final ClassCastException e) {
                System.out.println("Erro: A classe " + className + " não implementa a interface DayChallenge.");
                return;
            }

        } catch (final IOException e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
        } catch (final ReflectiveOperationException e) {
            System.out.println("Erro ao executar a reflexão: " + e.getMessage());
            e.printStackTrace();  // Exibe a pilha de exceções para depuração
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

//    public static void runDay(int day) {
//
//        final String dayN = "Day" + day;
//        final String className = dayN.toLowerCase() + "." + dayN;  // Nome da classe, incluindo o pacote "DayN"
//        final String inputFile = "src/main/java/" + dayN.toLowerCase() + "/input.txt";  // Caminho correto para o arquivo de entrada
//
//        try {
//            // Verificar se a classe existe
//            final Class<?> clazz = Class.forName(className);  // Carrega a classe do dia
//            System.out.println("Running " + dayN + "\n");
//
//            // Verificar se o input existe
//            if (!Files.exists(Paths.get(inputFile))) {
//                System.out.println("Erro: O arquivo de entrada '" + inputFile + "' não foi encontrado.");
//                return;
//            }
//
//            // Se estiver vazio, avisa
//            final String input = new String(Files.readAllBytes(Paths.get(inputFile)));
//            if (input.isBlank()) {
//                System.out.println("Aviso: O arquivo '" + inputFile + "' está vazio.");
//            }
//
//            // Assegurar que a classe implementa a Interface do DayChallenge
//            try {
//                final DayChallenge dayInstance = (DayChallenge) clazz.getDeclaredConstructor().newInstance();  // Cria a instância da classe
//                // Se sim, processa input
//                dayInstance.processInput(input);
//
//            } catch (final ClassCastException e) {
//                // Se o casting falhar, mostrar uma mensagem mais clara
//                System.out.println("Erro: A classe " + className + " não implementa a interface DayChallenge.");
//                return;
//            }
//
//        } catch (final ClassNotFoundException e) {
//            System.out.println("Erro: Classe " + className + " não encontrada.");
//        } catch (final IOException e) {
//            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
//        } catch (final ReflectiveOperationException e) {
//            System.out.println("Erro ao executar a reflexão: " + e.getMessage());
//            e.printStackTrace();  // Exibe a pilha de exceções para depuração
//        }
//    }
