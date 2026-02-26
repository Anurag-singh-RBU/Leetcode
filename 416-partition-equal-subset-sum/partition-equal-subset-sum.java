class Solution {

    int[][] dp;

    public boolean solve(int[] nums, int idx, int target){

        if(target == 0) return true;

        if(idx >= nums.length || target < 0) return false;

        if(dp[idx][target] != -1) return dp[idx][target] == 1;

        boolean take = solve(nums , idx + 1 , target - nums[idx]);
        boolean skip = solve(nums , idx + 1 , target);

        dp[idx][target] = (take || skip) ? 1 : 0;

        return take || skip;

    }

    public boolean canPartition(int[] nums) {

        int sum = 0;

        for(int num : nums)  sum = sum + num;

        if(sum % 2 != 0) return false;

        dp = new int[nums.length][sum/2 + 1];

        for(int[] row : dp) Arrays.fill(row , -1);

        return solve(nums , 0 , sum / 2);
        
    }
}