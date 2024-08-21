import java.util.HashMap;
public class MAx_subarray{
    public static int count_the_len(int arr[] , int sum){
        
        HashMap<Integer,Integer> mpp = new HashMap<>();

        int maxi = 0;        
        
        int sum_1 =0;

        for(int i=0; i<arr.length;i++){
            sum_1 += arr[i];

            if(sum_1 == sum){
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
        int sum = 6;
        System.out.println(count_the_len(arr,sum));
    }
}