/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
class Solution {
public:
    bool hasCycle(ListNode *head) {
        if(head == NULL) return NULL;
        ListNode* temp = head;
        ListNode* temp1 = head;

        while(temp != NULL && temp->next != NULL){
            temp = temp->next->next;
            temp1 = temp1->next;

            if(temp == temp1){
                return true;
            }
        }
        return false;
    }
};