class Solution {

    public static int MOD = (int) 1e9 + 7;
    public static int dp[][][];
 
    public static int solve(int idx, int n, int minProfit, int[] group, int[] profit, int people, int crtP){

        if(people > n) return 0;

        if(idx == profit.length){
            
            if(crtP >= minProfit) return 1;

            else return 0;

        }

        if(dp[idx][people][crtP] != -1) return dp[idx][people][crtP];

        int skip = solve(idx + 1 , n , minProfit , group , profit , people , crtP) % MOD;

        int take = solve(idx + 1 , n , minProfit , group , profit , people + group[idx] , Math.min(profit[idx] + crtP , minProfit)) % MOD;

        return dp[idx][people][crtP] = (take + skip) % MOD;

    }

    public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {

        int m = group.length;
        dp = new int[m][n + 1][minProfit + 1];

        for(int i = 0 ; i < m ; i++){

            for(int j = 0 ; j <= n ; j++){

                for(int k = 0 ; k <= minProfit ; k++){

                    dp[i][j][k] = -1;

                }

            }

        }

        return solve(0 , n , minProfit , group , profit , 0 , 0);

    }
}