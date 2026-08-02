class Solution {
    public static String infixToPrefix(String s) {
        s = revInfix(s);          // Step 1: Reverse infix & swap brackets
        s = infixToPostfix(s);    // Step 2: Convert to postfix
        s = revInfix(s);          // Step 3: Reverse postfix -> prefix
        return s;
    }

    // Reverse string and swap brackets
    private static String revInfix(String s) {
        StringBuilder res = new StringBuilder();

        for (int i = s.length() - 1; i >= 0; i--) {
            char ch = s.charAt(i);

            if (ch == '(') ch = ')';
            else if (ch == ')') ch = '(';

            res.append(ch);
        }
        return res.toString();
    }

    // Convert infix to postfix (used for prefix conversion)
    private static String infixToPostfix(String exp) {
        Stack<Character> stack = new Stack<>();
        StringBuilder res = new StringBuilder();

        for (char ch : exp.toCharArray()) {

            if (Character.isLetterOrDigit(ch)) {
                res.append(ch);
            }

            else if (ch == '(') {
                stack.push(ch);
            }

            else if (ch == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    res.append(stack.pop());
                }
                if (!stack.isEmpty()) stack.pop();
            }

            else if (isOperator(ch)) {

                while (!stack.isEmpty() && isOperator(stack.peek()) &&
                      (precedence(stack.peek()) > precedence(ch) ||
                      (precedence(stack.peek()) == precedence(ch) && ch == '^'))) {

                    res.append(stack.pop());
                }

                stack.push(ch);
            }
        }

        while (!stack.isEmpty()) {
            res.append(stack.pop());
        }

        return res.toString();
    }

    private static boolean isOperator(char ch) {
        return ch == '+' || ch == '-' ||
               ch == '*' || ch == '/' ||
               ch == '^';
    }

    private static int precedence(char ch) {
        if (ch == '^') return 3;
        if (ch == '*' || ch == '/') return 2;
        if (ch == '+' || ch == '-') return 1;
        return -1;
    }

}