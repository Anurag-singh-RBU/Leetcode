class Solution {

    public int dirs[][] = {{1 , 1} , {1 , -1} , {-1 , -1} , {-1 , 1}};

    public int solve(int r , int c , int d , boolean canTurn , int seq , int[][] grid){

        int nr = r + dirs[d][0];
        int nc = c + dirs[d][1];

        if(nr < 0 || nr >= grid.length || nc >= grid[0].length || nc < 0 || grid[nr][nc] != seq){

            return 0;

        }

        int res = 0;

        int cont = 1 + solve(nr , nc , d , canTurn , seq == 2 ? 0 : 2 , grid);
        res = Math.max(res , cont);

        if(canTurn){

            int turn = Math.max(cont , 1 + solve(nr , nc , (d + 1) % 4 , false , seq == 2 ? 0 : 2 , grid));
            res = Math.max(res , turn);

        }

        return res;

    }
   
    public int lenOfVDiagonal(int[][] grid) {

        int row = grid.length;
        int col = grid[0].length;

        int ans = 0;

        for(int i = 0 ; i < row ; i++){

            for(int j = 0 ; j < col ; j++){

                if(grid[i][j] == 1){

                    for(int d = 0 ; d <= 3 ; d++){

                        ans = Math.max(ans , 1 + solve(i , j , d , true , 2 , grid));

                    }
                }
            }
        }

        return ans;
        
    }
}