class Solution {

    int n;
    int[][] dp;

    int solve(int idx , List<List<Integer>> piles , int k){

        if(idx >= n || k == 0) return 0;

        if(dp[idx][k] != -1) return dp[idx][k];

        int notTaken = solve(idx + 1 , piles , k);

        int taken = 0;
        int sum = 0;

        for(int j = 0 ; j < Math.min(piles.get(idx).size() , k); j++){

            sum = sum + piles.get(idx).get(j);
            taken = Math.max(taken , sum + solve(idx + 1, piles, k - (j + 1)));

        }

        return dp[idx][k] = Math.max(taken , notTaken);

    }

    public int maxValueOfCoins(List<List<Integer>> piles , int k){

        n = piles.size();
        dp = new int[n][k + 1];

        for(int i = 0 ; i < n ; i++){

            Arrays.fill(dp[i] , -1);

        }

        return solve(0 , piles , k);
    }
}