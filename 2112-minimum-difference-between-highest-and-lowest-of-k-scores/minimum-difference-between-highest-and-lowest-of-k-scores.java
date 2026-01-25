class Solution {
    public int minimumDifference(int[] nums, int k) {
        
        Arrays.sort(nums);

        int n = nums.length;
        int ans = Integer.MAX_VALUE;

        for(int i = 0 ; i + k - 1 < n ; i++){

            int low = nums[i];
            int high = nums[i + k - 1];

            ans = Math.min(ans , high - low);

        }

        return ans;

    }
}
