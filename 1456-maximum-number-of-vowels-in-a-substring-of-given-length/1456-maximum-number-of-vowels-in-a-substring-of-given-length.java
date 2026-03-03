class Solution {
    public int maxVowels(String s, int k) {
        int maxCount = 0;
        int currentCount = 0;
        
        for (int i = 0; i < s.length(); i++) {
            
            if (isVowel(s.charAt(i))) {
                currentCount++;
            }
            
            if (i >= k && isVowel(s.charAt(i - k))) {
                currentCount--;
            }
            
            if (i >= k - 1) {
                maxCount = Math.max(maxCount, currentCount);
            }
        }
        
        return maxCount;
    }
    
    private boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || 
               c == 'o' || c == 'u';
    }
}
