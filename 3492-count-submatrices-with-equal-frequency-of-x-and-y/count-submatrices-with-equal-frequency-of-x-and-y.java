class Solution {
    public int numberOfSubmatrices(char[][] grid) {

        int n = grid.length;
        int m = grid[0].length;

        int[][] px = new int[n][m];
        int[][] py = new int[n][m];

        for(int row = 0 ; row < n ; row++){

            for(int col = 0 ; col < m ; col++){

                int up = (row > 0) ? px[row - 1][col] : 0;
                int left = (col > 0) ? px[row][col - 1] : 0;
                int diag = (row > 0 && col > 0) ? px[row - 1][col - 1] : 0;

                if(grid[row][col] == 'X'){

                    px[row][col] = 1 + up + left - diag;

                }

                else{

                    px[row][col] = up + left - diag;

                }

            }

        }

        for(int row = 0 ; row < n ; row++){

            for(int col = 0 ; col < m ; col++){

                int up = (row > 0) ? py[row - 1][col] : 0;
                int left = (col > 0) ? py[row][col - 1] : 0;
                int diag = (row > 0 && col > 0) ? py[row - 1][col - 1] : 0;

                if(grid[row][col] == 'Y'){

                    py[row][col] = 1 + up + left - diag;

                }

                else{

                    py[row][col] = up + left - diag;

                }

            }
            
        }

        int ans = 0;

        for(int row = 0 ; row < n ; row++){

            for(int col = 0 ; col < m ; col++){

                int countX = px[row][col];
                int countY = py[row][col];

                if(countX == countY && countX > 0) ans++;

            }

        }

        return ans;
        
    }
}