import java.util.Arrays;

public class Knapsack {
    public static int knapsack(int val[], int wt[], int W, int n, int[][] dp) {
        if (W == 0 || n == 0) {
            return 0;
        }
        if (dp[n][W] != -1) {
            return dp[n][W];
        }
        if (wt[n - 1] <= W) {
            // Include the item
            int ans_1 = val[n - 1] + knapsack(val, wt, W - wt[n - 1], n - 1, dp);
            // Exclude the item
            int ans_2 = knapsack(val, wt, W, n - 1, dp);

            dp[n][W] = Math.max(ans_1, ans_2);
        } else {
            dp[n][W] = knapsack(val, wt, W, n - 1, dp);
        }
        return dp[n][W];
    }

    public static int tab_knapsack(int val[], int wt[], int W, int n) {
        int dp[][] = new int[n + 1][W + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= W; j++) {
                int v = val[i - 1];
                int w = wt[i - 1];

                if (w <= j) {
                    int include_profit = v + dp[i - 1][j - w];
                    int exclude_profit = dp[i - 1][j];
                    dp[i][j] = Math.max(include_profit, exclude_profit);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][W];
    }

    public static void main(String[] args) {
        int val[] = {60, 100, 120};
        int wt[] = {10, 20, 30};
        int W = 50;
        int n = val.length;

        int[][] dp = new int[n + 1][W + 1];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }

        // Using memoized recursive approach
        System.out.println(knapsack(val, wt, W, n, dp));

        // Using iterative tabulation approach
        System.out.println(tab_knapsack(val, wt, W, n));
    }
}
