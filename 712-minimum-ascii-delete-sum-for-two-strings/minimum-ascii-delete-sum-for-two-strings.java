class Solution {

    int m , n;
    int[][] t = new int[1001][1001];

    public int solve(String s1 , String s2 , int i , int j){

        if(i >= m && j >= n) return 0;

        if(t[i][j] != -1) return t[i][j];

        if(i == m){

            int sum = 0;
            for(int k = j ; k < n ; k++) sum = sum + s2.charAt(k);
            return sum;

        }

        if(j == n){

            int sum = 0;
            for(int k = i ; k < m ; k++) sum = sum + s1.charAt(k);
            return sum;

        }

        if(s1.charAt(i) == s2.charAt(j)) return t[i][j] = solve(s1 , s2 , i + 1 , j + 1);

        int takes1 = s1.charAt(i) + solve(s1 , s2 , i + 1 , j);
        int takes2 = s2.charAt(j) + solve(s1 , s2 , i , j + 1);
        
        return t[i][j] = Math.min(takes1 , takes2);

    }
 
    public int minimumDeleteSum(String s1, String s2) {

        m = s1.length();
        n = s2.length();

        for (int[] r : t) Arrays.fill(r , -1);

        return solve(s1 , s2 , 0 , 0);
        
    }
}