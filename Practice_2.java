package DisJoint;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Practice_2{

    public static class Pair{

        int dest;
        int distance;

        public Pair(int dest , int distance){
            this.dest = dest;
            this.distance = distance;
        }

        public int getFirst(){
            return dest;
        }
        public int distance(){
            return distance;
        }

    }
    HashMap<Integer ,List<Pair>> adj = new HashMap<>();

    public void addEdge(int src , int dest ,int distance){
        adj.putIfAbsent(src , new LinkedList<>());
        adj.putIfAbsent(dest , new LinkedList<>());
        adj.get(src).add(new Pair(dest , distance));
        adj.get(dest).add(new Pair(src , distance));

    }

    public void dfs(int start , boolean vis[] ,  ArrayList<Integer> ans){
        vis[start] = true;
        ans.add(start);

        for(Pair it : adj.get(start)){
            int node = it.getFirst();
            if(!vis[node]){
                dfs(node , vis , ans);
            }
        }
    }

    public boolean detect_cylce(int node , boolean vis[], int parent){
        vis[node] = true;

        for(Pair it : adj.get(node)){
            int curr = it.getFirst();
            if(!vis[it.getFirst()]){
                detect_cylce(curr, vis, node);
            }
            else{
                if(curr != parent){
                    return true;
                }
            }
        }
        return false;

    }


    public static void main(String args[]){

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        Practice_2 p = new Practice_2();

        boolean vis[] = new boolean[n];
        ArrayList<Integer> ans = new ArrayList<>();

        for(int i = 0; i < m; i++){
            int src = sc.nextInt();
            int dest = sc.nextInt();
            int distance = sc.nextInt();

            p.addEdge(src,dest,distance);
        }

        p.dfs(0,vis,ans);

        for(int i = 0; i < ans.size(); i++){
            System.out.print(ans.get(i));
        }
        System.out.println();

        Queue<Integer> q = new LinkedList<>();
        q.offer(0);
        boolean visited[] = new boolean[n];
        ArrayList<Integer> ans2 = new ArrayList<>();

        while(!q.isEmpty()){
            int node = q.poll();

            if(visited[node]){
                continue;
            }

            visited[node] = true;
            ans2.add(node);

            for(Pair it : p.adj.get(node)){
                int currnode = it.getFirst();
                q.offer(currnode);
            }
            
        }

        for(int i = 0; i < ans2.size(); i++){
            System.out.print(ans2.get(i));
        }
        System.out.println();

        boolean flag = p.detect_cylce(0, visited, -1);

        System.out.println(flag);
        
    }
}