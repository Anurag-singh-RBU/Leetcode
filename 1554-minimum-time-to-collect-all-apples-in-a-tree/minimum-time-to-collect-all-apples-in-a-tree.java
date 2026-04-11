class Solution {

    public int DFS(List<List<Integer>> adj , int idx , int parent , List<Boolean> hasApple){

        int time = 0;

        for(int node : adj.get(idx)){

            if(node == parent) continue;

            int timeForChild = DFS(adj , node , idx , hasApple);

            if(timeForChild > 0 || hasApple.get(node)){

                time = time + timeForChild + 2;

            }

        }

        return time;

    }

    public int minTime(int n, int[][] edges, List<Boolean> hasApple){

        List<List<Integer>> adj = new ArrayList<>();

        for(int i = 0 ; i < n ; i++){

            adj.add(new ArrayList<>());

        }

        for(int[] edge : edges){

            int u = edge[0];
            int v = edge[1];

            adj.get(u).add(v);
            adj.get(v).add(u);

        }

        return DFS(adj , 0 , -1 , hasApple);
        
    }
}