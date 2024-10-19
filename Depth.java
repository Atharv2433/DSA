import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Depth {
    public ArrayList<ArrayList<Integer>> adj;
    public Depth(int n){
        adj = new ArrayList<>();
        for(int i =0; i < n; i++){
            adj.add(new ArrayList<>());
        }
    }

    public  void addedge(int source , int destination){
        adj.get(source).add(destination);
        adj.get(destination).add(source);
    }

    public void dfs(int start,boolean vis[],ArrayList<Integer> ans){
        vis[start] = true;
        ans.add(start);
        for(int it : adj.get(start)){
            if(!vis[it]){
                dfs(it,vis,ans);
            }
        }
    }

    public void bfs(int n){
        Queue<Integer> q = new LinkedList<>();
        boolean vis[] = new boolean[n];
       
        q.offer(0);
        ArrayList<Integer> ans = new ArrayList<>();
        
        // vis[0] = true;

        while(!q.isEmpty()){
            int node = q.poll();
            if(vis[node]){
                continue;
            }
            vis[node] = true;
            ans.add(node);

            for(int it : adj.get(node)){
                if(!vis[it]){
                    q.offer(it);
                }
            }
        }
        System.out.println("BFS Traversal:");
        for (int node : ans) {
            System.out.print(node + " ");
        }
        System.out.println();

    }

    public  void print(){
        for(int i = 0; i < adj.size(); i++){
            for(int j = 0; j < adj.get(i).size(); j++){
                System.out.print(adj.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        
        int n  = sc.nextInt();
        Depth d = new Depth(n);
        int m = sc.nextInt();

        for(int i = 0; i < m; i++){
            int src = sc.nextInt();
            int dest = sc.nextInt();
            d.addedge(src,dest);
        }
        boolean vis[] = new boolean[n];
        ArrayList<Integer> ans = new ArrayList<>();

        d.dfs(0,vis,ans);
        
        for(int i = 0; i < ans.size();i++){
            System.out.println(ans.get(i));
        }
        System.out.println("ADJ LIST>>>>>>>>>>>>>>>>>");
        d.print();
        d.bfs(n);
    }
}
