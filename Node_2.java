public class Node_2{
    int data;
    Node_2 left, right;

    Node_2(int val) {
        data = val;
        left = right = null;
    }

    public static boolean is_identical(Node_2 root, Node_2 subroot){
        if(root == null && subroot == null){
            return true;
        }
        if(root == null || subroot == null || root.data != subroot.data){
            return false;
        }
        return is_identical(root.left,subroot.left) || is_identical(root.right,subroot.right);

    }
    public static boolean is_subtree(Node_2 root, Node_2 subroot){
        if(root == null){
            return false;
        }
        if(root.data == subroot.data){
            if(is_identical(root,subroot)){
                return true;
            }
        }
        return is_subtree(root.left,subroot) || is_subtree(root.right,subroot);
    }
    public static void main(String[] args) {
        Node_2 root = new Node_2(1);
        root.left = new Node_2(2);
        root.right = new Node_2(3);
        root.left.left = new Node_2(4);
        root.left.right = new Node_2(5);

        Node_2 subroot = new Node_2(2);
        subroot.left = new Node_2(4);
        subroot.right = new Node_2(5);

        System.out.println(is_subtree(root, subroot));  
    }
}
