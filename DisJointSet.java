import java.util.Scanner;

public class DisJointSet {
    int parent[];
    int rank[];
    int size[];

    public DisJointSet(int n) {
        // Initialize arrays of size n
        parent = new int[n]; 
        rank = new int[n];
        size = new int[n];

        // Initialize parent, rank, and size for each element
        for (int i = 0; i < n; i++) { 
            parent[i] = i; // Each element is its own parent
            rank[i] = 0;   // Initial rank is 0
            size[i] = 1;   // Initial size is 1
        }
    }

    public int findparent(int node) {
        if (node == parent[node]) {
            return node;
        }
        // Path compression
        return parent[node] = findparent(parent[node]);
    }

    public void union(int src, int dest) {
        int u_p_src = findparent(src - 1);  // Adjusting for 0-based indexing
        int u_p_dest = findparent(dest - 1); // Adjusting for 0-based indexing

        if (u_p_dest == u_p_src) {
            return; // They are already in the same set
        }

        // Union by rank
        if (rank[u_p_src] < rank[u_p_dest]) {
            parent[u_p_src] = u_p_dest;
        } else if (rank[u_p_dest] < rank[u_p_src]) {
            parent[u_p_dest] = u_p_src;
        } else {
            parent[u_p_dest] = u_p_src;
            rank[u_p_src]++;
        }
    }

    public void union_by_size(int src, int dest) {
        int u_p_src = findparent(src - 1);
        int u_p_dest = findparent(dest - 1);

        if (u_p_src == u_p_dest) {
            return; // They are already in the same set
        }

        // Union by size
        if (size[u_p_src] < size[u_p_dest]) {
            parent[u_p_src] = u_p_dest;
            size[u_p_dest] += size[u_p_src];
        } else {
            parent[u_p_dest] = u_p_src;
            size[u_p_src] += size[u_p_dest];
        }
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();
        DisJointSet d = new DisJointSet(n);

        // Perform unions using union by rank
        d.union(1, 2);
        d.union(2, 3);
        d.union(4, 5);
        d.union(6, 7);
        d.union(5, 6);

        // Check if elements 3 and 7 are in the same set
        if (d.findparent(3 - 1) == d.findparent(7 - 1)) { 
            System.out.println("Same (Union by rank)");
        } else {
            System.out.println("Not Same (Union by rank)");
        }

        // Union 3 and 7
        d.union(3, 7);

        // Print the parent array to see the result of the unions
        System.out.print("Parent array after unions (Union by rank): ");
        for (int i = 0; i < n; i++) {
            System.out.print(d.parent[i] + " ");
        }
        System.out.println();

        // Reset and perform unions using union by size
        DisJointSet d2 = new DisJointSet(n);
        d2.union_by_size(1, 2);
        d2.union_by_size(2, 3);
        d2.union_by_size(4, 5);
        d2.union_by_size(6, 7);
        d2.union_by_size(5, 6);

        // Check if elements 3 and 7 are in the same set
        if (d2.findparent(3 - 1) == d2.findparent(7 - 1)) {
            System.out.println("Same (Union by size)");
        } else {
            System.out.println("Not Same (Union by size)");
        }

        // Union 3 and 7
        d2.union_by_size(3, 7);

        // Print the parent array and size array
        System.out.print("Parent array after unions (Union by size): ");
        for (int i = 0; i < n; i++) {
            System.out.print(d2.parent[i] + " ");
        }
        System.out.println();
        
        System.out.print("Size array after unions (Union by size): ");
        for (int i = 0; i < n; i++) {
            System.out.print(d2.size[i] + " ");
        }
        System.out.println();

        sc.close(); // Close the scanner to prevent resource leak
    }
}
