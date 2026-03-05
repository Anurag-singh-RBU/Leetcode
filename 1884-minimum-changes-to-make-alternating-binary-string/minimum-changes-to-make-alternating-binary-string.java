class Solution {
    public int minOperations(String s) {

        int n = s.length();

        char[] a = s.toCharArray();
        int op1 = 0;

        for(int i = 1 ; i < n ; i++){

            if(a[i] == a[i - 1]){

                a[i] = (a[i] == '0') ? '1' : '0';
                op1++;

            }
        }

        char[] b = s.toCharArray();
        int op2 = 1;
        b[0] = (b[0] == '0') ? '1' : '0';

        for(int i = 1 ; i < n ; i++){

            if(b[i] == b[i - 1]){

                b[i] = (b[i] == '0') ? '1' : '0';
                op2++;
                
            }

        }

        return Math.min(op1 , op2);
        
    }
}