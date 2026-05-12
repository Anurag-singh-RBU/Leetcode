class Solution {

    class Pair{

        int x;
        int y;

        Pair(int x , int y){

            this.x = x;
            this.y = y;

        }

    }
    
    public int shortestPathBinaryMatrix(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        if(m == 0 || n == 0 || grid[0][0] != 0) return -1;

        int[][] dirs = {{-1 , -1} , {0 , -1} , {1 , -1} , {-1 , 0} , {1 , 0} , {-1 , 1} , {0 , 1} , {1 ,1}};

        Queue<Pair> q = new LinkedList<>();

        q.offer(new Pair(0 , 0));
        grid[0][0] = 1;

        int steps = 0;

        while(!q.isEmpty()){

            int size = q.size();

            while(size-- > 0){

                Pair cP = q.poll();

                int x = cP.x;
                int y = cP.y;

                if(x == m - 1 && y == n - 1){

                    return steps + 1;

                }

                for(int[] d : dirs){

                    int x_ = x + d[0];
                    int y_ = y + d[1];

                    if(x_ >= 0 && y_ >= 0 && x_ < m && y_ < n && grid[x_][y_] == 0){

                        q.offer(new Pair(x_ , y_));
                        grid[x_][y_] = 1;

                    }

                }

            }

            steps++;

        }

        return -1;
        
    }
}