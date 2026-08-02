class myStack {
        int[] stack;
        int i;

        public myStack(int n) {
            // Define Data Structures
            stack = new int[n];
            i = -1;
        }

        public boolean isEmpty() {
            // check if the stack is empty
            return i==-1;
        }

        public boolean isFull() {
            // check if the stack is full
            return i== stack.length-1;
        }

        public void push(int x) {
            // Inserts x at the top of the stack
            stack[++i] = x;
        }

        public void pop() {
            // Removes an element from the top of the stack
            if (i >= 0) {   // check underflow
                i--;
            }
        }

        public int peek() {
            // Returns the top element of the stack
            return i==-1?-1:stack[i];
        }
    }