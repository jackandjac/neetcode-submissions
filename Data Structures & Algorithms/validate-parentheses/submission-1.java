class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c: s.toCharArray()){
            char rc = reverse(c);
            if (rc != '-') {
                stack.push(rc);
            } else {
                if (stack.isEmpty() || stack.pop() != c) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    private char reverse(char c) {
        char res = switch(c) {
            case '[' -> ']';
            case '(' -> ')';
            case '{' -> '}';
            default -> '-';
        };
        return res;
    }
}
