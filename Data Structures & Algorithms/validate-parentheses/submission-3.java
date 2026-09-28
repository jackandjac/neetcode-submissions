class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c: s.toCharArray()){
            if ("([{".contains(String.valueOf(c))) {
                stack.push(convert(c));
            }else {
                if (!stack.isEmpty()) {
                    char pc = stack.pop();
                    if (pc != c) {
                        return false;
                    }
                } else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    private Character convert (Character c) {
        return switch(c) {
            case '[' -> ']';
            case '(' -> ')';
            case '{' -> '}';
            default -> null;
        };
    }
}
