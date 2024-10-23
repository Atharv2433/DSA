package DP;
import java.util.Scanner;
public class Frogenergy {



    public  int fun(int n , int arr[],int dp[]){
        if(n == 0){
            return 0;
        }
        if(n == 1){
            return Math.abs(arr[0] - arr[1]);
        }
        if(dp[n] != -1){
            return dp[n];
        }
        int one = fun(n-1,arr,dp) + Math.abs(arr[n] - arr[n-1]);
        int two = fun(n-2,arr,dp) + Math.abs(arr[n] - arr[n-2]);

        return dp[n] = Math.min(one,two);
    }
    public static void main(String  args[]){

        Scanner sc = new Scanner(System.in);
        Frogenergy f = new Frogenergy();
       
        int n = sc.nextInt();
        int arr[] = new int[n];
        int dp[] = new int[n];

        for(int i = 0; i < n; i++){
            dp[i] = -1;
        }

        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }

        int res = f.fun(n-1,arr,dp);

        System.out.println(res);;
    }
}
