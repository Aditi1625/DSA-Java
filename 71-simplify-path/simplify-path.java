import java.util.Deque;
import java.util.LinkedList;

class Solution {
    public String simplifyPath(String path) {
        // Split the path by one or more consecutive slashes '/'
        String[] components = path.split("/+");
        Deque<String> stack = new LinkedList<>();
        
        for (String dir : components) {
            // If the component is empty or a single dot '.', it means current directory, so skip
            if (dir.isEmpty() || dir.equals(".")) {
                continue;
            }
            // If the component is a double dot '..', move up one directory level if possible
            if (dir.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.removeLast();
                }
            } else {
                // It is a valid directory name, push it to the stack
                stack.addLast(dir);
            }
        }
        
        // Rebuild the simplified canonical path
        StringBuilder result = new StringBuilder();
        for (String dir : stack) {
            result.append("/").append(dir);
        }
        
        // If the stack was empty, return the root directory "/"
        return result.length() == 0 ? "/" : result.toString();
    }
}
