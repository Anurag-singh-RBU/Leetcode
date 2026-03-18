class Solution {
    public int countSubmatrices(int[][] grid, int k) {

        int n = grid.length;
        int m = grid[0].length;

        int[][] ps = new int[n][m];

        int sum = 0;
        
        for(int row = 0 ; row < n ; row++){

            for(int col = 0 ; col < m ; col++){

                int up = (row > 0) ? ps[row - 1][col] : 0;
                int left = (col > 0) ? ps[row][col - 1] : 0;
                int diag = (row > 0 && col > 0) ? ps[row - 1][col - 1] : 0;

                ps[row][col] = grid[row][col] + up + left - diag;
                
            }

        }

        int ans = 0;

        for(int row = 0 ; row < n ; row++){

            for(int col = 0 ; col < m ; col++){

                if(ps[row][col] <= k){


                    ans++;

                }

            }

        }

        return ans;
        
    }
}