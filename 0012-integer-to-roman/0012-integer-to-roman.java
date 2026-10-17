class Solution {
    public String intToRoman(int num) {
         int total =0;
         int i =0;
         while
         (i<num){
            int cur = value(s.charAt(i));
            if (i + 1 < num && cur < value(s.charAt(i + 1))) {
                total += (value(s.charAt(i + 1)) - cur);
                i += 2; 
            } else {
                total += cur;
                i += 1; 
            }
         }
    }
    private int Value(char ch){
        switch (ch){
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: return 0;
        }
    }
}