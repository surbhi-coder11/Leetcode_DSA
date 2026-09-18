import java.util.*;

class Solution {
    public List<String> maxNumOfSubstrings(String s) {
        int n = s.length();
        int[] first = new int[26];
        int[] last = new int[26];
        Arrays.fill(first, -1);
        Arrays.fill(last, -1);

        // Har character ka first aur last index note karo
        for (int i = 0; i < n; i++) {
            int ch = s.charAt(i) - 'a';
            if (first[ch] == -1) {
                first[ch] = i;
            }
            last[ch] = i;
        }

        List<int[]> intervals = new ArrayList<>();

        // Har unique character ke liye valid interval dhoondo
        for (int i = 0; i < 26; i++) {
            if (first[i] == -1) continue;

            int left = first[i];
            int right = last[i];
            boolean isValid = true;

            for (int j = left; j <= right; j++) {
                int ch = s.charAt(j) - 'a';
                // Agar interval ke andar koi aisa char hai jo left se pehle start hota hai,
                // toh ye interval 'left' se start hone par valid nahi ban sakta
                if (first[ch] < left) {
                    isValid = false;
                    break;
                }
                right = Math.max(right, last[ch]);
            }

            if (isValid) {
                intervals.add(new int[]{left, right});
            }
        }

        // Greedy approach: Intervals ko unke end index ke hisaab se sort karo
        intervals.sort(Comparator.comparingInt(a -> a[1]));

        List<String> result = new ArrayList<>();
        int prevEnd = -1;

        // Non-overlapping intervals pick karo
        for (int[] interval : intervals) {
            int start = interval[0];
            int end = interval[1];

            if (start > prevEnd) {
                result.add(s.substring(start, end + 1));
                prevEnd = end;
            }
        }

        return result;
    }
}