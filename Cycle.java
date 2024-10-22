import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Cycle{

    public static class Pair{
        int dest ;
        int distance ;

        public Pair(int dest , int distance){
            this.dest = dest;
            this.distance = distance;
        }

        public int getFirst(){
            return dest;
        }

        public int getSecond(){
            return distance;
        }
    }


    HashMap<Integer , List<Pair>> adj = new HashMap<>();


    public void addedge(int src ,int dest , int distance){
        adj.putIfAbsent(src , new LinkedList<>());
        adj.putIfAbsent(dest , new LinkedList<>());
        adj.get(src).add(new Pair(dest , distance));
        adj.get(dest).add(new Pair(src , distance));
    }


    public boolean dfs(int node , boolean vis[],int parent){
        vis[node] = true;

        for(Pair it : adj.get(node)){
            int curr = it.getFirst();

            if(!vis[curr]){
                if(dfs(curr, vis, node)){
                    return true;
                }
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

        Cycle c = new Cycle();

        for(int i = 0; i  < m; i++){
            int src = sc.nextInt();
            int dest = sc.nextInt();
            int dist = sc.nextInt();

            c.addedge(src-1, dest-1, dist);

        }

        boolean vis[] = new boolean[n];
        boolean  flag = false;
        int parent = -1;
    


        for(int i = 1; i <= n; i++){
            if(!vis[i]){
                if(c.dfs(i,vis,parent)){
                    flag =  true;
                    break;
                }
            }
        }

        if(flag){
            System.out.println("YES");
        }else{
            System.out.println("NO");
        }
    }
}