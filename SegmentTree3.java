import java.util.Scanner;

public class SegmentTree3 {
    private int[] arr; // To keep track of who defeated whom
    private int[] seg; // Segment tree array

    public SegmentTree3(int n) {
        arr = new int[n + 1]; // 1-based indexing
        seg = new int[n * 4]; // Segment tree size
    }

    public void build(int ind, int low, int high) {
        if (low == high) {
            seg[ind] = 0; // No winner initially
            return;
        }
        int mid = (low + high) / 2;
        build(2 * ind + 1, low, mid);
        build(2 * ind + 2, mid + 1, high);
        seg[ind] = 0; // Initialize node
    }

    public void update(int ind, int low, int high, int l, int r, int winner) {
        // No overlap
        if (r < low || l > high) {
            return;
        }
        // Full overlap
        if (l <= low && high <= r) {
            for (int start = low; start <= high; start++) {
                if (arr[start] == 0 && start != winner) {
                    arr[start] = winner; // Mark defeated by winner
                }
            }
            seg[ind] = winner; // Set the winner for this segment
            return;
        }

        // Partial overlap
        int mid = (low + high) / 2;
        update(2 * ind + 1, low, mid, l, r, winner);
        update(2 * ind + 2, mid + 1, high, l, r, winner);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // number of knights
        int m = sc.nextInt(); // number of fights

        SegmentTree3 segmentTree = new SegmentTree3(n);
        segmentTree.build(0, 1, n); // Build segment tree (1-based index)

        int lastWinner = 0; // Variable to hold the last winner
        for (int i = 0; i < m; i++) {
            int l = sc.nextInt(); // start index of knights in this fight
            int r = sc.nextInt(); // end index of knights in this fight
            int x = sc.nextInt(); // winner of this fight
            segmentTree.update(0, 1, n, l, r, x); // Update the segment tree
            lastWinner = x; // Update last winner
        }

        // After processing all fights, set the last winner's value to 0
        if (lastWinner > 0) {
            segmentTree.arr[lastWinner] = 0;
        }

        // Output the results for knights 1 to n
        for (int i = 1; i <= n; i++) {
            System.out.print(segmentTree.arr[i] + " ");
        }
        sc.close();
    }
}
