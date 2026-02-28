/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {

    Map<TreeNode , TreeNode> parent = new HashMap<>();
    List<Integer> ans = new ArrayList<>();
    Map<TreeNode , Boolean> vis = new HashMap<>();

    public void findParent(TreeNode root){

        if(root == null) return;

        if(root.left != null){

            parent.put(root.left , root);

        }

        findParent(root.left);

        if(root.right != null){

            parent.put(root.right , root);

        }

        findParent(root.right);

    }

    public void BFS(TreeNode target , int k){

        if(target == null) return;

        Queue<TreeNode> q = new LinkedList<>();

        q.offer(target);
        vis.put(target , true);

        while(q.size() > 0){

            int size = q.size();
            
            if(k == 0) break;

            while(size-- > 0){

                TreeNode cnt = q.poll();

                if(cnt.left != null && vis.containsKey(cnt.left) == false){

                    vis.put(cnt.left , true); 
                    q.offer(cnt.left);

                }

                if(cnt.right != null && vis.containsKey(cnt.right) == false){

                    vis.put(cnt.right , true); 
                    q.offer(cnt.right);

                }

                if(parent.containsKey(cnt) && vis.containsKey(parent.get(cnt)) == false){
                    
                    TreeNode P = parent.get(cnt);

                    vis.put(P , true); 
                    q.offer(P);

                }

            }

            k--;

        }

        while(q.size() > 0){

            ans.add(q.poll().val);

        }

    }

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {

       findParent(root);
       BFS(target , k);

       return ans; 
        
    }
}