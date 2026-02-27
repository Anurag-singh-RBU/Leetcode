class Solution {

    Map<String , Integer> hm = new HashMap<>();
    List<TreeNode> ans = new ArrayList<>();

    public String storePaths(TreeNode root){

        if(root == null) return "N";

        String left = storePaths(root.left);
        String right = storePaths(root.right);

        String path = root.val + "," + left + "," + right;

        hm.put(path , hm.getOrDefault(path , 0) + 1);

        if(hm.get(path) == 2){

            ans.add(root);

        }

        return path;
    }

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {

       storePaths(root);

       return ans;
        
    }
}