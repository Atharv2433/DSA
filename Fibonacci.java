import java.util.Arrays;

public class Fibonacci{

    public static int fib(int n , int dp[]){
        if(n == 1){
            return 1;
        }
        if(n == 0){
            return 0;
        }
        if(dp[n] != -1){
            return dp[n];
        }
        return dp[n] = fib(n-1,dp) + fib(n - 2,dp);
    }

    public static int fib_1(int n1, int dp_1[]){
        if(n1 == 0 ){
            return 0;
        }
        if(n1 == 1 ){
            return 1;
        }

       int prev = 1;
       int prev2 = 0;

       for(int i = 1;i<n1;i++){
            int curr = prev + prev2;
            prev2 = prev;
            prev = curr;
       }
       return prev;
    }
    public static void main(String[] args){
        int n = 4;
        
        int dp[] = new int[n+1];
        Arrays.fill(dp,-1);
        int res = fib(n,dp);
        int res2 = fib_1(n,dp);
        System.out.println(res);
        System.out.println(res2);
    }
}