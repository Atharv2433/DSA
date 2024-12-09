package BinarySearch;

import java.util.Scanner;

public class Practice8 {

    public static int maxi(int arr[],int target){
        int low = 0;
        int high = arr.length - 1;
        int ind = arr.length;

        while(low <= high){
            int mid = (low + high)/2;

            if(arr[mid] >= target){
                ind = mid;
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }   
        return ind;
    }

    public static int maxiOnes(int arr[][] , int n , int m){
        int maxCount = - 1;
        int maxIndex = - 1;
        
        for(int i = 0; i < n; i++){
            int count = m - maxi(arr[i], 1);

            if(count > maxCount){
                maxCount = count;
                maxIndex = i;
            }
        }
        return maxIndex;
    }
    

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int arr[][] = new int[n][m];

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m ; j++){
                arr[i][j] = sc.nextInt();
            }
        }

        System.out.println(maxiOnes(arr, n, m));
    }
}
