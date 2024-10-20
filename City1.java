import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Pair {
    int destination;
    int distance;

    Pair(int destination, int distance) {
        this.destination = destination;
        this.distance = distance;
    }
}

public class City1 {

    public void bfs(int src, ArrayList<ArrayList<Pair>> adj, int dis[], boolean vis[]) {
        Queue<Pair> q = new LinkedList<>();
        Arrays.fill(dis, Integer.MAX_VALUE);  // Reset distance array
        Arrays.fill(vis, false);              // Reset visited array

        dis[src] = 0;
        q.offer(new Pair(src, 0));

        while (!q.isEmpty()) {
            Pair node = q.poll();
            int curr = node.destination;

            if (vis[curr]) continue; // Ensure we only process unvisited nodes
            vis[curr] = true;

            for (Pair neighbor : adj.get(curr)) {
                int nnode = neighbor.destination;
                int ndist = neighbor.distance;

                if ((ndist + dis[curr]) < dis[nnode]) {
                    dis[nnode] = ndist + dis[curr];
                    q.offer(new Pair(nnode, dis[nnode])); // Only add if distance is updated
                }
            }
        }
    }

    public static void main(String[] args) {
        City1 t = new City1();
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int qr = sc.nextInt();

        // Initialize adjacency list with n + 1 (for 1-based indexing)
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            int source = sc.nextInt() - 1; // Adjust to 0-based
            int destination = sc.nextInt() - 1; // Adjust to 0-based
            int distance = sc.nextInt();

            adj.get(source).add(new Pair(destination, distance));
        }

        int dis[] = new int[n]; // No need for n+1 if using 0-based indexing
        boolean vis[] = new boolean[n]; // Same here

        for (int i = 0; i < qr; i++) {
            int source = sc.nextInt() - 1; // Adjust to 0-based
            int destination = sc.nextInt() - 1; // Adjust to 0-based

            // Run BFS from the current source
            t.bfs(source, adj, dis, vis);

            // Output the result for the current query
            if (destination < 0 || destination >= n || dis[destination] == Integer.MAX_VALUE) {
                System.out.println("No path from " + (source + 1) + " to " + (destination + 1));
            } else {
                System.out.println("Shortest distance from node " + (source + 1) + " to node " + (destination + 1) + ": " + dis[destination]);
            }
            // Reset the visited array for the next query
            Arrays.fill(vis, false);
        }
    }
}
