class Solution {
    public boolean isTrionic(int[] nums) {

        int n = nums.length;
        if(n < 3) return false;

        int p = 1;

        while(p < n && nums[p] > nums[p - 1]){

            p++;

        }

        if(p == 1 || p == n) return false;

        int q = p;

        while(q < n && nums[q] < nums[q - 1]){

            q++;

        }

        if(q == p || q == n) return false;

        while(q < n){

            if(nums[q] <= nums[q - 1]){

                return false;

            }

            q++;

        }

        return true;
        
    }
}
