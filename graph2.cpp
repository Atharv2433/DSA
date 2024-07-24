// #include <iostream>
// #include <vector>
// using namespace std;

// int main() {
//     int n, m;
//     cin >> n >> m;
//     vector<int> adj[n + 1];  // Adjacency list representation

//     for (int i = 0; i < m; i++) {
//         int u, v;
//         cin >> u >> v;
//         adj[u].push_back(v);
//         adj[v].push_back(u);
//     }

//     // Print the adjacency list
//     for (int i = 1; i <= n; i++) {
//         cout << "Vertex " << i << ":";
//         for (int j = 0; j < adj[i].size(); j++) {
//             cout << " " << adj[i][j];
//         }
//         cout << endl;
//     }
    
//     return 0;
// }

// // Space Complexity: O(V + E) where V is the number of vertices and E is the number of edges
// // Time Complexity: O(n + m) where n is the number of vertices and m is the number of edges


#include <iostream>
#include <vector>
#include <queue>
using namespace std;

vector<bool> visited;
vector<int> current_cc;
vector<vector<int>> v1;
int n, m;

void dfs(int vertex) {
    visited[vertex] = true;
    current_cc.push_back(vertex);
    
    for (auto& child : v1[vertex]) {
        if (!visited[child]) {
            dfs(child);
        }
    }
}

vector<int> bfs(int vertex) {
    vector<bool> local_visited(n + 1, false); // Local visited vector for BFS
    vector<int> bfs_order;
    queue<int> q;

    q.push(vertex);
    local_visited[vertex] = true;

    while (!q.empty()) {
        int current = q.front();
        q.pop();
        
        bfs_order.push_back(current);

        for (int neighbor : v1[current]) {
            if (!local_visited[neighbor]) {
                local_visited[neighbor] = true;
                q.push(neighbor);
            }
        }
    }
    
    return bfs_order;
}

int main() {
    cin >> n >> m;

    v1.resize(n + 1);  // Initialize adjacency list
    visited.resize(n + 1, false);  // Initialize visited vector

    int u, v;
    for (int i = 0; i < m; i++) {
        cin >> u >> v;
        v1[u].push_back(v);
        v1[v].push_back(u);  // Since the graph is undirected
    }

    // Print adjacency list
    for (int i = 1; i <= n; i++) {
        cout << "Vertex " << i << ":";
        for (int j = 0; j < v1[i].size(); j++) {
            cout << " " << v1[i][j];
        }
        cout << endl;
    }

    // Perform DFS for each component
    for (int i = 1; i <= n; i++) {
        if (!visited[i]) {
            current_cc.clear();
            dfs(i);
            cout << "DFS Connected component:";
            for (int vertex : current_cc) {
                cout << " " << vertex;
            }
            cout << endl;
        }
    }

    // Perform BFS starting from vertex 1 (example)
    vector<int> bfs_result = bfs(1);
    cout << "BFS Traversal starting from vertex 1:";
    for (int vertex : bfs_result) {
        cout << " " << vertex;
    }
    cout << endl;

    return 0;
}


// #include<iostream>
// #include<vector>
// using namespace std;

// vector<bool> visited;
// vector<int> current_cc;




// int main(){
//     int n,m;
//     cin>>n>>m;

//     vector<vector<pair<int,int>>> v1(n+1);
//     int u,v,weight;
//     for(int i = 0;i<m;i++ ){
//         cin>>u>>v>>weight;
//         v1[u].push_back({v,weight});
        
//     }

//     for(int i =1;i<=n;i++){
//         cout<<"Vertex "<<i<<":";
//         for(int j =0;j<v1[i].size();j++){
//             cout<<" "<<v1[i][j].first<<","<<v1[i][j].second;
//         }
//         cout<<endl;
//     }
// }

