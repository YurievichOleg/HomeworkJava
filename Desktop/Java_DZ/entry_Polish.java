import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/*Оцените значение арифметического выражения в обратной польской записи.

Допустимые операторы +, -, * и /. 
Каждый операнд может быть целым числом или другим выражением.

Обратите внимание, что деление между двумя целыми числами должно усекаться до нуля.

Гарантируется, что заданное выражение RPN всегда допустимо. 
Это означает, что выражение всегда будет возвращать результат, и операции деления на ноль не будет. */

public class entry_Polish {

    public static int operation(String valueA, String value2, String operator) {
        int a = Integer.parseInt(valueA);
        int b = Integer.parseInt(value2);
        switch (operator) {
            case ("+"):
                return a + b;

            case ("-"):
                return a - b;

            case ("*"):
                return a * b;

            case ("/"):
                return a / b;
            default:
                return -1;

        }
    }

    public static int evalRPN(String[] tokens) {
        Set<String> operations = Set.of("+", "-", "*", "/");
        Stack<String> stack = new Stack<>();

        for (String token : tokens) {
            if (operations.contains(token)) {
                String valueB = stack.pop();
                String valueA = stack.pop();
                stack.push(Integer.toString(operation(valueA, valueB, token)));
            } else {
                stack.push(token);
            }
        }
        return Integer.parseInt(stack.pop());

    }

    public static void main(String[] args) {
        String[] arr = new String[] { "2", "1", "+", "3", "*" };
        System.out.println(evalRPN(arr));
    }

}
