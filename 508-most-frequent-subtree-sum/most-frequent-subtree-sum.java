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

    static Map<Integer , Integer> hm = new HashMap<>();
    static List<Integer> ans = new ArrayList<>();

    public static int solve(TreeNode root){

        if(root == null) return 0;

        int left = solve(root.left);
        int right = solve(root.right); 

        int sum = root.val + left + right;

        hm.put(sum , hm.getOrDefault(sum , 0) + 1);

        return sum;

    }

    public int[] findFrequentTreeSum(TreeNode root) {

        hm.clear();
        ans.clear();
        
        solve(root);

        int maxFreq = 0;

        for(Map.Entry<Integer , Integer> ite : hm.entrySet()){

            int freq = ite.getValue();

            if(freq > maxFreq){

                maxFreq = freq;

            }

        }

        for(Map.Entry<Integer , Integer> ite : hm.entrySet()){

            int sum = ite.getKey();
            int freq = ite.getValue();

            if(freq == maxFreq){

                ans.add(sum);

            }

        }

        int[] res = new int[ans.size()];

        for(int i = 0 ; i < ans.size() ; i++){

            res[i] = ans.get(i);

        }

        return res;
        
    }
}