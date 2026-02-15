import java.math.BigInteger;

class Solution {

    public String addBinary(String a, String b) {

        BigInteger decFirst = new BigInteger(a , 2);
        BigInteger decSecond = new BigInteger(b , 2);

        BigInteger ans = decFirst.add(decSecond);

        return ans.toString(2);

    }
}