class Solution {
    public static void reverseStack(Stack<Integer> st) {
        // code here
        if(st.isEmpty())
            return;
        int val = st.pop();
        reverseStack(st);
        push(st,val);
    }

    private static void push(Stack<Integer> st, int val) {
        if (st.isEmpty()){
            st.push(val);
            return;
        }
        int curr = st.pop();
        push(st,val);
        st.push(curr);
    }
}
