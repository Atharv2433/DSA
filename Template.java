package Topological_Sort;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class Template {

    public static class Pair{
        int src , dest;
        public Pair(int src ,int dest){
            this.src = src;
            this.dest = dest;
        }
        public int getFirst(){
            return src;
        }
    }


    public void topo_Dfs(int start , boolean vis[] , Stack<Integer> st){
        vis[start] = true;
        st.push(start);

        for(Pair it : adj.get(start)){
            if(!vis[it.getFirst()]){
                topo_Dfs(it.getFirst(),vis,st);
            }
        }
    }
    

   ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
    public void addEdge(int src , int dest){
        adj.get(src).add(new Pair(src, dest));
        adj.get(dest).add(new Pair(dest, src));
    }
    
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); 
        int m = sc.nextInt();

        Template t = new Template();

        for(int i = 0; i < m; i++){
            int src = sc.nextInt();
            int dest = sc.nextInt();

            t.addEdge(src, dest);

        }

        boolean vis[] = new boolean[n];
        Stack st = new Stack<>();

        for(int i = 0; i < n; i++){
            if(!vis[i]){
                t.topo_Dfs(i,vis,st);
            }
        }

        if(st.size() == n){
            System.out.println("No Cycle");
        }else{
            System.out.println("Cycle");
        }
        
    }
}
