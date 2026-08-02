// Node class
    class Node {
        int data;
        Node next;

        Node(int new_data) {
            data = new_data;
            next = null;
        }
    }

    // Queue class
    class myQueue {
        Node head;
        Node tail;
        int n;
        public myQueue() {
            // Initialize your data members
            head = null;
            tail = null;
            n = 0;
        }

        public boolean isEmpty() {
            // check if the queue is empty
            return n==0;
        }

        public void enqueue(int x) {
            // Adds an element x at the rear of the queue.
            if (isEmpty()){
                Node node = new Node(x);
                head = node;
                tail = node;
            }else {
                Node node = new Node(x);
                tail.next = node;
                tail = node;
            }
            n++;
        }

        public void dequeue() {
            // Removes the front element of the queue
            head = head.next;
            n--;
        }

        public int getFront() {
            // Returns the front element of the queue.
            // If queue is empty, return -1.
            return n==0?-1:head.data;
        }

        public int size() {
            // Returns the current size of the queue.
            return n;
        }
    }