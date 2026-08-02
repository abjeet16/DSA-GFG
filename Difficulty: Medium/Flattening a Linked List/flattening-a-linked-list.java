/*
class Node {
    int data;
    Node next;
    Node bottom;

    Node(int x) {
        data = x;
        next = null;
        bottom = null;
    }
}
*/

class Solution {
    public Node flatten(Node root) {
        if (root == null) return null;

        PriorityQueue<Node> pq =
            new PriorityQueue<>((a, b) -> a.data - b.data);

        Node curr = root;
        while (curr != null) {
            pq.offer(curr);
            curr = curr.next;
        }

        Node dummy = new Node(0);
        Node tail = dummy;

        while (!pq.isEmpty()) {
            Node node = pq.poll();

            tail.bottom = node;
            tail = tail.bottom;
            tail.next = null;

            if (node.bottom != null) {
                pq.offer(node.bottom);
            }
        }

        return dummy.bottom;
    }
}