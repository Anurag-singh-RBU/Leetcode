class Solution {
    public boolean judgeCircle(String moves) {

        int x = 0;
        int y = 0;
        
        for(int i = 0 ; i < moves.length() ; i++){

            if(moves.charAt(i) == 'U') y++;

            else if(moves.charAt(i) == 'D') y--;

            else if(moves.charAt(i)== 'L') x--;

            else x++; 

        }
        
        double distance = Math.sqrt(x*x + y*y);
        System.out.print(distance);

        if(distance == 0.0) return true;

        else return false;
        
    }
        
}