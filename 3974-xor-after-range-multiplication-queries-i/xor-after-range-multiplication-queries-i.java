class Solution {

    public int MOD = (int) 1e9 + 7;

    public int xorAfterQueries(int[] nums, int[][] queries) {

        int idx = 0;

        for(int[] q : queries){

            idx = q[0];

            while(idx <= q[1]){

                nums[idx] = (int) ((1L * nums[idx] * q[3]) % MOD);
                idx = idx + q[2];

            }

        }

        int ans = 0;

        for(int ele : nums){

            ans = ans ^ ele;

        }

        return ans;
        
    }
}