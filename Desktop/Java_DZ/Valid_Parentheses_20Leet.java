import java.util.*;


public class Valid_Parentheses_20Leet {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> charMap = Map.of('(', ')', '[', ']', '{', '}');
        for (int i = 0; i < s.length(); i++) {
            if (charMap.containsKey(s.charAt(i))) {
                stack.push(s.charAt(i));
            } else {
                if (stack.isEmpty() || charMap.get(stack.peek()) != s.charAt(i)) {
                    return false;
                }
                stack.pop();
            }
        }
        return stack.isEmpty();  
    }
    
}
