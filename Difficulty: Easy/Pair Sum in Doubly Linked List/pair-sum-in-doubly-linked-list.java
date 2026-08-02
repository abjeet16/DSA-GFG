/* Structure of Doubly Linked List Node
class Node {
    public int data;
    public Node next;
    public Node prev;

    public Node(int val) {
        data = val;
        next = null;
        prev = null;
    }
}; */

class Solution {
    public ArrayList<ArrayList<Integer>> givenSumPairs(Node head, int target) {
        // code here
        Node last = head;
        Node start = head;
        while(last.next!=null)
            last = last.next;
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        while(last!=start){
            int sum = last.data + start.data;
            if(sum == target){
                ArrayList<Integer> pair = new ArrayList<>();
                pair.add(start.data);
                pair.add(last.data);
                res.add(pair);
                start = start.next;
                if (start==last)
                    break;
                last = last.prev;
            }else if (sum>target){
                last = last.prev;
            }else {
                start = start.next;
            }
        }
        return res;
    }
}