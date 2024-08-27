import javax.swing.tree.TreeNode;

class Count_nodes {
    public int countNodes(TreeNode root) {
    //     if(root == null)return 0;
    //    Queue<TreeNode> q = new LinkedList<>();
    //    q.offer(root);
    //    int count = 1;

    //    while(!q.isEmpty()){
    //         TreeNode node = q.poll();
    //         if(node.left != null){
    //             count++;
    //             q.offer(node.left);
    //         }
    //         if(node.right != null){
    //             count++;
    //             q.offer(node.right);
    //         }
    //    }
    //    return count;

     if(root==null) return 0;
        int leftcnt = countNodes(root.left);
        int rightcnt = countNodes(root.right);
        return leftcnt + rightcnt + 1;
    }
}