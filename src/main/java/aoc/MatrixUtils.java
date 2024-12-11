package aoc;

public class MatrixUtils {

    /**
     * Verifica se as coordenadas (i, j) estão dentro dos limites da matriz.
     */
    public static <T> boolean isWithinBounds(T[][] matrix, int i, int j) {
        return ((i >= 0) && (i < matrix.length)) && ((j >= 0) && (j < matrix[0].length));
    }

    /**
     * Retorna o número de linhas e colunas de uma matriz.
     */
    public static <T> int[] getMatrixSize(T[][] matrix) {
        if ((matrix == null) || (matrix.length == 0)) {
            return new int[] { 0, 0 };
        }
        int rows = matrix.length;
        int cols = matrix[0].length;
        return new int[] { rows, cols };
    }

    /**
     * Retorna todas as direções ao redor de (i, j), incluindo as 4 diagonais.
     */
    public static int[][] getAllSurroundingDirections() {
        // Direções: cima, baixo, esquerda, direita, e as 4 diagonais
        return new int[][] { { -1, -1 }, { -1, 0 }, { -1, 1 }, { 0, -1 }, { 0, 1 }, { 1, -1 }, { 1, 0 }, { 1, 1 } };
    }

    /**
     * Retorna as direções em cruz ao redor de (i, j) (cima, baixo, esquerda, direita).
     */
    public static int[][] getCrossDirections() {
        return new int[][] { { -1, 0 }, // Cima
                { 1, 0 },  // Baixo
                { 0, -1 }, // Esquerda
                { 0, 1 }   // Direita
        };
    }

}
