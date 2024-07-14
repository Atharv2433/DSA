#include<iostream>
using namespace std;

class node {
public:
    int data;
    node* next;

    node(int val) {
        data = val;
        next = nullptr;  // Use nullptr instead of NULL for C++11 and later
    }
};

node* reverse_link_list(node* head) {
    // Base case: if head is null or only one node is left
    if (head == nullptr || head->next == nullptr) {
        return head;
    }

    // Recursive call to reverse the rest of the list
    node* new_head = reverse_link_list(head->next);

    // Reverse the current node's link
    head->next->next = head;
    head->next = nullptr;

    return new_head;  // Return the new head of the reversed list
}

void display_link_list(node* head) {
    node* temp = head;
    while (temp != nullptr) {
        cout << temp->data << " ";
        temp = temp->next;
    }
    cout << endl;
}

node* middle_link_list(node* head){
    if(head == nullptr || head->next == nullptr){
        return head;
    }
    node* slow = head;
    node* fast = head;

    while(fast != nullptr && fast->next != nullptr){
        slow = slow->next;
        fast = fast->next->next;
    }
    return slow;
}


node* merge_2_lists(node* list1,node* list2){

    node* dummylist = new node(-1);
    node* temp = dummylist;

    while(list1 != nullptr && list2 != nullptr){
        if(list1->data <= list2->data){
            temp->next = list1;
            list1 = list1->next;
        }
        else{
            temp->next = list2 ;
            list2=list2->next;
        }
        temp = temp->next;
    }

    if(list1 != nullptr){
        temp->next = list1;
        list1 = list1->next;
    }
    else{
        temp->next =list2;
        list2=list2->next;
    }
    return dummylist->next;
}


int main() {
    node* head = new node(1);
    head->next = new node(2);
    head->next->next = new node(3);
    head->next->next->next = new node(4);

    node* head2 =new node(11);
    head2->next = new node(12);
    head2->next->next = new node(13);
    head2->next->next->next = new node(14);

    cout << "Original Linked List : ";
    display_link_list(head);

    cout<<endl;

    cout << "Reversed Linked List : ";
    head = reverse_link_list(head);
    display_link_list(head);

    cout<<endl;

    node*  mid = middle_link_list(head);
    cout<<"Middle of linked list : "<<mid->data<<" "<<endl;


    node* m = merge_2_lists(head,head2);

    display_link_list(m);

    return 0;
}
