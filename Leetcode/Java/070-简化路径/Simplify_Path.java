import java.util.LinkedList;
import java.util.Scanner;

/**
 * @Description:simplify-path
 * @author:milk
 */
public class Solution {
    public static String simplifyPath(String path) {
        LinkedList<String> stack = new LinkedList<>();

        /** split according to '/' */
        for (String item : path.split("/")){
            if(item.equals("..")){
                if(!stack.isEmpty())
                    stack.pop();
            }
            else if(!item.isEmpty() && !item.equals("."))
                stack.push(item);
        }

        /** reverse connection */
        String ans = "";
        for (int i = stack.size() - 1; i >= 0; i--) {
            ans = ans + '/' + stack.get(i);
        }
        return ans.isEmpty() ? "/" : ans;
    }

    /** test the examples. */
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();
        String input = string.substring(1,string.length()-1);
        System.out.println(simplifyPath(input));
    }
}
