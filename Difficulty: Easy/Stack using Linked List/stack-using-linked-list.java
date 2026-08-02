// Node class
/* class Node {
    int data;
    Node next;

    Node(int new_data) {
        data = new_data;
        next = null;
    }
} */

// Stack class
class myStack {
        Node head;
        int n;

        public myStack() {
            // Initialize your data members
            head = null;
            n = 0;
        }

        public boolean isEmpty() {
            // check if the stack is empty
            return head==null;
        }

        public void push(int x) {
            // Adds an element x at the rear of the stack.
            Node node = new Node(x);
            node.next = head;
            head = node;
            n++;
        }

        public void pop() {
            // Removes the front element of the stack.
            head = head.next;
            n--;
        }

        public int peek() {
            // Returns the front element of the stack.
            // If stack is empty, return -1.
            if (head == null)return -1;
            return head.data;
        }

        public int size() {
            // Returns the current size of the stack.
            return n;
        }
    }