class Solution {

    public int reverse(int x){

        int r = 0;

        while(x > 0){

            r = r * 10 + (x % 10);
            x = x / 10;

        }

        return r;

    }

    public int minMirrorPairDistance(int[] nums) {

        HashMap<Integer , Integer> mpp = new HashMap<>();

        int n = nums.length;
        int ans = (int) 1e6;

        for(int i = 0; i < n; i++){

            if(mpp.containsKey(nums[i])){

                ans = Math.min(ans , i - mpp.get(nums[i]));

            }

            mpp.put(reverse(nums[i]) , i);

        }

        return ans == (int) 1e6 ? -1 : ans;
        
    }
}