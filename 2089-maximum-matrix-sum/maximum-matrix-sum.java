class Solution {
    public long maxMatrixSum(int[][] matrix) {

        int m = matrix.length;
        int n = matrix[0].length;

        long sum = 0;
        int countNeg = 0;
        int sav = Integer.MAX_VALUE; 

         for(int i = 0 ; i < m ; i++){

              for(int j = 0 ; j < n ; j++){

                sum = sum + Math.abs(matrix[i][j]);

                if(matrix[i][j] < 0){

                    countNeg++;

                }

                sav = Math.min(sav , Math.abs(matrix[i][j]));

            }
        }

        if(countNeg % 2 == 0){

            return sum;

        }

        return sum - 2L * sav;
        
    }
}