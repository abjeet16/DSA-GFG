/*
class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }
}
*/

class Solution {
    public int lengthOfLoop(Node head) {
        if (head == null || head.next == null)
            return 0;

        Node slow = head;
        Node fast = head;

        // Step 1: Detect loop
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast)
                break;
        }

        // No loop
        if (fast == null || fast.next == null)
            return 0;

        // Step 2: Count loop length
        int count = 1;
        fast = fast.next;
        while (fast != slow) {
            count++;
            fast = fast.next;
        }

        return count;
    }
}