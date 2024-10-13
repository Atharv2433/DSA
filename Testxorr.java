import java.util.ArrayList;
import java.util.Scanner;

public class Testxorr{
    ArrayList<Integer> seg;
    public Testxorr(int n){
        seg = new ArrayList<Integer>(n * 4);

        for(int i = 0 ; i < n * 4; i++){
            seg.add(0);
        }
    }
   

 

    public void buildtree(int ind ,int low ,int high , int arr[] , boolean orr){
        if(low == high){
            seg.set(ind , arr[low]);
            return;
        }
        int mid = (low + high) / 2;

        buildtree(2 * ind + 1 , low , mid , arr, !orr);
        buildtree(2 * ind + 2 , mid + 1 , high , arr , !orr);

        if(orr){
            seg.set(ind , seg.get(2 * ind + 1) | seg.get(2 * ind + 2));
        }else{
            seg.set(ind , seg.get(2 * ind + 1) ^ seg.get(2 * ind + 2));
        }
    }

    public void update(int ind ,int i , int val , int low , int high ,boolean orr){
        if(low == high){
            seg.set(ind , val);
            return;
        }
        int mid = (low + high) / 2;
        
        if(i <= mid){
            update(2 * ind + 1 , i , val , low , mid , !orr);
        }else{
            update(2 * ind + 2 , i , val , mid + 1 , high , !orr);
        }

        if(orr){
            seg.set(ind , seg.get(2 * ind + 1) | seg.get(2 * ind + 2));
        }else{
            seg.set(ind , seg.get(2 * ind + 1) ^ seg.get(2 * ind + 2));
        }
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        

        int arr[] = new int[n];

        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        Testxorr x = new Testxorr(n);

        boolean flag = true;

        if(n % 2 == 0){
            flag = false;
        }

        x.buildtree(0,0,n-1,arr,flag);

        int t = sc.nextInt();

        while(t > 0){

            int i = sc.nextInt();
            int val = sc.nextInt();
            i--;

            x.update(0,i,val,0,n-1,flag);


            System.out.println(x.seg.get(0));


            t--;
        }
    }
}