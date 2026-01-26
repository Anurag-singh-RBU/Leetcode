class Solution {

    class Pair implements Comparable<Pair>{

        int year;
        int delta;

        Pair(int year , int delta){

            this.year = year;
            this.delta = delta;

        }

        public int compareTo(Pair o){

            if(this.year != o.year) return this.year - o.year;

            return this.delta - o.delta;

        }

    }

    public int maximumPopulation(int[][] logs) {

        List<Pair> events = new ArrayList<>();

        for(int[] row : logs){

            int[] range = row;

            int by = range[0];
            int dy = range[1];

            events.add(new Pair(by , +1));
            events.add(new Pair(dy , -1));

        }

        Collections.sort(events);

        int cp = 0;
        int maxPOP = Integer.MIN_VALUE;
        int minYR = 2050;

        for(Pair e : events){

            cp = cp + e.delta;
        
            if(cp > maxPOP){

                maxPOP = cp;
                minYR = e.year;

            }

        }

        return minYR;
        
    }
}