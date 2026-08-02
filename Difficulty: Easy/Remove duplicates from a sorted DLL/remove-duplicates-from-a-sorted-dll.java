/*
class Node{
    int data;
    Node next, prev;
    Node(int x){
        this.data = x;
        this.next = null;
        this.prev = null;
    }
}
*/
class Solution {
    Node removeDuplicates(Node head) {
        // Code Here.
        Node curr = head;
        while (curr!=null){
            Node nxt = curr.next;
            while (nxt!=null&&nxt.data==curr.data)
                nxt = nxt.next;
            curr.next = nxt;
            if (nxt!=null)
                nxt.prev = curr;
            curr = nxt;
        }
        return head;
    }
}