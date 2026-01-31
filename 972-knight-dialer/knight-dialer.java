class Solution {

    static final int MOD = (int) 1e9 + 7;

    static int[][] dirs = {{1, 2} , {1, -2} , {-1, 2} , {-1, -2} , {2, 1} , {2, -1} , {-2, 1} , {-2, -1}};

    static int[][][] dp;

    public static int solve(int row , int col , int[][] pad , int n , int len){

        if(row < 0 || row >= pad.length || col < 0 || col >= pad[0].length) return 0;

        if(len == n) return 1;

        if(dp[row][col][len] != -1) return dp[row][col][len];

        int non = 0;

        for(int[] d : dirs){

            int nR = row + d[0];
            int nC = col + d[1];

            if(nR >= 0 && nR < pad.length && nC >= 0 && nC < pad[0].length && pad[nR][nC] != -1){

                non = (non + solve(nR , nC , pad , n , len + 1)) % MOD;

            }

        }

        return dp[row][col][len] = non;

    }

    public int knightDialer(int n) {

        int[][] pad = {{1 , 2 , 3} , {4 , 5 , 6} , {7 , 8 , 9} , {-1 , 0 , -1}};

        int ans = 0;

        dp = new int[4][3][n + 1];

        for(int i = 0 ; i < 4 ; i++){

            for(int j = 0 ; j < 3 ; j++){

                for(int k = 0 ; k <= n ; k++){

                    dp[i][j][k] = -1;

                }

            }

        }

        for(int i = 0 ; i < 4 ; i++){

            for(int j = 0 ; j < 3 ; j++){

                if(pad[i][j] == -1) continue;

                else{

                    ans = (ans + solve(i , j , pad , n , 1)) % MOD;

                }
            }
        }

        return ans % MOD;
        
    }
}