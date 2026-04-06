class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        
        Set<String> obs = new HashSet<>();

        for(int i = 0 ; i < obstacles.length ; i++){

            int[] row = obstacles[i];
            
            String coordinate = row[0] + "_" + row[1];
            obs.add(coordinate);

        }

        int x = 0;
        int y = 0;
        int MED = 0;

        int[] dir = {0 , 1};

        for(int i = 0 ; i < commands.length ; i++){

            int command = commands[i];

            if(command == -1){

                dir = new int[]{dir[1] , -dir[0]};

            }

            else if(command == -2){

                dir = new int[]{-dir[1] , dir[0]};

            }

            else{

                for(int step = 0 ; step < command ; step++){

                    int nX = x + dir[0];
                    int nY = y + dir[1];

                    String nextKey = nX + "_" + nY;

                    if(obs.contains(nextKey)){

                        break;

                    }

                    x = nX;
                    y = nY;

                }

            }

            MED = Math.max(MED , x * x + y * y);

        }

        return MED;

    }
}