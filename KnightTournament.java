import java.util.Scanner;

class SegmentTree {
    private int[] tree;
    private int[] defeatedBy;
    private int n;

    public SegmentTree(int size) {
        n = size;
        tree = new int[4 * n]; // Segment tree size
        defeatedBy = new int[n + 1]; // To store who defeated whom
    }

    // Build the segment tree initially with zeros
    public void build() {
        build(1, 1, n);
    }

    private void build(int node, int start, int end) {
        if (start == end) {
            tree[node] = 0; // No winner initially
        } else {
            int mid = (start + end) / 2;
            build(2 * node, start, mid);
            build(2 * node + 1, mid + 1, end);
            tree[node] = 0; // Initialize to zero
        }
    }

    // Update the segment tree and defeatedBy array
    public void update(int l, int r, int winner) {
        update(1, 1, n, l, r, winner);
    }

    private void update(int node, int start, int end, int l, int r, int winner) {
        // Update range
        if (start > r || end < l) {
            return; // No overlap
        }
        if (start >= l && end <= r) {
            for (int i = start; i <= end; i++) {
                if (defeatedBy[i] == 0 && i != winner) {
                    defeatedBy[i] = winner; // Mark defeated by winner
                }
            }
            tree[node] = winner; // Set the winner in this segment
            return; // Full overlap
        }
        
        // Partial overlap
        int mid = (start + end) / 2;
        update(2 * node, start, mid, l, r, winner);
        update(2 * node + 1, mid + 1, end, l, r, winner);
    }

    // Get defeatedBy information
    public int[] getDefeatedBy() {
        return defeatedBy;
    }
}

public class KnightTournament {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // number of knights
        int m = sc.nextInt(); // number of fights
        
        SegmentTree segmentTree = new SegmentTree(n);
        segmentTree.build();

        // Process each fight
        for (int i = 0; i < m; i++) {
            int l = sc.nextInt(); // start index of knights in this fight
            int r = sc.nextInt(); // end index of knights in this fight
            int x = sc.nextInt(); // winner of this fight
            segmentTree.update(l, r, x); // Update the segment tree
        }

        // The last winner is not defeated by anyone
        int lastWinner = sc.nextInt(); // The last winner from the last fight
        segmentTree.getDefeatedBy()[lastWinner] = 0; // Set last winner's value to 0

        // Output the results for knights 1 to n
        int[] result = segmentTree.getDefeatedBy();
        for (int i = 1; i <= n; i++) {
            System.out.print(result[i] + " ");
        }
        sc.close();
    }
}
