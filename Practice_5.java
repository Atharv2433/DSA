import java.util.Scanner;

public class Practice_5 {

    int seg[];

    public Practice_5(int n){
        seg = new int[4 * n];

        for(int i = 0; i < 4 * n; i++){
            seg[i] = 0;
        }
    }

    public void build(int ind , int low , int high , int arr[]){
        if(low == high){
            seg[ind] = arr[low];
            return;
        }

        int mid = (low + high)/2;

        build(2 * ind + 1, low, mid, arr);
        build(2 * ind + 2, mid + 1, high, arr);


        seg[ind] = Math.max(seg[2 * ind + 1] , seg[2 * ind + 2]);
    }
    
    public int query(int ind , int low ,int high , int l , int r){
        if(r < low || l > high){
            return Integer.MIN_VALUE;
        }
        if(l <= low && high <= r){
            return seg[ind];
        }

        int mid = (low + high) / 2;
        int left = query(2 * ind + 1, low, mid, l, r);
        int right = query(2 * ind + 2, mid + 1, high, left, r);


        return Math.max(left, right);
    }

    public void update(int ind , int low ,int high , int i , int val){
        if(low == high){
            seg[ind] = val;
            return;
        }

        int mid = (low + high)/2;

        update(2 * ind + 1, low, mid, i, val);
        update(2 * ind + 2, mid + 1, high, i, val);

        seg[ind] = Math.max(seg[2 * ind + 1] , seg[2 * ind + 2]);

    }

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        Practice_5 p = new Practice_5(n);

        int arr[] = new int[n];

        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }

        p.build(0, 0, n-1, arr);

        int q = sc.nextInt();

        while(q > 0){

            int l = sc.nextInt();
            int r =  sc.nextInt();

            l--;
            r--;

            int res = p.query(0, 0, n-1, l, r);

            System.out.println(res);

            q--;
        }

        int ind = sc.nextInt();
        int value = sc.nextInt();

        arr[ind] = value;
        p.update(0, 0, n-1, ind, value);

        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }


    }
}
