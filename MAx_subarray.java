import java.util.HashMap;
public class MAx_subarray{
    public static int count_the_len(int arr[] , int n){
        
        HashMap<Integer,Integer> mpp = new HashMap<>();

        int maxi = 0;             
        int sum_1 = 0;

        for(int i=0; i<n;i++){
            sum_1 += arr[i];

            if(sum_1 == 0){
                maxi = i+1;
            }
            else{
                if(mpp.get(sum_1) != null){
                    maxi = Math.max(maxi,i - mpp.get(sum_1));
                }else{
                    mpp.put(sum_1,i);
                }
            }
        }
        return maxi;

    }
    public static void main(String[] args){
        int arr[] = {1,2,3,4};
        int n = arr.length;
        System.out.println(count_the_len(arr,n));
    }
}

// 