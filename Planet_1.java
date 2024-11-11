

import java.util.ArrayList;
import java.util.Scanner;

public class Planet_1 {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); // Number of nodes
        int q = sc.nextInt(); // Number of queries

        // Calculate the number of levels needed for binary lifting
        int m = (int)(Math.log(n) / Math.log(2)) + 1;

        // Initialize the sparse table with n rows and m columns
        ArrayList<ArrayList<Integer>> sparse = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            ArrayList<Integer> row = new ArrayList<>();
            for (int j = 0; j < m; j++) {
                row.add(-1);  // Initialize with -1 or any placeholder value
            }
            sparse.add(row);
        }
            
        // Populate the first column of the sparse table with the direct ancestor input data
        for (int i = 0; i < n; i++) {
            int ancestor = sc.nextInt() - 1; // Convert to zero-indexed
            sparse.get(i).set(0, ancestor);
        }

        // Fill the sparse table using binary lifting logic
        for (int j = 1; j < m; j++) {
            for (int i = 0; i < n; i++) {
                int parent = sparse.get(i).get(j - 1);
                if (parent != -1) {
                    sparse.get(i).set(j, sparse.get(parent).get(j - 1));
                }
            }
        }
        
        // Process the queries
        while (q > 0) {
            int x = sc.nextInt() - 1; // Convert x to zero-indexed
            int k = sc.nextInt();
            int ans = x;

            // Traverse ancestors based on binary representation of k
            for (int i = 0; i < m; i++) {
                if ((k & (1 << i)) != 0) { // Check if the i-th bit in k is set
                    if (ans == -1 || ans >= n) break; // Bounds check
                    ans = sparse.get(ans).get(i); // Move to the 2^i-th ancestor
                }
            }

            // Output the result (convert back to 1-based indexing)
            System.out.println((ans == -1) ? -1 : ans + 1);
            q--;
        }
        
        sc.close();
    }
}
