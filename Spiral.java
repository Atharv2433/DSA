public class Spiral {

    public static void spiralTraversal(int nums[][]) {
        if (nums == null || nums.length == 0 || nums[0].length == 0) {
            return; // Handle edge case of empty matrix
        }

        int startrow = 0;
        int endrow = nums.length - 1;
        int startcol = 0;
        int endcol = nums[0].length - 1;

        while (startrow <= endrow && startcol <= endcol) {
            // Traverse from left to right along the top row
            for (int j = startcol; j <= endcol; j++) {
                System.out.print(nums[startrow][j] + " ");
            }
            startrow++; // Move down to the next row

            // Traverse from top to bottom along the right column
            for (int i = startrow; i <= endrow; i++) {
                System.out.print(nums[i][endcol] + " ");
            }
            endcol--; // Move left to the previous column

            // Traverse from right to left along the bottom row, if there's a row remaining
            if (startrow <= endrow) {
                for (int j = endcol; j >= startcol; j--) {
                    System.out.print(nums[endrow][j] + " ");
                }
                endrow--; // Move up to the previous row
            }

            // Traverse from bottom to top along the left column, if there's a column remaining
            if (startcol <= endcol) {
                for (int i = endrow; i >= startrow; i--) {
                    System.out.print(nums[i][startcol] + " ");
                }
                startcol++; // Move right to the next column
            }
        }
    }

    public static void main(String[] args) {
        int nums[][] = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        spiralTraversal(nums);
    }
}
