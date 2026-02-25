class Solution {

    public int n;
    public int[][][] dp;

    public int solve(int[] nums , int k , int i , int op1 , int op2){
        
        if(i == n){

            return 0;

        }

        if(dp[i][op1][op2] != -1){

            return dp[i][op1][op2];

        }

        int ans = Integer.MAX_VALUE; 

        if(op1 > 0){

            int newVal = (nums[i] + 1) / 2; 
            int applyOp1 = newVal + solve(nums , k , i + 1 , op1 - 1 , op2);
            ans = Math.min(ans , applyOp1);

        }

        if(op2 > 0 && nums[i] >= k){

            int newVal = nums[i] - k;
            int applyOp2 = newVal + solve(nums , k , i + 1 , op1 , op2 - 1);
            ans = Math.min(ans , applyOp2);

        }

        if(op1 > 0 && op2 > 0){

            int newVal = (nums[i] + 1) / 2; 

            if(newVal >= k){

                newVal = newVal - k; 
                int applyOp1Op2 = newVal + solve(nums , k , i + 1 , op1 - 1 , op2 - 1);
                ans = Math.min(ans , applyOp1Op2);

            }

            if(nums[i] >= k){ 

                newVal = nums[i] - k;
                newVal = (newVal + 1) / 2; 
                int applyOp2Op1 = newVal + solve(nums , k , i + 1 , op1 - 1 , op2 - 1);
                ans = Math.min(ans , applyOp2Op1);

            }
        }

        ans = Math.min(ans , nums[i] + solve(nums , k , i + 1 , op1 , op2));

        return dp[i][op1][op2] = ans;

    }

    public int minArraySum(int[] nums, int k, int op1, int op2) {

        n = nums.length;
        dp = new int[n][op1 + 1][op2 + 1];

        for(int[][] mat : dp){

            for(int[] row : mat){

                Arrays.fill(row , -1);

            }
        }

        return solve(nums , k , 0 , op1 , op2);

    }
}