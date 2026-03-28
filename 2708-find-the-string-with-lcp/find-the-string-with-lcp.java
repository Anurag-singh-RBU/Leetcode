class Solution {
    public String findTheString(int[][] lcp) {

        int n = lcp.length;
        char[] res = new char[n];

        for(int i = 0 ; i < n ; i++) res[i] = 0;

        char c = 'a';

        for(int i = 0 ; i < n ; i++){

            if(res[i] != 0) continue;

            if(c > 'z') return "";

            for(int j = i ; j < n ; j++){

                if (lcp[i][j] > 0) res[j] = c;

            }

            c++;

        }

        for(int i = n - 1 ; i >= 0 ; i--){
            for(int j = n - 1 ; j >= 0 ; j--){

                int val = 0;

                if(res[i] == res[j]){

                    if(i + 1 < n && j + 1 < n) val = 1 + lcp[i + 1][j + 1];
                    else val = 1;

                }

                if(lcp[i][j] != val) return "";

            }

        }

        return new String(res);
        
    }
}