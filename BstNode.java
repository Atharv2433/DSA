import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BstNode{
    int data;
    BstNode left;
    BstNode right;


    BstNode(int data){
        this.data = data;
        left = null;
        right = null;
    }

    public static BstNode insert(int data, BstNode root){
        if(root == null){
            root = new BstNode(data);
            return root;
        }
        if(data > root.data){
            root.right = insert(data, root.right);
        }
        if(data < root.data){
            root.left = insert(data, root.left);
        }
        return root;
    }

    public static void indorder(BstNode root){
        if(root == null){
            return;
        }
        indorder(root.left);
        System.out.print(root.data + " ");
        indorder(root.right);
    }

    public static void predorder(BstNode root){
        if(root == null){
            return;
        }
        System.out.print(root.data + " ");
        indorder(root.left);
        indorder(root.right);
    }
    public static void postdorder(BstNode root){
        if(root == null){
            return;
        }
        
        indorder(root.left);
        indorder(root.right);
        System.out.print(root.data + " ");
    }
    
    public static void level_order(BstNode root){
        if(root == null){
            return;
        }
        Queue<BstNode> q = new LinkedList<>();
        q.add(root);
        q.add(null);

        while (!q.isEmpty()){
            BstNode curr = q.remove();
            if(curr == null){
                System.out.println();
                if(q.isEmpty()){
                    break;
                }else{
                   q.add(null);
                }
            }else{
                System.out.println(curr.data + " ");
                if(curr.left != null){
                    q.add(curr.left);
                }
                if(curr.right != null){
                    q.add(curr.right);
                }
            } 
        }
    }
    public static BstNode findsuccessor(BstNode root){
        while(root.right != null){
            root = root.right;
        }
        return root;
    }
    public static BstNode delete_node(BstNode root,int val){
        if(root.data < val){
            root.right = delete_node(root.right,val);
        }
        else if(root.data > val){
            root.left = delete_node(root.left,val);
        }else{
            if(root.right == null && root.left == null){
                return null;
            }else if(root.left == null){
                return root.right;
            }else if(root.right == null){
                return root.left;
            }else{
                BstNode succ = findsuccessor(root.right);
                root.data = succ.data;
                root.right = delete_node(root.right,succ.data);
            }
        }
        return root;
    }
    public static BstNode mirror(BstNode root){
        if(root == null){
            return null;
        }
        BstNode le = mirror(root.left);
        BstNode ri = mirror(root.right);

         root.right = le;
         root.left = ri;

        return root;

    }
    public static boolean validate(BstNode root,Integer min, Integer max){
        if(root == null){
            return true;
        }
        if(min != null && min >= root.data || max != null && max <= root.data){
            return false;
        }

        return validate(root.left,min,root.data) && validate(root.right,root.data,max);
    }
    public static void printlis(ArrayList<Integer> lis){
        for(int i =0; i < lis.size(); i++ ){
            System.out.println(lis.get(i) + " ");
        }
        System.out.println();
    } 
    public static void all_paths(BstNode root,ArrayList<Integer> lis){
    
        if(root == null){
            return;
        }
        lis.add(root.data);
        if(root.left == null && root.right == null){
            printlis(lis);
        } else {
            // Recursively traverse the left and right subtrees
            all_paths(root.left, lis);
            all_paths(root.right, lis);
        }
        
        lis.remove(lis.size()-1);
    }

    
    public static int min_bst(BstNode root){
        if(root == null){
            return -1;
        }
        while (root.left != null) {
            root = root.left;
        }
        return root.data;
    }

    public static int max_bst(BstNode root){
        if(root == null){
            return -1;
        }
        while (root.right != null) {
            root = root.right;
        }
        return root.data;
    }

    public static boolean search(BstNode root , int k){
        if(root == null){
            return false;
        }
        if(k == root.data){
           return true;
        } 
        
        boolean left_2 = search(root.left,k);
        boolean right_2 = search(root.right,k);

        return left_2 || right_2;
    }
    
    public static void main(String args[]){
        int arr[] = {4, 1, 2, 3, 6, 7, 8 };
        BstNode root = null;

        for(int it : arr){
            root = insert(it, root);
        }
        indorder(root);
        System.out.println();
        predorder(root);
        System.out.println();
        postdorder(root);
        System.out.println();
        level_order(root);
        int ma = max_bst(root);
        int mi = min_bst(root);
        System.out.println(ma);
        System.out.println(mi);
        int k = 7;
        boolean flag = search(root,k);
        System.out.println(flag);

        BstNode root_2 = delete_node(root,1);
        indorder(root_2);
        ArrayList<Integer> lis = new ArrayList<>();
        all_paths(root_2,lis);
        boolean flag_2 = validate(root,null,null);
        System.out.println(flag_2);

        BstNode node_3 = mirror(root);
        indorder(node_3);

    }
}