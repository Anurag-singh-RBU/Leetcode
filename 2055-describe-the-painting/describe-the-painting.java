class Solution {
    public List<List<Long>> splitPainting(int[][] segments) {

        Map<Integer , Long> events = new TreeMap<>();

        for(int[] row : segments){

            events.put(row[0] , events.getOrDefault(row[0] , 0L) + row[2]);
            events.put(row[1] , events.getOrDefault(row[1] , 0L) - row[2]);

        }  

        List<List<Long>> ans = new ArrayList<>();

        long sum = 0;
        int start = -1; 

        for(Map.Entry<Integer , Long> ite : events.entrySet()){

            int end = ite.getKey();

            if(start != -1 && sum > 0){

                ans.add(Arrays.asList((long) start , (long) end , sum));

            }

            sum = sum + ite.getValue();
            start = end;

        }

        return ans;

    }
}