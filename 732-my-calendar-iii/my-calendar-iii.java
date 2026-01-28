class MyCalendarThree {

    class Pair implements Comparable<Pair>{

        int time;
        int delta;

        Pair(int time , int delta){

            this.time = time;
            this.delta = delta;

        }

        public int compareTo(Pair o){

            if(this.time == o.time){

                return this.delta - o.delta;

            }

            return this.time - o.time;

        }
    }

    private List<Pair> events;

    public MyCalendarThree() {

        events = new ArrayList<>();

    }
    
    public int book(int startTime, int endTime) {

        events.add(new Pair(startTime , 1));
        events.add(new Pair(endTime , -1));

        Collections.sort(events);

        int count = 0;
        int max = 0;

        for(Pair e : events){

            int t = e.time;
            int d = e.delta;

            count = count + d;
            max = Math.max(max , count);

        }

        return max;
        
    }
}

/**
 * Your MyCalendarThree object will be instantiated and called as such:
 * MyCalendarThree obj = new MyCalendarThree();
 * int param_1 = obj.book(startTime,endTime);
 */