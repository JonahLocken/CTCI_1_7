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
            int last = n - 1 - layer;

            for (int i = layer; i < last; i++) {
                int offset = i - layer;

                // Save top element
                int top = matrix[layer][i];

                // Left -> Top
                matrix[layer][i] = matrix[last - offset][layer];

                // Bottom -> Left
                matrix[last - offset][layer] = matrix[last][last - offset];

                // Right -> Bottom
                matrix[last][last - offset] = matrix[i][last];

                // Top -> Right
                matrix[i][last] = top;
            }
        }
    }
}