/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {

    public static int getHeight(TreeNode root){

        if(root == null) return 0;

        return 1 + Math.max(getHeight(root.left) , getHeight(root.right));

    }

    public List<List<String>> printTree(TreeNode root){

        int height = getHeight(root);

        int n = height;
        int m = (int) (Math.pow(2 , height) - 1);

        String[][] res = new String[n][m];

        for(int i = 0 ; i < n ; i++){

            for(int j = 0 ; j < m ; j++){

                res[i][j] = "";

            }

        }

        Queue<TreeNode> q = new LinkedList<>();
        Queue<Integer> cols = new LinkedList<>();

        int r = 0;
        int mid = (m - 1) / 2;

        q.offer(root);
        cols.add(mid);

        res[0][mid] = String.valueOf(root.val);

        while(!q.isEmpty()){

            int lvl = q.size();

            while(lvl-- > 0){

                TreeNode cnt = q.poll();
                int col = cols.poll();

                if(cnt.left != null){

                    int nC = col - (int) Math.pow(2 , height - r - 2);

                    if(r + 1 < n && nC >= 0){
                        
                        res[r + 1][nC] = String.valueOf(cnt.left.val);

                    }

                    q.offer(cnt.left);
                    cols.offer(nC);

                }

                if(cnt.right != null){
                    
                    int nC = col + (int) Math.pow(2 , height - r - 2);

                    if(r + 1 < n && nC < m){
                        
                        res[r + 1][nC] = String.valueOf(cnt.right.val);

                    }

                    q.offer(cnt.right);
                    cols.offer(nC);

                }

            }

            r++;

        }

        List<List<String>> ans = new ArrayList<>();

        for(int i = 0 ; i < n ; i++){

            ans.add(Arrays.asList(res[i]));

        }

        return ans;
 
    }
}