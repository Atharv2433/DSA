public class SumSquares {

    public static class Pair{
        int sum;
        int sqrSum;

        Pair(int s , int ss){
            this.sum = s;
            this.sqrSum = ss; 
        }
    }

    Pair seg[];
    int lazy[];

    public SumSquares(int n){
        seg = new Pair[4 * n];
        lazy = new int[4 * n];
    }

    

    public void buildTree(int ind , int low ,int high , int arr[]){

        if(low == high){
            seg[ind] = new Pair(arr[low], arr[low] * arr[low]);
            return;
        }

        int mid = (low + high)/2;

        buildTree(2 * ind + 1, low, mid, arr);
        buildTree(2 * ind + 2, mid + 1, high, arr);

        seg[ind] = calculate(seg[2 * ind + 1] , seg[2 * ind + 2]);
    }

    public  Pair calculate(Pair p1 , Pair p2){

        Pair ans = new Pair(0, 0);

        ans.sum = p1.sum + p2.sum;
        ans.sqrSum = p1.sqrSum + p2.sqrSum; 

        return ans;
    }

    public void propagate(int ind, int low, int high) {
        if (lazy[ind] != 0) {
            int count = (high - low + 1);
            seg[ind].sqrSum += count * lazy[ind] * lazy[ind] + 2 * lazy[ind] * seg[ind].sum;
            seg[ind].sum += count * lazy[ind];

            if (low != high) { // propagate to children if not a leaf
                lazy[2 * ind + 1] += lazy[ind];
                lazy[2 * ind + 2] += lazy[ind];
            }
            lazy[ind] = 0;
        }
    }

    public void update(int ind ,int low , int high ,int l ,int r, int x){
        propagate(ind , low , high);

        if(l > high || r < low){
            return;
        }

        if(l <= low && high <= r){
            lazy[ind] += x;
            propagate(ind, low, high);
        }
        else{
            int mid = (low + high)/2;

            update(2 * ind + 1, low, mid, l, r, x);
            update(2 * ind + 2, mid + 1, high, l, r, x);

            seg[ind] = calculate(seg[2 * ind + 1], seg[2 * ind + 2]);
        }
    }

    public Pair query(int ind , int low , int high , int l , int r ){
        if(l > high || r < low){
            return new  Pair(0, 0);
        }
        if(l <= low && high <= r){
            return seg[ind];
        }

        int mid = (low + high)/2;

        Pair left = query(2 * ind + 1, low, mid, l, r);
        Pair right = query(2 * ind + 2, mid + 1, high, l, r);

        return calculate(left, right);
    }

    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 5}; // Example array
        SumSquares st = new SumSquares(arr.length);
        
        st.buildTree(0, 0, arr.length - 1, arr);

        System.out.println("Initial sum of squares: " + st.query(0, 0, arr.length - 1, 0, arr.length - 1).sqrSum);

        st.update(0, 0, arr.length - 1, 1, 3, 2); // Increment elements from index 1 to 3 by 2
        System.out.println("Sum of squares after update: " + st.query(0, 0, arr.length - 1, 0, arr.length - 1).sqrSum);
    }
}