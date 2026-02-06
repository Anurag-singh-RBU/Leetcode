class Solution {
    public int minRemoval(int[] nums, int k) {

        Arrays.sort(nums);

        int n = nums.length;
        int i = 0;
        int ans = 1;

        for(int j = 0 ; j < n ; j++){

            while((long) nums[j] > (long) k * nums[i]){

                i++;

            }

            ans = Math.max(ans , j - i + 1);

        }

        return n - ans;
        
    }
}