package BinarySearch;

import java.util.Scanner;

public class PeakElement2D {

    public static int maxElement(int arr[][] , int n , int m , int col){
        int maxi = -1;

        for(int i = 0; i < n; i++){
            if(arr[i][col] > maxi){
                maxi = i;
            }
        }

        return maxi;
    }

    public static int findPeak(int arr[][] , int n , int m){
        int low = 0;
        int high = m-1;

        while(low <= high){
            int mid = (low + high)/2;

            int ind = maxElement(arr, n , m, mid);
            int left = mid - 1 >= 0 ? arr[ind][mid - 1] : -1;
            int right = mid + 1 < m ? arr[ind][mid + 1] : -1;

            if(arr[ind][mid] > left && arr[ind][mid] > right){
                return arr[ind][mid];
            }
            else if(arr[ind][mid] < left && arr[ind][mid] > right){
                high = mid - 1;
            }else{
                low = mid + 1;
            }

        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int arr[][] = new int[n][m];

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                arr[i][j] = sc.nextInt();
            }
        }

        int res = findPeak(arr, n, m);
        System.out.println(res);



    }
    
}

