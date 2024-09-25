import java.util.LinkedList;
import java.util.Queue;

public class Node{
    int data;
    Node left;
    Node right;

    Node(int val){
        data = val;
        left = null;
        right = null;
    }
    static int indx = -1;
    public static Node build_tree(int arr[]){
        indx++;
        if(arr.length <= indx || arr[indx] == -1){
            return null;
        }
        Node root = new Node(arr[indx]);
        root.left = build_tree(arr);
        root.right = build_tree(arr);

        return root;
    }
    public static void preorder(Node root){
        if(root == null){
            return;
        }
        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }
    public static void inorder(Node root){
        if(root == null){
            return;
        }
        
        preorder(root.left);
        System.out.print(root.data + " ");
        preorder(root.right);
    }
    public static void postorder(Node root){
        if(root == null){
            return;
        }
       
        preorder(root.left);
        preorder(root.right);
        System.out.print(root.data + " ");
    }
    public static void levelorder(Node root){
        if(root == null){
            return;
        }
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);

        while (!q.isEmpty()) {
            Node newroot = q.remove();
            if(newroot == null){
                System.out.println();
                if(q.isEmpty()){
                    break;
                }else{
                    q.add(null);
                }
            }
            else{
                System.out.print(newroot.data + " ");
                if(newroot.left != null){
                    q.add(newroot.left);
                }
                if(newroot.right != null){
                    q.add(newroot.right);
                }
            }
        }
    }

    public static int find_max(BstNode root){
        if(root == null){
            return -1;
        }

        int left_1 = find_max(root.left);
        int right_1 = find_max(root.right);

    
        return Math.max(root.data,Math.max(left_1, right_1));
    }
    
    public static int height(Node root){
        if(root == null){
            return 0;
        }
        int left = height(root.left);
        int right = height(root.right);

        return Math.max(left, right) + 1;
    }
    public static int count_total_nodes(Node root){
        if(root == null){
            return 0;
        }
        int left = height(root.left);
        int right = height(root.right);

        return 1 + (left + right); 
    }
    public static void klevel(Node root,int level,int k){
        if(root == null){
            return;
        }
        if(level == k){
            System.out.print(root.data + " ");
        }
        klevel(root.left,level+1,k);
        klevel(root.right,level+1,k);
        
    }
    public static int diameter(Node root){
        if(root == null){
            return 0;
        }
        int leftdia = diameter(root.left);
        int leftheight = height(root.left);
        int rightdia = diameter(root.right);
        int rightheight = height(root.right);

        int selfdiamete = leftheight + rightheight + 1;

        return Math.max(selfdiamete , Math.max(leftdia,rightdia));

    }
    // public static boolean getpath(Node root , ArrayList<Integer> arr, int n1){

    //     if(root == null){
    //         return null;
    //     }
    //     arr.add(root.data);
    //     if(root.data == n1){
    //         return true;
    //     }
    //     boolean foundLeft = getpath(root.left,arr,n1);
    //     boolean foundright = getpath(root.right,arr,n1);

    //     if (!foundLeft && !foundRight) {
    //         arr.remove(arr.size() - 1);
    //     }
        
    //     return foundLeft || foundright;
    // }

    // public static int lca(Node root,int n1,int n2){
    //     ArrayList<Integer> path1 = new ArrayList<>();
    //     ArrayList<Integer> path2 = new ArrayList<>();

    //     getpath(root,path1,n1);
    //     getpath(root,path2,n2);

    //     int i = 0;
    //     while(i < path1.size() && i < path2.size()){
    //         if(!path1.get(i).equals(path2.get(i))){
    //             break;
    //         }  
    //         i++;          
    //     }
    //     return path1.get(i-1);
        
    // }
    public static int transform(Node root) {
        if (root == null) {
            return 0;  // Base case: return 0 instead of -1.
        }
    
        
        int left_sum = transform(root.left);
        int right_sum = transform(root.right);
    
       
        int original_data = root.data;
    
        
        root.data = left_sum + right_sum;
    
       
        return root.data + original_data;
    }
    public static Node lca(Node root,int n1,int n2){
        if(root == n1 || root == n2 || root == null){
            return root;
        }
        Node left_side = lca(root.left, n1, n2);
        Node right_side = lca(root.right, n1, n2);

        if(left_side == null){
            return  right_side;
        }
        if(right_side == null){
            return  right_side;
        }

        return root;

    }
    public static int mini(Node root , int n1){
        if(root == n1){
            return 0;
        }
        if(root == null){
            return -1;
        }
        int left = mini(root.left, n1);
        int right = mini(root.right, n1);

        if(left == -1 && right == -1){
            return -1;
        }
        else if(left == -1){
            return right + 1;
        }else{
            return left + 1;
        }

    }
    public static int mindis(Node root,int n1,int n2){
        int l = lca(root, n1, n2);
        int left_side = mini(l,n1);
        int right_side = mini(l,n2);

        return left_side + right_side;
    }
    public static void main(String args[]){
        int arr[] = {1,2,3};
        Node root = build_tree(arr);
        System.out.println("PREORDER -----");
        preorder(root);
        System.out.println();
        System.out.println("INORDER -----");
        inorder(root);
        System.out.println();
        System.out.println("POSTORDER -----");
        postorder(root);
        System.out.println();
        System.out.println("LEVEL_ORDER -----");
        levelorder(root);
        int length = height(root);
        System.out.println("Height = " + length);
        int count = count_total_nodes(root);
        System.out.println("Count Nodes = " + count);
        int dia = diameter(root);
        System.out.println("Diameter = " + dia);
        klevel(root,0,1);

        int data = transform(root);
        preorder(root);


    }
}