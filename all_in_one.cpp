#include<iostream>
#include<vector>
#include<stack>
#include<cmath>
using namespace std;

struct node {
    int data;
    node* left;
    node* right;

    node(int val) {
        data = val;
        left = right = NULL;
    }
};

void traversal(node* n, vector<int>& in_order, vector<int>& pre_order, vector<int>& post_order) {
    if (n == NULL) return;

    stack<pair<node*, int>> st;
    st.push({n, 1});

    while (!st.empty()) {
        auto& [n, state] = st.top();

        if (state == 1) {
            pre_order.push_back(n->data);
            state++;
            if (n->left) st.push({n->left, 1});
        } else if (state == 2) {
            in_order.push_back(n->data);
            state++;
            if (n->right) st.push({n->right, 1});
        } else {
            post_order.push_back(n->data);
            st.pop();
        }
    }
}

int height(node* n) {
    if (n == NULL) return 0;

    int left = height(n->left);
    int right = height(n->right);

    return (left > right) ? (left + 1) : (right + 1);
}

bool balanced(node* n) {
    if (n == NULL) return true;

    int left = height(n->left);
    int right = height(n->right);

    if (abs(left - right) > 1) return false;

    return balanced(n->left) && balanced(n->right);
}

int diameter_h(node* n, int& di) {
    if (n == NULL) return 0;

    int left = diameter_h(n->left, di);
    int right = diameter_h(n->right, di);
    di = max(di, left + right);
    return (left > right) ? (left + 1) : (right + 1);
}

int diameter(node* n) {
    int di = 0;
    diameter_h(n, di);
    return di;
}

int max_long_path_sum(node* n ,int& maxi){
    if(n == NULL)return 0;

    int left = max(0,max_long_path_sum(n->left,maxi));
    int right = max(0,max_long_path_sum(n->right,maxi));

    maxi = (maxi , left+right+n->data);

    return max(left,right) + n->data;
}

int main() {
    node* n = new node(1);
    n->left = new node(2);
    n->right = new node(3);
    n->left->left = new node(4);
    n->left->right = new node(5);
    n->right->left = new node(6);
    n->right->right = new node(7);

    vector<int> res_1;
    vector<int> res_2;
    vector<int> res_3;

    int maxi = 0;

    int l = max_long_path_sum(n,maxi);

    cout<<"Longest Path "<<l;

    cout<<endl;

    int d = diameter(n);

    cout << "Diameter: " << d << endl;

    traversal(n, res_1, res_2, res_3);

    bool b = balanced(n);

    int h = height(n);

    cout << (b ? "Balanced" : "Unbalanced") << endl;
    cout << "Height of the tree: " << h << endl;

    cout << "Preorder: ";
    for (int val : res_2) {
        cout << val << " ";
    }
    cout << endl;

    cout << "Inorder: ";
    for (int val : res_1) {
        cout << val << " ";
    }
    cout << endl;

    cout << "Postorder: ";
    for (int val : res_3) {
        cout << val << " ";
    }
    cout << endl;

    return 0;
}
