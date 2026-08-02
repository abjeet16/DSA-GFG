class Solution {
    public void sortStack(Stack<Integer> st) {
        // code here
        if (st.isEmpty())
            return;
        int val = st.pop();
        sortStack(st);
        push(st,val);
    }

    private void push(Stack<Integer> st, int val) {
        if (st.isEmpty()||val>=st.peek()) {
            st.push(val);
            return;
        }
        int curr = st.pop();
        push(st,val);
        st.push(curr);
    }
}