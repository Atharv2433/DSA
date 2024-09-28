import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class Node_3{
    int data;
    Node_3 left, right;

    Node_2(int val) {
        data = val;
        left = right = null;
    }
    public static class Info{
        Node_3 node;
        int hd;

        Info(int hd,Node_3 data){
            hd = hd;
            node = data;
        }
    }
    public static void top_view(Node_3 root){
        if(root == null){
            return;
        }
        Queue<Info> q = new LinkedList<>();
        HashMap<Integer,Node_3> mpp = new HashMap<>();

        q.add(new Indo(0,root));
        q.add(null);

        while(!q.isEmpty()){
            Info curr = q.remove();
            if(curr == null){
                System.out.println();
                if(q.isEmpty()){
                    break;
                }else{
                    q.add(null);
                }
            }
            if(!mpp.containskey(curr.hd)){
                mpp.put(curr.hd,curr.data);
            }
            if(curr.left != null){
                q.add(curr.hd-1,curr.left);
            }
            if(curr.right != null){
                q.add(curr.hd+1,curr.right);
            }
        }
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
