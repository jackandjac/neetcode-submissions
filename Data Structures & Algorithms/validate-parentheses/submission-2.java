class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack();
        for (char c: s.toCharArray()){
            if (contains(c)){
                stack.push(reverse(c));
            } else {
                if (stack.isEmpty()){
                    return false;
                }
                char rc = stack.pop();
                if (rc != c) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
    private boolean contains(char c) {
       return switch(c){
            case '[', '(', '{' -> true;
            default -> false;
        };
    }

    private char reverse(char c) {
        return switch(c) {
            case '[' -> ']';
            case '(' -> ')';
            case '{' -> '}';
            default -> '#';
        };
    }
}
