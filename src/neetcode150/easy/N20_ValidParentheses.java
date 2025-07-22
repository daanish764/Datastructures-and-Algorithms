package neetcode150.easy;


import java.util.Stack;


public class N20_ValidParentheses {


    public static boolean isValid(String s) {

        Stack<Character> stack = new Stack<>();

        for(char c : s.toCharArray()) {
            if(c == '[' || c  == '{' || c == '(') {
                stack.push(c);
            }
            else {
                if(stack.isEmpty()) return false;
                char top = stack.pop();
                if(c == ']' && top != '[') return false;
                if(c == '}' && top != '{') return false;
                if(c == ')' && top != '(') return false;
            }
        }

        return stack.isEmpty();
    }


    public static void main(String[] args) {
        String s = null;

        s = "()";
        System.out.println(s + "\t" +isValid(s));

        s = "(){}[]";
        System.out.println(s + "\t" +isValid(s));

        s = "([{}])";
        System.out.println(s + "\t" +isValid(s));

        s = "({}])";
        System.out.println(s + "\t" +isValid(s));

        s = "({$})";
        System.out.println(s + "\t" +isValid(s));

        s = "}";
        System.out.println(s + "\t" +isValid(s));



    }
}
