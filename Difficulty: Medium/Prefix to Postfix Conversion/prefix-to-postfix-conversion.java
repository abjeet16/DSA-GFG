// User function Template for Java

class Solution {
        static String preToPost(String pre_exp) {
        // code here
        Stack<String> stack = new Stack<>();
        for (int i = pre_exp.length()-1;i >=0 ;i--){
            char ch = pre_exp.charAt(i);
            String exp = ch+"";
            if (isOperator(ch)){
                exp = stack.pop()+stack.pop()+ch;
            }
            stack.push(exp);
        }
        return stack.pop();
    }
    private static boolean isOperator(char ch){
        return ch=='^'||ch=='*'||ch=='/'||ch=='+'||ch=='-';
    }
}
