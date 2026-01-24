class Solution {

    public boolean validPartition(int[] nums) {

        return solve(nums , 0 , new Boolean[nums.length]);

    }
    
    public boolean solve(int[] nums , int i , Boolean[] dp){

        if(i == nums.length) return true;
        
        if(dp[i] != null) return dp[i];

        boolean ans = false;
        
        if((i + 1) < nums.length && (nums[i] == nums[i + 1])) ans = ans | solve(nums , i + 2 , dp);
        
        if((i + 2) < nums.length && nums[i] == nums[i + 1] && nums[i + 1] == nums[i + 2]) ans = ans | solve(nums , i + 3 , dp);
        
        if((i + 2) < nums.length && ((nums[i] + 1) == nums[i + 1]) && ((nums[i] + 2) == nums[i + 2])) ans = ans | solve(nums , i + 3 , dp);

        return dp[i] = ans;

    }
}