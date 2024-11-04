import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class LongestFightRoute {

    ArrayList<ArrayList<Integer>> adj;

    public LongestFightRoute(int n){
        adj = new ArrayList<>();
        for(int i = 0; i <= n; i++){
            adj.add(new ArrayList<>());
        }
    }

    public void addEdge(int src ,int dest){
        adj.get(src).add(dest);
    }
    
    ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
    ArrayList<Integer> temp = new ArrayList<>();
    
    public void dfs(int node , ArrayList<ArrayList<Integer>> adj , boolean vis[],int end){
        vis[node] = true;
        temp.add(node);
        if(node == end){
            ans.add(new ArrayList<>(temp));
        }else{
            for(int it : adj.get(node)){
                if(!vis[it]){
                    dfs(it, adj, vis, end);
                }
            }
        }
        temp.remove(temp.size() - 1);
        vis[node] = false;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        LongestFightRoute l = new LongestFightRoute(n);

        for(int i = 0; i < m; i++){
            int src = sc.nextInt();
            int dest = sc.nextInt();

            l.addEdge(src , dest );
        }
        
        boolean[] vis = new boolean[n + 1];
        int start = 1;
        int end = n;

        l.dfs(start, l.adj, vis, end);

        Collections.sort(l.ans, (list1, list2) -> {
            int len = Math.min(list1.size(), list2.size());
            for (int i = 0; i < len; i++) {
                if (!list1.get(i).equals(list2.get(i))) {
                    return list1.get(i) - list2.get(i);
                }
            }
            return list1.size() - list2.size();  // Sort by length if all elements so far are equal
        });

        
            System.out.println(l.ans.get(l.ans.size() - 1).size());
            for (int it : l.ans.get(l.ans.size() - 1)) {
                System.out.print(it + " ");
            }
            System.out.println();
        
        
    }
}
