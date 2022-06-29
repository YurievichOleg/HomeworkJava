import java.util.ArrayList;
import java.util.*;

/*Для заданных n пар скобок напишите функцию, 
генерирующую все комбинации правильных скобок. */

public class Generate_Parentheses_22Leet {

    public static Set<String> permutationFinder(String str) {
        Set<String> perm = new HashSet<String>();
        if (str == null) {
            return null;
        } else if (str.length() == 0) {
            perm.add("");
            return perm;
        }
        char initial = str.charAt(0);
        String rem = str.substring(1);
        Set<String> words = permutationFinder(rem);
        for (String strNew : words) {
            for (int i = 0; i <= strNew.length(); i++) {
                perm.add(insertChar(strNew, initial, i));
            }
        }
        return perm;
    }

    public static String insertChar(String str, char c, int j) {
        String begin = str.substring(0, j);
        String end = str.substring(j);
        return begin + c + end;
    }

    public static boolean isValid(String s) {
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

    public static List<String> generateParenthesis(int n) {
        ArrayList<String> finishedCombination = new ArrayList<>();
        String firstRightCombination = "";
        for (int i = 0; i < n * 2; i++) {
            if (i % 2 == 0) {
                firstRightCombination += "(";
            } else {
                firstRightCombination += ")";
            }
        }
        Set<String> combination = permutationFinder(firstRightCombination);
        String[] combforeСhecking = {};
        combforeСhecking = combination.toArray(new String[combination.size()]);
        for (String comb : combforeСhecking) {
            if (isValid(comb)) {
                finishedCombination.add(comb);
            }
        }
        return finishedCombination;

    }

    public static void main(String[] args) {
        System.out.println(generateParenthesis(5));
    }

}
