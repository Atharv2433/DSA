package DisJoint;

import java.util.ArrayList;
import java.util.Scanner;
public class RoadConstruction {
    
    int parent[];
    int size[];
    int components, maxSize;

    public static class Pair{
        int compo ,  size;

        public Pair(int compo , int size){
            this.compo = compo;
            this.size = size;
        }
        public int getFirst(){
            return compo;
        }
        public int getSecond(){
            return size;
        }

    }

    public RoadConstruction(int n){
        parent = new int[n+1];
        size = new int[n+1];

        for(int i = 0; i <= n; i++){
            parent[i] = i;
            size[i] = 1;
        }
       
        components = n;
        maxSize = 1;
        
    }

    public int findParent(int node){
        if(node == parent[node]){
            return node;
        }
        return parent[node] = findParent(parent[node]);
    }

    public void union(int u , int v){
        int u_p = findParent(u);
        int v_p = findParent(v);

        if(u_p == v_p){
            return;
        }
        if(size[u_p] < size[v_p]){
            parent[u_p] = v_p;
            size[v_p] += size[u_p];
            maxSize = Math.max(maxSize, size[v_p]);
        }else{
            parent[v_p] = u_p;
            size[u_p] += size[v_p];
            maxSize = Math.max(maxSize, size[u_p]);
        }
        components--;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ArrayList<Pair> ans = new ArrayList<>();

        int n = sc.nextInt();

        RoadConstruction rc = new RoadConstruction(n);

        int m = sc.nextInt();

        for(int i = 0; i < m; i++){
            int u = sc.nextInt();
            int v = sc.nextInt();

            rc.union(u, v);

            // System.out.println(rc.components + " " + rc.maxSize);
            ans.add(new Pair(rc.components, rc.maxSize));
        }

        for (Pair result : ans) {
            System.out.println(result.getFirst() + " " + result.getSecond());
        }
        
    }
}
