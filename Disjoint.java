public class Disjoint{

    vector<int> rank,parent,vis;
    public 
        Disjoint(int n){
            rank.resize(n+1,0);
            parent.resize(n+1);
        for(int i = 1 ;i <= n; i++){
            parent[i] = i;
        }
    }
    int find_pair(int node){
        if(node == parent[node]){
            return node;
        }
        return parent[node] = find_pair(parent[node]);
    }

    void find_union(int u,int v){
        int ulp = find_pair(u);
        int vlp = find_pair(v);

        if(ulp == vlp){
            return;
        }
        if(rank[ulp] < rank[vlp]){
            parent[vlp] = ulp;
        }else if(rank[ulp] > rank[vlp]){
            parent[ulp] = vlp;
        }else{
            parent[ulp] = vlp;
            rank[vlp]++;
        }
    }




}