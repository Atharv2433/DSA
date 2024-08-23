public class KnapSack{
    public static int knapsack(int val[], int wt[],int W,int n){

        if(W == 0 ){
            return 0;
        }

        int dp[][] = new int[n+1][W+1];

        for(int i =0;i<n+1;i++){
            dp[i][0] = 0;
        }
        for(int j=0;j<W+1;j++){
            dp[0][j] = 0;
        }

        for(int i =1;i<n+1;i++){
            for(int j =0;j<W+1;j++){
                int v = val[i-1];
                int w = wt[i-1];


                if(w <= j){
                    int include_profit = v + dp[i-1][j-w];
                    
                    int exclude_profit = dp[i-1][j];

                    dp[i][j] = Math.max(include_profit,exclude_profit);
                }
                else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        print(dp);
        return dp[n][W];



    }

    public static void print(int dp[][]){
        for(int i =0; i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        int val[] = {60, 100, 120};
        int wt[] = {10, 20, 30};
        int W = 50;
        int n = val.length;

        int result = knapsack(val, wt, W, n);
        System.out.println(result); // Expected output: 220
    }
}
