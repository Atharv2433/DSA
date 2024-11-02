import java.util.Scanner;

public class LazyPropogation {
    
    int seg[];
    int lazy[];

    public LazyPropogation(int  n){
        seg = new int[4 * n];
        lazy = new int[4 * n];
    }

    public void build_tree(int ind , int low , int high , int arr[]){
        if(low == high){
            seg[ind] = arr[low];
            return;
        }
        int mid = (low + high)/2;

        build_tree(2 * ind + 1, low, mid, arr);
        build_tree(2 * ind + 2, mid + 1, high, arr);

        seg[ind] = seg[2 * ind + 1] + seg[2 * ind + 2];
    }


 
    public void propogate(int ind , int low ,int high){
        if(lazy[ind] != 0){
            seg[ind] += (high - low + 1) * lazy[ind];
            if(low != high){
                lazy[2 * ind + 1] += lazy[ind];
                lazy[2 * ind + 2] += lazy[ind];
            }
            lazy[ind] = 0;
        }
    }

    public int query(int ind , int low , int high , int l , int r){
        propogate(ind, low, high);


        if (l > high || r < low) {
            return 0;
        }


        if(l <= low && high <= r){
            return seg[ind];
        }

    
        int mid = (low + high)/2;

        int left = query(2 * ind + 1, low, mid, l, r);
        int right = query(2 * ind + 2, mid + 1, high, l, r);

        return left + right;

    }

    public void update(int ind , int low ,int high , int l ,int r,int val){
        propogate(ind, low, high);
    
        if (l > high || r < low) {
            return;
        }

        if(l <= low && high <= r){
            seg[ind] += (high - low + 1) * val;
            if(low != high){
                lazy[2 * ind + 1] += val;
                lazy[2 * ind + 2] += val;
            }
            return;
        }

        int mid = (low + high)/2;

        update(2 * ind + 1, low, mid, l, r,val);
        update(2 * ind + 2, mid + 1, high, l, r,val);

        seg[ind] = seg[2 * ind + 1] + seg[2 * ind + 2];
        
    }

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        LazyPropogation l = new LazyPropogation(n);

        int arr[] = new int[n];

        for(int i = 0;i < n; i++){
            arr[i] = sc.nextInt();
        }

        l.build_tree(0, 0, n-1, arr);

        int q = sc.nextInt();

        while(q > 0){

            int l1 = sc.nextInt();
            int r = sc.nextInt();

            l1--;
            r--;

            int rs = l.query(0, 0, n-1, l1, r);

            System.out.println(rs);

            q--;
        }
        int l2 = sc.nextInt();
        int r2 = sc.nextInt();
        int value = sc.nextInt();
        l2--;
        r2--;

        l.update(0, 0, n-1,l2 , r2, value);

        for(int i = 0; i < n; i ++){
            System.out.println(l.seg[i]);
        }
    }
}
