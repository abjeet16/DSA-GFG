/* Structure of Doubly Linked List
class Node
{
    int data;
    Node next;
    Node prev;
}*/
class Solution {
    static Node deleteAllOccurOfX(Node head, int x) {
        // code here
        while(head!=null&&head.data==x){
            head = head.next;
        }
        head.prev = null;
        Node temp = head;
        while(temp!=null&&temp.next!=null){
            if(temp.next.data==x){
                temp.next = temp.next.next;
                if(temp.next!=null){
                    temp.next.prev = temp;
                }
            }else{
                temp=temp.next;
            }
        }
        return head;
    }
}