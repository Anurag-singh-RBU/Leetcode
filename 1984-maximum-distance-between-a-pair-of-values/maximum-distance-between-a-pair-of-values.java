class Solution {
    public int maxDistance(int[] nums1, int[] nums2) {

        int maxDist = 0;
        int m = nums1.length;
        int n = nums2.length;

        for(int i = 0; i < m; i++){

            int lo = i;
            int hi = n - 1;

            while(lo <= hi){

                int mid = lo + (hi - lo) / 2;

                if(nums2[mid] >= nums1[i]){

                    maxDist = Math.max(maxDist, mid - i);
                    lo = mid + 1;

                }
                
                else{

                    hi = mid - 1;

                }
            }
        }

        return maxDist;
        
    }
}