#include <iostream>
using namespace std;

const int N = 1e3 + 10;

// 2-dimensional array for vertices and edges
int graph[N][N] = {0}; // Initialize all elements to 0

int main(){
    // n = no. of vertices, m = no. of edges
    int n, m;
    cout << "Enter number of vertices and edges: ";
    cin >> n >> m;
    
    cout << "Enter the edges (pairs of vertices): " << endl;
    for(int i = 0; i < m; ++i){
        int v1, v2;
        cin >> v1 >> v2;
        graph[v1][v2] = 1;
        graph[v2][v1] = 1;
    }
    
    cout << "Adjacency matrix of the graph: " << endl;
    for(int j = 0; j < n; j++){
        for(int k = 0; k < n; k++){
            cout << graph[j][k] << " ";
        }
        cout << endl;
    }

    return 0;
}


//space = n^2
//time more if array is big
