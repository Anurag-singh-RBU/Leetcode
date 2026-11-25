class Solution {
    public int pivotIndex(int[] nums) {

        int n = nums.length;
        int ts = 0;

        if(n == 1) return 0;

        for(int x : nums){

            ts = ts + x;

        }

        int cs = 0;
        int ls = 0;
        int rs = 0;

        for(int pI = 0 ; pI < n ; pI++){

            cs = cs + nums[pI];

            ls = cs - nums[pI];

            rs = ts - cs;

            if(ls == rs) return pI;

        }

        return -1;
        
    }

}