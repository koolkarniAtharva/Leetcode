import java.util.*;
class Solution {
    public String simplifyPath(String path) {
        String[] arr = path.split("/");
        Deque<String> stack = new ArrayDeque<>();
        for (String s : arr) {
            if (s.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else if (!s.equals(".") && !s.equals("")) {
                stack.push(s);
            }
        }
        if (stack.isEmpty()) {
            return "/";
        }
        StringBuilder res = new StringBuilder();
        while (!stack.isEmpty()) {
            res.insert(0, "/" + stack.pop());
        }
        return res.toString();
    }
}