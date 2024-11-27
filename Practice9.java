package DP;

import java.util.Arrays;
import java.util.Scanner;

public class Practice9 {

    public static int fun(int ind , int wts[] ,int wt,int costs[], int dp[][]){
        if(ind == wts.length - 1){
            return wt >= wts[ind] ? costs[ind] : 0;
        }
        if(dp[ind][wt] != -1){
            return dp[ind][wt];
        }

        int take = 0;
        if(wts[ind] <= wt){
            take = costs[ind] + fun(ind + 1, wts, wt - wts[ind], costs,dp);
        }
        int notTake = fun(ind + 1, wts, wt , costs,dp);

        return dp[ind][wt] = Math.max(take, notTake);
    }
    

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int wt = sc.nextInt();

        int arr[] = new int[n];
        int arr2[] = new int[n];

        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        for(int i = 0; i < n; i++){
            arr2[i] = sc.nextInt();
        }

        int dp[][] = new int[n][wt + 1];

       
        for(int it[] : dp){
            Arrays.fill(it, -1);
        }
       

        
        System.out.println(fun(0, arr, wt, arr2 , dp));

    }
}
