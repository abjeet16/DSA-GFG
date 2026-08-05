/*
class Node {
    int data;
    Node next;

    Node(int d)
    {
        data = d;
        next = null;
    }
}*/

class Solution {
    public Node segregate(Node head) {
        if(head==null)return head;
        // code here
        Node zero = null;
        Node one = null;
        Node two = null;
        Node zhead = null;
        Node ohead = null;
        Node thead = null;
        
        while(head!=null){
            Node next = head.next;
            head.next = null;   // Break old link
            if(head.data==0){
                if(zero==null){
                    zero=head;
                    zhead = head;
                }else {
                    zero.next = head;
                    zero = zero.next;
                }
            }else if(head.data==1){
                if(one==null){
                    one=head;
                    ohead = head;
                }else {
                    one.next = head;
                    one = one.next;
                }
            }else{
                if(two==null){
                    two=head;
                    thead = head;
                }else {
                    two.next = head;
                    two = two.next;
                }
            }
            head = next;
        }
        if(zero!=null){
            if(ohead!=null){
                zero.next = ohead;
            }else{
                zero.next = thead;
            }
        }
        if(one!=null){
            one.next=thead;
        }
        if(zhead==null){
            return ohead!=null?ohead:thead;
        }
        return zhead;
    }
}