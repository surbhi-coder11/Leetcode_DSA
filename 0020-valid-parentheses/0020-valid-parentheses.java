import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;

class Solution {
    public boolean isValid(String s) {
        // Odd length strings kabhi valid nahi ho sakti
        if (s.length() % 2 != 0) {
            return false;
        }

        // Key: Closer -> Value: Matching Opener
        HashMap<Character, Character> rule = new HashMap<>();
        rule.put(')', '(');
        rule.put(']', '[');
        rule.put('}', '{');

        Deque<Character> st = new ArrayDeque<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            // Agar ch closer nahi hai (matlab opener hai), toh push karo
            if (!rule.containsKey(ch)) {
                st.push(ch);
            } else {
                // Closer aane par: empty stack check aur type mismatch check
                if (st.isEmpty() || st.pop() != rule.get(ch)) {
                    return false;
                }
            }
        }

        // Aakhiri mein stack khali hona chahiye
        return st.isEmpty();
    }
}