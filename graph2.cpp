#include <iostream>
#include <vector>
using namespace std;

const int N = 1e3 + 10; // Constant for the size of the graph
vector<pair<int, int>> graph[N]; // Adjacency list representation

int main() {
    int n, m;
    cout << "Enter the number of vertices and edges: ";
    cin >> n >> m;

    cout << "Enter the edges with weights (vertex1 vertex2 weight):" << endl;
    for (int i = 0; i < m; ++i) {
        int v1, v2, weight;
        cin >> v1 >> v2 >> weight;
        
        graph[v1].emplace_back(v2, weight);
        graph[v2].emplace_back(v1, weight);
    }

    cout << "Adjacency list of the graph is as follows:" << endl;
    for (int i = 0; i < n; ++i) {
        cout << "Vertex " << i << ":";
        for (const auto& edge : graph[i]) {
            cout << " (" << edge.first << ", " << edge.second << ")";
        }
        cout << endl;
    }

    return 0;
}

//space =0v^2
//time =0(n+m)