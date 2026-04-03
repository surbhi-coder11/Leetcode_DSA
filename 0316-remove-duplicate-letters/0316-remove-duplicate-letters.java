import java.util.Stack;

class Solution {
    public String removeDuplicateLetters(String s) {
        int[] lastIndex = new int[26];
        for (int i = 0; i < s.length(); i++) {
            lastIndex[s.charAt(i) - 'a'] = i; // Store the last position of each char
        }

        Stack<Character> stack = new Stack<>();
        boolean[] seen = new boolean[26]; // Track if char is already in the stack

        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            
            // If we already have this char in our result, skip it
            if (seen[curr - 'a']) continue;

            // While the stack isn't empty, 
            // AND the current char is smaller than the stack top,
            // AND the stack top appears again later in the string...
            while (!stack.isEmpty() && curr < stack.peek() && lastIndex[stack.peek() - 'a'] > i) {
                seen[stack.pop() - 'a'] = false;
            }

            stack.push(curr);
            seen[curr - 'a'] = true;
        }

        StringBuilder sb = new StringBuilder();
        for (char c : stack) sb.append(c);
        return sb.toString();
    }
}