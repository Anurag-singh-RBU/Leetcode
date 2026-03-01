class Solution {
    public int minPartitions(String n) {

        char[] ch = n.toCharArray();
        int[] digits = new int[ch.length];

        int idx = 0;

        for(char c : ch){

            digits[idx] = c - '0';
            idx++;

        }

        Arrays.sort(digits);

        return digits[digits.length - 1];
        
    }
}