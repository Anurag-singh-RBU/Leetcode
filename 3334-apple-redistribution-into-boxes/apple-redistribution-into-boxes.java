class Solution {
    public int minimumBoxes(int[] apple, int[] capacity) {

        Arrays.sort(capacity);

        int ans = 0;
        int idx = 0; 

        for(int i = capacity.length - 1 ; i >= 0 && idx < apple.length ; i--){

            int cap = capacity[i];

            while(idx < apple.length && cap > 0){

                if(apple[idx] <= cap){

                    cap = cap - apple[idx];
                    idx++; 

                } 
                
                else{

                    apple[idx] = apple[idx] - cap;
                    cap = 0;

                }
            }

            ans++; 
            
        }

        return ans;
        
    }
}

