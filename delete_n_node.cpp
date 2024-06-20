/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */
class Solution {
public:
    ListNode* removeNthFromEnd(ListNode* head, int n) {
        ListNode* dummy = new ListNode(0); // Create a dummy node to simplify edge cases
        dummy->next = head;
        ListNode* slow = dummy;
        ListNode* fast = dummy;
        
        // Move fast pointer n+1 steps ahead
        for (int i = 0; i <= n; ++i) {
            fast = fast->next;
        }
        
        // Move both pointers until fast reaches the end
        while (fast != nullptr) {
            slow = slow->next;
            fast = fast->next;
        }
        
        // Remove the nth node from end
        ListNode* nodeToDelete = slow->next;
        slow->next = slow->next->next;
        delete nodeToDelete;
        
        // Get the new head and delete dummy node
        ListNode* newHead = dummy->next;
        delete dummy;
        return newHead;
    }
};





class Node {
public:
    int data;
    Node* next;

    // Constructor
    Node(int data1, Node* next1) {
        data = data1;
        next = next1;
    }

    // Constructor 
    Node(int data1) {
        data = data1;
        next = nullptr;
    }
};

// Function to print the linked list
void printLL(Node* head) {
    while (head != NULL) {
        cout << head->data << " ";
        head = head->next;
    }
}

// Function to delete the Nth node
// from the end of the linked list
Node* DeleteNthNodefromEnd(Node* head, int N) {
    // Create two pointers, fastp and slowp
    Node* fastp = head;
    Node* slowp = head;

    // Move the fastp pointer N nodes ahead
    for (int i = 0; i < N; i++)
        fastp = fastp->next;

    // If fastp becomes NULL,
    // the Nth node from the end is the head
    if (fastp == NULL)
        return head->next;

    // Move both pointers until fastp reaches the end
    while (fastp->next != NULL) {
        fastp = fastp->next;
        slowp = slowp->next;
    }

    // Delete the Nth node from the end
    Node* delNode = slowp->next;
    slowp->next = slowp->next->next;
    delete delNode;
    return head;
}

int main() {
    vector<int> arr = {1, 2, 3, 4, 5};
    int N = 3;
    Node* head = new Node(arr[0]);
    head->next = new Node(arr[1]);
    head->next->next = new Node(arr[2]);
    head->next->next->next = new Node(arr[3]);
    head->next->next->next->next = new Node(arr[4]);

    // Delete the Nth node from the end 
    // and print the modified linked list
    head = DeleteNthNodefromEnd(head, N);
    printLL(head);
}

