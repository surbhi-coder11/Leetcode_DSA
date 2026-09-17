import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public String simplifyPath(String path) {
        // Step 1: '/' ke basis par split karo
        String[] components = path.split("/");
        Deque<String> stack = new ArrayDeque<>();

        // Step 2: Tokens ko process karo
        for (String comp : components) {
            // Rule 1 & 3: Empty string ya "." ko skip karo
            if (comp.isEmpty() || comp.equals(".")) {
                continue;
            }
            // Rule 2: ".." aane par pichli directory pop karo
            if (comp.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                // Normal directory name: push to stack
                stack.push(comp);
            }
        }

        // Step 3: Agar stack empty hai, toh answer root "/" hai
        if (stack.isEmpty()) {
            return "/";
        }

        // Step 4: Path rebuild karo (bottom to top)
        StringBuilder result = new StringBuilder();
        // Deque me descendingIterator() bottom-to-top traverse karta hai
        var it = stack.descendingIterator();
        while (it.hasNext()) {
            result.append("/").append(it.next());
        }

        return result.toString();
    }
}