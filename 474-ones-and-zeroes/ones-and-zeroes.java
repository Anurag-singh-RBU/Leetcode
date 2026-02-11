class Solution {

    public int[][][] dp;

    public int solve(int[][] count , int m , int n , int idx){

        if(idx >= count.length || (m == 0 && n == 0)) return 0;

        if(dp[m][n][idx] != -1) return dp[m][n][idx];

        int take = 0;

        if(count[idx][0] <= m && count[idx][1] <= n){

            take = 1 + solve(count , m - count[idx][0] , n - count[idx][1] , idx + 1);

        }

        int skip = solve(count , m , n , idx + 1);

        return dp[m][n][idx] = Math.max(take , skip);

    }

    public int findMaxForm(String[] strs, int m, int n){

        int L = strs.length;
        int[][] count = new int[L][2]; 

        for(int i = 0 ; i < L ; i++){

            int zeros = 0;
            int ones = 0;

            for(char ch : strs[i].toCharArray()){

                if(ch == '0') zeros++;
                else ones++;

            }

            count[i][0] = zeros;
            count[i][1] = ones;

        }

        dp = new int[m + 1][n + 1][L];

        for(int i = 0; i <= m; i++){

            for(int j = 0; j <= n; j++){

                Arrays.fill(dp[i][j] , -1);

            }

        }

        return solve(count , m , n , 0);
        
    }
}