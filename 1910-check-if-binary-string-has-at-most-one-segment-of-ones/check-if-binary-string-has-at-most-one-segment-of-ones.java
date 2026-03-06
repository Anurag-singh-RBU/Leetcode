class Solution {
    public boolean checkOnesSegment(String s) {

        int idx = -1;

        for(int i = 0 ; i < s.length() ; i++){

            if(s.charAt(i) == '1'){

                idx = i;

                while(idx != s.length() && s.charAt(idx) == '1'){

                    idx++;

                }

            }

            if(idx != -1) break;
            
        }

        for(int i = idx ; i < s.length() ; i++){

            if(s.charAt(i) == '1'){

                return false;

            }
        }

        return true;
        
    }
}