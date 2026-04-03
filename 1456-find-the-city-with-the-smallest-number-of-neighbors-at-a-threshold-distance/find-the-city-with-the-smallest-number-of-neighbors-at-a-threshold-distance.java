class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {

        int[][] FWA = new int[n][n];

        for(int[] row : FWA){

            Arrays.fill(row , Integer.MAX_VALUE);

        }

        for(int[] edge : edges){

            int u  = edge[0];
            int v  = edge[1];
            int wt = edge[2];

            FWA[u][v] = wt;
            FWA[v][u] = wt;

        }

        for(int k = 0 ; k < n ; k++){

            for(int i = 0 ; i < n ; i++){

                if(i == k) continue;

                for(int j = 0 ; j < n ; j++){

                    if(j == k) continue;

                    if(FWA[i][k] != Integer.MAX_VALUE && FWA[k][j] != Integer.MAX_VALUE){

                        FWA[i][j] = Math.min(FWA[i][j] , FWA[i][k] + FWA[k][j]);

                    }

                }
            }
        }

        int minCity = -1;
        int minCount = Integer.MAX_VALUE;

        for(int i = 0 ; i < n ; i++){

            int count = 0;

            for(int j = 0 ; j < n ; j++){

                if(i == j) continue;

                if(FWA[i][j] <= distanceThreshold){

                    count++;

                }

            }

            if(count <= minCount){

                minCount = count;
                minCity  = i;

            }

        }

        return minCity;
        
    }
}