class Solution {

    static Map<String , Integer> memo = new HashMap<>();
    
    public static int gcd(int a , int b){

        if (b == 0) return a;

        return gcd(b , a % b);

    }

    public static int solve(int[] nums , boolean[] flag , int op){

        int max = 0;

        String key = Arrays.toString(flag) + "|" + op;

        if(memo.containsKey(key)) return memo.get(key); 

        for(int i = 0 ; i < nums.length - 1 ; i++){

            if(flag[i]) continue;

            for(int j = i + 1 ; j < nums.length ; j++){

                if(flag[j]) continue;

                flag[i] = true;
                flag[j] = true;

                int score = op * gcd(nums[i] , nums[j]);
                int ans = score + solve(nums , flag , op + 1);

                max = Math.max(max , ans);

                flag[i] = false;
                flag[j] = false;

            }
        }

        memo.put(key , max);
        return max;

    }

    public int maxScore(int[] nums) {

        memo.clear();

        return solve(nums , new boolean[nums.length] , 1);
        
    }
}