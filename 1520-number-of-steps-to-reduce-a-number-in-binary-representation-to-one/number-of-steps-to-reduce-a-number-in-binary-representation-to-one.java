import java.math.BigInteger;

class Solution {
    public int numSteps(String s) {
        
        BigInteger bin = new BigInteger(s , 2);
        BigInteger one = BigInteger.ONE;
        BigInteger two = BigInteger.valueOf(2);

        int ans = 0;

        while(bin.compareTo(one) > 0){

            if(bin.mod(two).equals(BigInteger.ZERO)){

                bin = bin.divide(two);

            } 

            else{

                bin = bin.add(one);

            }

            ans++;
        }

        return ans;

    }
}