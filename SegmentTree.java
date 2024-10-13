import java.util.Scanner;

public class SegmentTree{
    public static void buildtree(int ind, int low, int high, int arr[], int seg[]) {
        if (low == high) {
            seg[ind] = arr[low]; // Use low instead of ind here
            return;
        }
        int mid = (low + high) / 2;
        buildtree(2 * ind + 1, low, mid, arr, seg);
        buildtree(2 * ind + 2, mid + 1, high, arr, seg);
        
        // Combine the results from the left and right children
        seg[ind] = Math.min(seg[2 * ind + 1], seg[2 * ind + 2]);
          // Use seg[2 * ind + 1] and seg[2 * ind + 2]
    }
    public static int query(int ind, int low , int high ,int l ,int r ,int seg[]){
        if (r < low || l > high) {
            return Integer.MAX_VALUE; // Represents no overlap
        }
        
        // If the segment represented by this node is completely inside the query range
        if (l <= low && high <= r) {
            return seg[ind];
        }
        int mid = (low + high)/2;
        int left = query(2*ind+1,low,mid,l,r,seg);
        int right = query(2*ind+2,mid+1,high,l,r,seg);

        return Math.min(left,right);

    }
    
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while(t > 0){
            int n = sc.nextInt();
            int arr[] = new int[n];
            int seg[] = new int[4 * n];
            for(int i = 0; i < n; i++) arr[i] = sc.nextInt();
            buildtree(0,0,n-1,arr,seg);

            System.out.println("Enter the range to query (l r):");
            int l = sc.nextInt();
            int r = sc.nextInt();

            // Validate the input range
            if (l < 0 || r >= n || l > r) {
                System.out.println("Invalid range. Please ensure 0 <= l <= r < " + n);
            } else {
                // Query the segment tree
                int result = query(0, 0, n - 1, l, r, seg);
                System.out.println("Minimum value in range [" + l + ", " + r + "] is: " + result);
            }




            t--;
        }
    }
}