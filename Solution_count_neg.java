public class Solution {
    public static int count_negatives(int arr[]) {
        int count = 0;
        boolean flag = false;  
        int temp = 0;  
        
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > 0) {
                flag = true;
                temp = 0;  
            }
            if (flag && arr[i + 1] < 0) {
                temp++;  
            }
            if (flag && arr[i + 1] > 0) {
                count += temp;  
                flag = false; 
            }
        }
        
        return count;
    }

    public static void main(String[] args) {
        int arr[] = {-1, -2, 2, -2,3,-2, 3, 4, -1};
        int res = count_negatives(arr);
        System.out.println(res);  
    }
}
