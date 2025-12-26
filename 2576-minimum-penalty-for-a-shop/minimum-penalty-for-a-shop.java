class Solution {
    public int bestClosingTime(String customers) {

        int ans = customers.length();

        int[] prefix = new int[ans];
        int[] suffix = new int[ans];

        for(int i = 1 ; i < customers.length() ; i++){

            prefix[i] = prefix[i - 1];

            if(customers.charAt(i - 1) == 'N'){

                prefix[i]++;
                
            }

        }

        if(customers.charAt(ans - 1) == 'Y') suffix[ans - 1] = 1;

        for(int i = customers.length() - 2 ; i >= 0 ; i--){

            suffix[i] = suffix[i + 1];

            if(customers.charAt(i) == 'Y'){

                suffix[i]++;

            }

        }

        int min = Integer.MAX_VALUE;
        int bestAns = 0;

        for(int i = 0 ; i < customers.length() ; i++){

            int penalty = prefix[i] + suffix[i];

            if(penalty < min){

                min = penalty;
                bestAns = i;

            }

        }

        if(prefix[customers.length() - 1] < min){

            bestAns = customers.length();

        }

        return bestAns;
        
    }
}
