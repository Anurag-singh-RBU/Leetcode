class Solution {

    Map<String , Integer> mp = new HashMap<>();
    static final int INF = (int) 1e9 + 1;

    int solve(int idx , int[] arr1 , int[] arr2 , int prev){
        
        if(idx == arr1.length) return 0;

        String key = idx + "," + prev;

        if(mp.containsKey(key)) return mp.get(key);

        int opOne = INF;

        if(arr1[idx] > prev){

            opOne = solve(idx + 1 , arr1 , arr2 , arr1[idx]);

        }

        int opTwo = INF;
        int i = upperBound(arr2 , prev);

        if(i < arr2.length){

            opTwo = 1 + solve(idx + 1 , arr1 , arr2 , arr2[i]);

        }

        int ans = Math.min(opOne , opTwo);
        mp.put(key , ans);

        return ans;

    }

    int upperBound(int[] arr , int target){

        int l = 0;
        int r = arr.length;

        while(l < r){

            int mid = (l + r) / 2;

            if(arr[mid] <= target) l = mid + 1;

            else r = mid;

        }

        return l;

    }

    public int makeArrayIncreasing(int[] arr1, int[] arr2) {

        Arrays.sort(arr2);
        mp.clear();

        int ans = solve(0 , arr1 , arr2 , Integer.MIN_VALUE);

        return ans == INF ? -1 : ans;
        
    }
}