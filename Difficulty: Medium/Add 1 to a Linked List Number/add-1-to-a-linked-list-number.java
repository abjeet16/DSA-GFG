/* Structure of linked list Node
class Node{
    int data;
    Node next;

    Node(int x){
        data = x;
        next = null;
    }
}
*/
class Solution {
    public Node addOne(Node head) {
        // code here.
        int carry = ans(head.next);
        head.data+=carry;
        return head;
    }
    private int ans(Node head){
        if(head==null)return 1;
        if(head.next==null){
            if(head.data==9){
                head.data=0;
                return 1;
            }else{
                head.data+=1;
                return 0;
            }
        }
        int carry = ans(head.next);
        if(carry==1){
            if(head.data==9){
                head.data=0;
                return 1;
            }else{
                head.data+=1;
            }
        }
        return 0;
    }
}