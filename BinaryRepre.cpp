#include <iostream>
#include <vector>
using namespace std;

struct Node {
    int data;
    Node* left;
    Node* right;

    Node(int val) : data(val), left(nullptr), right(nullptr) {}
};

void inorder(vector<int>& arr, Node* n) {
    if (n == nullptr) return;
    inorder(arr, n->left);
    arr.push_back(n->data);
    inorder(arr, n->right);
}

void preorder(vector<int>& arr, Node* n) {
    if (n == nullptr) return;
    arr.push_back(n->data);
    preorder(arr, n->left);
    preorder(arr, n->right);
}

void postorder(vector<int>& arr, Node* n) {
    if (n == nullptr) return;
    postorder(arr, n->left);
    postorder(arr, n->right);
    arr.push_back(n->data);
}

vector<int> inOrder(Node* n) {
    vector<int> arr;
    inorder(arr, n);
    return arr;
}

vector<int> preOrder(Node* n) {
    vector<int> arr;
    preorder(arr, n);
    return arr;
}

vector<int> postOrder(Node* n) {
    vector<int> arr;
    postorder(arr, n);
    return arr;
}

void printTraversal(const string& order, const vector<int>& result) {
    cout << order << " traversal: ";
    for (size_t i = 0; i < result.size(); ++i) {
        cout << result[i];
        if (i != result.size() - 1) {
            cout << "->";
        }
    }
    cout << endl;
}

void printLevelOrder(Node* root);

int height(Node* root) {
    if (root == nullptr) return 0;
    int leftHeight = height(root->left);
    int rightHeight = height(root->right);
    return (leftHeight > rightHeight) ? (leftHeight + 1) : (rightHeight + 1);
}

void printCurrentLevel(Node* root, int level) {
    if (root == nullptr) return;
    if (level == 1) {
        cout << root->data << " ";
    } else if (level > 1) {
        printCurrentLevel(root->left, level - 1);
        printCurrentLevel(root->right, level - 1);
    }
}

void printLevelOrder(Node* root) {
    if (root == nullptr) return;

    int h = height(root);
    for (int i = 1; i <= h; ++i) {
        printCurrentLevel(root, i);
        cout << endl;
    }
}

int main() {
    Node* n = new Node(1);
    n->left = new Node(2);
    n->right = new Node(3);
     
    n->left->left = new Node(4);
    n->left->right = new Node(5);

    n->right->left = new Node(6);
    n->right->right = new Node(7);

    vector<int> result = inOrder(n);
    vector<int> result2 = preOrder(n);
    vector<int> result3 = postOrder(n);

    printTraversal("In-Order", result);
    printTraversal("Pre-Order", result2);
    printTraversal("Post-Order", result3);

    cout << "Level Order traversal:\n";
    printLevelOrder(n);

    // Clean up memory
    delete n->left->left;
    delete n->left->right;
    delete n->right->left;
    delete n->right->right;
    delete n->left;
    delete n->right;
    delete n;

    return 0;
}
