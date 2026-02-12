class Solution {
    public int longestBalanced(String s) {

        int n = s.length();
        int maxLen = 0;

        for(int i = 0; i < n; i++){

            int[] freq = new int[26];

            for(int j = i; j < n; j++){

                freq[s.charAt(j) - 'a']++;

                int count = 0;
                int distinct = 0;
                boolean valid = true;

                for(int k = 0; k < 26; k++){

                    if(freq[k] > 0){

                        distinct++;

                        if(count == 0){

                            count = freq[k];

                        } 
                        
                        else if(freq[k] != count){

                            valid = false;
                            break;

                        }
                    }
                }

                if(valid){

                    maxLen = Math.max(maxLen , j - i + 1);

                }
            }
        }

        return maxLen;
        
    }
}