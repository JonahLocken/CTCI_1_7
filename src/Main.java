public class Main {
    public static void main(String[] args) {

        int[][] picture =
                       {{0, 1, 1, 0},
                        {0, 1, 1, 0},
                        {1, 0, 0, 1},
                        {0, 1, 1, 0}};

        rotateMatrix(picture);
    }

    public static void rotateMatrix(int[][] matrix){
        if(matrix == null || matrix.length == 0 || matrix.length != matrix[0].length){
            return;
        }

        int n = matrix.length;

        for (int layer = 0; layer < n / 2; layer++) {
            int first = layer;
            int last = n - 1 - layer;

            for (int i = first; i < last; i++) {
                int offset = i - first;

                // Save top element
                int top = matrix[first][i];

                // Left -> Top
                matrix[first][i] = matrix[last - offset][first];

                // Bottom -> Left
                matrix[last - offset][first] = matrix[last][last - offset];

                // Right -> Bottom
                matrix[last][last - offset] = matrix[i][last];

                // Top -> Right
                matrix[i][last] = top;
            }
        }

        return;
    }
}