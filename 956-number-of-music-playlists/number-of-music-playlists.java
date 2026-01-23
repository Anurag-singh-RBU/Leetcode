public class Solution {

    private final int MOD = 1_000_000_007;
    int N;
    int GOAL;
    int K;
    private Long[][] t;

    public int numMusicPlaylists(int n , int goal , int k){

        t = new Long[goal + 1][n + 1];

        for(Long[] row : t){

            Arrays.fill(row , -1L);

        }

        N    = n;
        GOAL = goal;
        K    = k;
        
        return (int) (solve(0, 0));

    }

    private long solve(int count_song, int count_unique) {

        if(count_song == GOAL){

            if(count_unique == N) return 1;
            
            return 0;

        }
        
        if(t[count_song][count_unique] != -1) return t[count_song][count_unique];
        
        long ans = 0;
        
        if(count_unique < N)
            ans = ans + (N-count_unique) * solve(count_song + 1 , count_unique + 1);
        
        if(count_unique > K) ans = ans + (count_unique - K) * solve(count_song + 1 , count_unique);
        
        
        return t[count_song][count_unique] = ans % MOD;

    }
}