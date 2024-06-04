#include <iostream>
#include <vector>

using namespace std;

const int N = 1e3 + 10; // Maximum allowed vertices (1000 + 10)

vector<int> graph[N];
bool visited[N];

void dfs(int vertex) {
  visited[vertex] = true;
  for (int child : graph[vertex]) {
    if (!visited[child]) { // Only explore unvisited nodes
      dfs(child);
    }
  }
}

int main() {
  int n, m;

  cout << "Enter vertices and edges: ";
  cin >> n >> m;

  // Input edges
  for (int i = 0; i < m; ++i) {
    int v1, v2;
    cin >> v1 >> v2;
    graph[v1].push_back(v2); // Add edge from v1 to v2
    graph[v2].push_back(v1); // Add edge from v2 to v1 for undirected graph
  }

  cout << "List of the graph:\n";  // Improved output with newline

  // Print the graph adjacency list
  for (int i = 0; i < n; ++i) {
    cout << i << ": ";
    for (auto neighbor : graph[i]) {
      cout << neighbor << " ";
    }
    cout << endl;  // Newline after each vertex
  }

  cout << "Enter the root node ";
  int vertex;
  cin >> vertex;

  dfs(vertex);

  cout << "DFS traversal: ";
  for (int i = 0; i < n; i++) {
    if (visited[i]) {
      cout << i << " ";
    }
  }
  cout << endl;

  return 0;
}
