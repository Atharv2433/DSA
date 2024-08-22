import java.util.HashMap;
public class Count_w_xor{
    public static int count_xor(int arr[],int k){
        if(k == 0){
            return 0;
        }

        HashMap<Integer,Integer> mpp = new HashMap<>();
        int xr =0;
        int n=arr.length;
        int count =0;
        
        mpp.put(xr,1);

        for(int i =0;i<n;i++){
            xr = xr ^ arr[i];
            int x = xr ^ k;
        
        if (mpp.containsKey(x)){
            count += mpp.get(x);
        }

        if (mpp.containsKey(xr)) {
            mpp.put(xr, mpp.get(xr) + 1);
        } 

        else {
            mpp.put(xr, 1);
        }

     }
     return count;
    }

    public static void main(String[] args){
        int arr[] = {1,2,3,4,5};
        int k = 5;
         System.out.println(count_xor(arr,k));
    }
}

// declare an hashmap put o,1 in it

// iterate and make xor of xr and arr[i]

// check if it is present in the  mpp x

// if it is update the count

// check if it is present in the  mpp xr

// if it is then update the count by 1

// if not put in the mapp

// return the count