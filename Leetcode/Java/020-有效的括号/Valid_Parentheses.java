import java.util.Scanner;
import java.util.Stack;

/**
 * @Description:Parentheses matching
 * @author:milk
 */
public class Solution {
    public static boolean isValid(String s) {
        if (s.length() % 2 == 1) {
            return false;
        }
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if (stack.isEmpty())
                    return false;
                char top = stack.peek();
                if ((top == '{' && c == '}') || (top == '[' && c == ']') || (top == '(' && c == ')'))
                    stack.pop();
                else
                    return false;
            }
        }
        return stack.isEmpty();
    }

    /** test the examples. */
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();
        String input = string.substring(1,string.length()-1);
        System.out.println(isValid(input));
    }
}
