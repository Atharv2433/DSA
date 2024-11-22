package PracticeGraphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class PracticeDfs {

    ArrayList<ArrayList<Integer>> adj;

    public PracticeDfs(int n ){
        adj = new ArrayList<>();

        for(int i = 0; i <= n; i++){
            adj.add(new ArrayList<>());
        }
    }

    public void addEdge(int src , int dest){
        adj.get(src).add(dest);
    }

    public void dfs(int node,  ArrayList<ArrayList<Integer>> adj , boolean vis[],ArrayList<Integer> ans){
        vis[node] = true;
        ans.add(node);

        for(int it : adj.get(node)){
            if(!vis[it]){
                dfs(it, adj, vis,ans);
            }
        }
    }

    public void bfs(ArrayList<ArrayList<Integer>> adj , boolean vis[]){

        Queue<Integer> q = new LinkedList<>();
        q.offer(1);
        vis[1] = true;

        while(!q.isEmpty()){
            int node = q.poll();
            System.out.println(node);
            


            for(int it :adj.get(node)){
                if(!vis[it]){
                    vis[it] = true;
                    q.offer(it);
                }
            }
        }

    }
    

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        PracticeDfs p = new PracticeDfs(n);


        for(int i = 0; i < m; i++){
            int src = sc.nextInt();
            int dest = sc.nextInt();
            p.addEdge(src - 1, dest - 1);
        }

        boolean vis[] = new boolean[n + 1];
        ArrayList<Integer>  ans = new ArrayList<>();

        for(int i = 1; i <= n; i++){
            if(!vis[i]){
                p.dfs(i , p.adj , vis,ans);
            }
        }
        
        for(int i = 0; i < ans.size(); i++){
            System.out.println(ans.get(i));
        }

        vis = new boolean[n + 1];
        for(int i = 1; i <= n; i++){
            if(!vis[i]){
                p.bfs(p.adj , vis);
            }
        }
    }
}
