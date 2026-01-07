class Solution {

    public static int[][] dp;

    public static int solve(int i , int j , int[] nums1 , int[] nums2){

        if(i >= nums1.length || j >= nums2.length) return 0;

        if(nums1[i] == nums2[j]) return 1 + solve(i + 1 , j + 1 , nums1 , nums2);

        if(dp[i][j] != -1) return dp[i][j];

        else{

            int gwi = solve(i + 1 , j , nums1 , nums2);
            int gwj = solve(i , j + 1 , nums1 , nums2);

            return dp[i][j] = Math.max(gwi , gwj);

        }

    }

    public int maxUncrossedLines(int[] nums1, int[] nums2) {

        dp = new int[501][501];

        for(int i = 0 ; i < 501 ; i++){

            Arrays.fill(dp[i] , -1);

        }

        return solve(0 , 0 , nums1 , nums2);
        
    }
}