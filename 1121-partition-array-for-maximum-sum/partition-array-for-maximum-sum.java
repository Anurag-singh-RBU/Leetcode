class Solution {

    static int[] dp;

    public static int solve(int idx , int[] arr , int k){

        if(idx >= arr.length) return 0;

        if(dp[idx] != -1) return dp[idx];

        int ans = -1;
        int cme = -1;

        for(int j = idx ; j < arr.length ; j++){

            if(j - idx + 1 <= k){

                cme = Math.max(cme , arr[j]);
                int sum = (j - idx + 1) * cme + solve(j + 1 , arr , k);

                ans = Math.max(ans , sum);

            }

        }   

        return dp[idx] = ans;

    }

    public int maxSumAfterPartitioning(int[] arr, int k) {

        dp = new int[501];

        Arrays.fill(dp , -1);

        return solve(0 , arr , k);
        
    }
}