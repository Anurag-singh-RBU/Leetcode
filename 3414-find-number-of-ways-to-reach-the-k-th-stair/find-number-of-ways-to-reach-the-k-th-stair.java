class Solution {

    static Map<String , Integer> memo = new HashMap<>();

    public static int solve(int k , int jump , int canJump , int idx){

        if(idx > k + 1 || idx < 0) return 0;

        String key = idx + "," + jump + "," + canJump;

        if(memo.containsKey(key)) return memo.get(key);

        int ans = 0;

        if(idx == k) ans++;

        if(canJump == 1){
            
            ans = ans + solve(k , jump , 0 , idx - 1);

        }

        ans = ans + solve(k , jump + 1 , 1 , idx + (1 << jump));

        memo.put(key , ans);

        return ans;

    }

    public int waysToReachStair(int k) {

        memo.clear();
        return solve(k , 0 , 1 , 1);
        
    }
}