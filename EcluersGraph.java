package Ecluers;

import java.util.ArrayList;
import java.util.Scanner;


public class EcluersGraph {

    ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

    public EcluersGraph(int n){
        for(int i = 0; i <= n; i++){
            adj.add(new ArrayList<>());
        }
    }

    public void addEdge(int src , int dest){
        adj.get(src).add(dest);
        adj.get(dest).add(src);
    }

    
    public void dfs(int node , ArrayList<ArrayList<Integer>> adj  , boolean vis[]){
        vis[node] = true;
        
        for(int it : adj.get(node)){
            if(!vis[it]){
                dfs(it, adj, vis);
            }
        }
    }

    public boolean isConnected(int n){
        boolean vis[] = new boolean[n + 1];
        int start = -1;

        for(int i = 0; i < n; i++){
            if(!adj.get(i).isEmpty()){
                start = i;
                break;
            }
        }
        if(start == -1){
            return true;
        }

        dfs(start, adj, vis);


        for(int i = 0; i <= n; i++){
            if(!vis[i] && !adj.get(i).isEmpty()){
                return false;
            }
        }

        return true;
    }


    public String isEculer(int n){
        if(!isConnected(n)){
            return "Not";
        }

        int odd = 0;

        for(int i = 1; i <= n; i++){
            if(adj.get(i).size() % 2 != 0){
                odd++;
            }
        }

        if(odd == 0){
            return "Yes";
        }else if(odd == 2){
            return "Semi - Yes";
        }else{
            return "Not";
        }
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        EcluersGraph eg = new EcluersGraph(n);

        for(int i = 0; i < m; i++){
            int src = sc.nextInt();
            int dest = sc.nextInt();

            eg.addEdge(src , dest);
        }

        System.out.println(eg.isEculer(n));

        sc.close();
        
    }
}
