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
    public TreeNode replaceValueInTree(TreeNode root) {

        if(root == null) return null;

        Map<Integer , Integer> hm = new HashMap<>();

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        hm.put(0 , root.val);

        int lvl = 0;

        while(!q.isEmpty()){

            int size = q.size();

            int sum = 0;

            while(size-- > 0){

                TreeNode cnt = q.poll();

                if(cnt.left != null){

                    sum = sum + cnt.left.val;
                    q.offer(cnt.left);

                }

                if(cnt.right != null){

                    sum = sum + cnt.right.val;
                    q.offer(cnt.right);
                    
                }

            }

            hm.put(lvl + 1 , sum);
            lvl++;

        }

        q.clear();

        q.offer(root);
        root.val = 0;

        lvl = 0;

        while(!q.isEmpty()){

            int size = q.size();

            while(size-- > 0){

                TreeNode cnt = q.poll();

                int lvlSum = hm.getOrDefault(lvl + 1 , 0);

                int sibSum = 0;

                if(cnt.left != null) sibSum = sibSum + cnt.left.val;
                if(cnt.right != null) sibSum = sibSum + cnt.right.val;

                if(cnt.left != null){

                    cnt.left.val = lvlSum - sibSum;
                    q.offer(cnt.left);

                }

                if(cnt.right != null){

                    cnt.right.val = lvlSum - sibSum;
                    q.offer(cnt.right);

                }

            }

            lvl++;

        } 

        return root;

    }
}