class Solution {
    public int[][] reverseSubmatrix(int[][] grid, int x, int y, int k) {

        int n = grid.length;
        int m = grid[0].length;

        int fp = x;
        int lp = x + k - 1;

        int[] LPA = new int[k];
        int[] FPA = new int[k];

        while(lp > fp){

            for(int i = y ; i < y + k ; i++){

                LPA[i - y] = grid[fp][i];

            }

            for(int i = y + k - 1 ; i >= y ; i--){

                FPA[i - y] = grid[lp][i];

            }

            int[] temp = LPA;
            LPA = FPA;
            FPA = temp;

            for(int i = y ; i < y + k ; i++){

                grid[fp][i] = LPA[i - y];
                grid[lp][i] = FPA[i - y];
                
            }

            lp--;
            fp++;

        }

        return grid;
        
    }
}