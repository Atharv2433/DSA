package Problem1;

import java.util.Scanner;

public class Problem1_1 {



    public static void markRow(int rowArr[], int row , int col){
        rowArr[row] = 1;
    }
    public static void markCol(int colArr[] , int row , int col){
        colArr[col] = 1;
    }

    public static void markRow(int arr[][] , int row){
        for(int i = 0; i < arr.length; i++){
            arr[i][row] = 0;
        }
    }
    public static void markCol(int arr[][] , int col){
        for(int i = 0; i < arr[0].length; i++){
            arr[col][i] = 0;
        }
    }
    public static int[][] fun(int arr[][] , int row[],int col[] , int n , int m){

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(arr[i][j] == 0){
                    markRow(row,  i , j);
                    markCol(col, i , j);
                }
            }
        }

        for(int i = 0; i < n; i++){
            if(row[i] == 1){
                markRow(arr , i );
            }
        }

        for(int i = 0; i < m; i++){
            if(col[i] == 1){
                markCol(arr , i );
            }
        }

        return arr;

    }
    
    public static void main(String[] args) {
        

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        

        int arr[][] = new int[n][m];

        int row[] = new int[n];
        int col[] = new int[m];

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                arr[i][j] = sc.nextInt();
            }
        }

        int res[][] = fun(arr,row,col, n, m);

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}   
