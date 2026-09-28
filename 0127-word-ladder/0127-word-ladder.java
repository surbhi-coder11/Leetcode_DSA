import java.util.List;
import java.util.Set;
import java.util.HashSet;
import java.util.Queue;
import java.util.LinkedList;

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) {
            return 0;
        }

        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        
        // Mark visited on enqueue by removing from the set
        wordSet.remove(beginWord);
        
        int level = 1;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                String curr = queue.poll();

                if (curr.equals(endWord)) {
                    return level;
                }

                char[] chars = curr.toCharArray();
                for (int j = 0; j < chars.length; j++) {
                    char originalChar = chars[j];

                    for (char c = 'a'; c <= 'z'; c++) {
                        if (c == originalChar) continue;
                        chars[j] = c;
                        String nextWord = new String(chars);

                        if (wordSet.contains(nextWord)) {
                            wordSet.remove(nextWord); // Mark visited on push
                            queue.offer(nextWord);
                        }
                    }
                    chars[j] = originalChar; // Restore
                }
            }
            level++;
        }

        return 0;
    }
}