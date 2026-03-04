class Solution {
    public int numSpecial(int[][] mat) {

        int row = mat.length;
        int col = mat[0].length;

        int ans = 0;

        for(int i = 0 ; i < row ; i++){

            boolean rFlag = true;
            boolean cFlag = true;

            for(int j = 0 ; j < col ; j++){

                if(mat[i][j] == 1){

                    for(int k = 0 ; k < col ; k++){

                        if(k != j && mat[i][k] == 1){

                            rFlag = false;
                            break;

                        }

                    }

                    for(int m = 0 ; m < row ; m++){

                        if(m != i && mat[m][j] == 1){

                            cFlag = false;
                            break;
                            
                        }

                    }

                    if(rFlag && cFlag) ans++;

                }

            }

        }

        return ans;
        
    }
}