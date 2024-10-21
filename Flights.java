import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Flights {

    public static class Pair {
        int destination, distance;

        public Pair(int destination, int distance) {
            this.destination = destination;
            this.distance = distance;
        }

        public int getFirst() {
            return destination;
        }

        public int getSecond() {
            return distance;
        }
    }

    public static class Pair2{
        int dest ,  cost ; 
        boolean used ;
        public Pair2(int dest ,int cost , boolean used){
            this.dest =  dest;
            this.cost = cost;
            this.used = used;
        }

        public int getFirstp() {
            return dest;
        }

        public int getSecondp() {
            return cost;
        }
        public boolean getThirdp() {
            return used;
        }
    }

    HashMap<Integer, List<Pair>> adj = new HashMap<>();
    int mini = Integer.MAX_VALUE;  // Set to MAX_VALUE to find the minimum

    public void addedge(int src, int dest, int distance) {
        adj.putIfAbsent(src, new LinkedList<>());
        adj.putIfAbsent(dest, new LinkedList<>());
        adj.get(src).add(new Pair(dest, distance));
        adj.get(dest).add(new Pair(src, distance));
    }

    
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Flights f = new Flights();

        int n = sc.nextInt();
        int m = sc.nextInt();

        for (int i = 0; i < m; i++) {
            int src = sc.nextInt();
            int dest = sc.nextInt();
            int distance = sc.nextInt();

            f.addedge(src - 1, dest - 1, distance);  // Adjust to 0-based indexing
        }

        Queue<Pair2> q = new LinkedList<>();
        int dist[][] = new int[n+1][1];

        for(int i = 0; i <= n; i++){
            Arrays.fill(dist,Integer.MAX_VALUE);
        }

        dist[1][0] = 0;
        q.offer(new Pair2(1,0, false));

        while(!q.isEmpty()){
            Pair2 node = q.poll();
            int dest = node.getFirstp();
            int distance = node.getSecondp();
            boolean flag = node.getThirdp();

            if(distance > dist[dest][flag ? 1 : 0]){
                continue;
            }

            for(Pair it : f.adj.get(dest)){
                int ndestination = it.getFirst(); 
                int ndistances = it.getSecond();


                if(distance + ndistances < dist[ndestination][flag ? 1 : 0]){
                    dist[ndestination][flag ? 1 : 0] = distance + ndistances;
                    q.offer(new Pair2(ndestination, dist[ndestination][flag ? 1 : 0], flag));
                }

                if(!flag && ){

                }
            }
        }

       
    }
}
