class Solution {
    public void solve(char[][] board) {

        int m = board.length;
        int n = board[0].length;

        boolean[][] vis = new boolean[m][n];
        int[][] dirs = {{1,0} , {-1,0} , {0,1} , {0,-1}};
        
        for(int i = 0 ; i < m ; i++){

            for(int j = 0 ; j < n ; j++){

                if(board[i][j] == 'O' && vis[i][j] == false){

                    Queue<int[]> temp = new LinkedList<>();
                    List<int[]> cells = new ArrayList<>();

                    temp.add(new int[]{i , j});
                    vis[i][j] = true;
                    boolean flag = false;
                    
                    while(!temp.isEmpty()){

                        int[] rem = temp.poll();
                        cells.add(rem);

                        int x = rem[0];
                        int y = rem[1];

                        if(x == 0 || y == 0 || x == m-1 || y == n - 1) flag = true;

                        for(int[] d : dirs){

                            int nx = x + d[0];
                            int ny = y + d[1];

                            if(nx >= 0 && nx < m && ny >= 0 && ny < n && board[nx][ny] == 'O' && vis[nx][ny] == false){

                                vis[nx][ny] = true;
                                temp.add(new int[]{nx , ny});

                            }

                        }
                    }

                    if(flag == false){

                        for(int[] ele : cells) board[ele[0]][ele[1]] = 'X';

                    }
                }
            }
        }
    }
}