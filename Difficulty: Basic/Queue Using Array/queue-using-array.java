class myQueue {
    int[] q;
    int f, r, size, capacity;

    // Constructor
    public myQueue(int n) {
        capacity = n;
        q = new int[n];
        f = 0;
        r = -1;
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == capacity;
    }

    public void enqueue(int x) {
        if (isFull()) return;

        r = (r + 1) % capacity;
        q[r] = x;
        size++;
    }

    public void dequeue() {
        if (isEmpty()) return;

        f = (f + 1) % capacity;
        size--;
    }

    public int getFront() {
        if (isEmpty()) return -1;
        return q[f];
    }

    public int getRear() {
        if (isEmpty()) return -1;
        return q[r];
    }
}