class Solution {

    public static void reverse(int[] mat , int sI , int eI){

        while(sI < eI){

            int temp = mat[sI];
            mat[sI] = mat[eI];
            mat[eI] = temp;

            sI++;
            eI--;

        }

    }

    public static void rotateLeft(int[] mat , int k){

        reverse(mat , 0 , k - 1);
        reverse(mat , k , mat.length - 1);
        reverse(mat , 0 , mat.length - 1);

    }

    public static void rotateRight(int[] mat , int k){

        reverse(mat , 0 , mat.length - 1);
        reverse(mat , 0 , k - 1);
        reverse(mat , k , mat.length - 1);

    }

    public boolean areSimilar(int[][] mat , int k) {

        int m = mat.length;
        int n = mat[0].length;

        k = k % n;

        if(k == 0) return true;

        int[][] org = new int[m][n];

        for(int i = 0 ; i < m ; i++){

            org[i] = mat[i].clone();

        }

        for(int i = 0 ; i < m ; i++){

            if(i % 2 == 0){

                rotateLeft(mat[i] , k);

            }

            else{

                rotateRight(mat[i] , k);

            }

        }

        for(int i = 0 ; i < m ; i++){

            for(int j = 0 ; j < n ; j++){

                if(org[i][j] != mat[i][j]) return false;

            }

        }

        return true;
        
    }
}



