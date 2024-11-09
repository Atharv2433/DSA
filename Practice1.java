import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Practice1 {

    ArrayList<ArrayList<Integer>> adj;

    public Practice1(int n){
        adj = new ArrayList<>();
        for(int i = 0; i <= n; i++){
            adj.add(new ArrayList<>());
        }
    }

    public static class  Pair {
        int src ; int dest ;

        public Pair(int s , int d){
            this.src = s;
            this.dest = d;
        }

        public int getFirst(){
            return src;
        }
        public int getSecond(){
            return dest;
        }
    }

    

    public void addEdge(int src , int dest){
        adj.get(src).add(dest);
        adj.get(dest).add(src);
    }

    public void dfs(int node,  ArrayList<ArrayList<Integer>> adj, boolean vis[],ArrayList<Integer> ans){
        vis[node] = true;
        ans.add(node);

        for(int it : adj.get(node)){
            if(!vis[it]){
                dfs(it, adj,vis,ans);
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        Practice1 p1 = new Practice1(n);

        for(int i = 0; i < m; i++){
            int src = sc.nextInt();
            int dest = sc.nextInt();

            p1.addEdge(src, dest);
        }

        boolean vis[] = new boolean[n];
        ArrayList<Integer> ans = new ArrayList<>();

        for(int i = 0; i < n; i++){
            if(!vis[i]){
                p1.dfs(i,p1.adj,vis,ans);
            }
        }
        for(int i = 0; i < n; i++){
            System.out.print(ans.get(i) + " ");
        }
        System.out.println();


        boolean visited[] = new boolean[n];
        Queue<Integer> q = new LinkedList<>();

        q.offer(0);
        visited[0] = true;

        while(!q.isEmpty()){
            int node = q.poll();
            System.out.println(node);

            for(int it : p1.adj.get(node)){
                if(!visited[it]){
                    visited[it] = true;
                    q.offer(it);
                }
            }
        }

    }
}
