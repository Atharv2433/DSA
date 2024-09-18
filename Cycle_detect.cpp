class Cycle_detect {
     private:
    void dfs(int start,vector<int> adj[],vector<int> &vis,stack<int> &st){
        vis[start] = 1;
        
        for(auto it : adj[start]){
            if(!vis[it]){
                dfs(it,adj,vis,st);
            }
        }
        st.push(start);
    }
  public:
    // Function to detect cycle in a directed graph.
    bool isCyclic(int V, vector<int> adj[]) 
      {
	    
	   stack<int> st;
	   vector<int> vis(V,0);
	   vector<int> ans;
	   
	   for(int i =0;i < V;i++){
	       if(!vis[i]){
	            dfs(i,adj,vis,st);
	       }
	      
	   }

	   
	  return (st.size()-1 != V) ? true : false;
	   
    }
};