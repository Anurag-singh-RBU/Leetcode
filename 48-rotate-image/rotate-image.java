class Solution {
    public void rotate(int[][] matrix) {

        int row = 0;
        int col = matrix[0].length - 1;
        int a = 0;

        for (int i = 0; i < matrix.length / 2; i++) {
            
            for (int j = i; j < matrix.length - i - 1; j++) {

                row = i;
                col = j;
                a = matrix[row][col];

                int temp = matrix[row][col];
                matrix[row][col] = matrix[matrix.length - 1 - j][i];
                matrix[matrix.length - 1 - j][i] = matrix[matrix.length - 1 - i][matrix.length - 1 - j];
                matrix[matrix.length - 1 - i][matrix.length - 1 - j] = matrix[j][matrix.length - 1 - i];
                matrix[j][matrix.length - 1 - i] = temp;

            }
        }
    }
}