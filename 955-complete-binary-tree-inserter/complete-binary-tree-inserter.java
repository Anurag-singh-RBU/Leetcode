class CBTInserter {

    TreeNode node;

    public CBTInserter(TreeNode root){

        node = root;

    }

    public int insert(int val){

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(node);

        while(!q.isEmpty()){

            TreeNode curr = q.poll();

            if(curr.left == null){

                curr.left = new TreeNode(val);
                return curr.val;

            } 

            else q.offer(curr.left);

            if(curr.right == null){

                curr.right = new TreeNode(val);
                return curr.val;

            } 

            else q.offer(curr.right);

        }

        return -1;

    }
    
    public TreeNode get_root() {

        return node;
        
    }
}