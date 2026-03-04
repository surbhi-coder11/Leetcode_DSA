class Solution {
    public int minFlips(int a, int b, int c) {
        int flips = 0;
        
        for (int i = 0; i < 32; i++) {
            int bitA = (a >> i) & 1;
            int bitB = (b >> i) & 1;
            int bitC = (c >> i) & 1;
            
            if (bitC == 1) {
                if (bitA == 0 && bitB == 0) {
                    flips++;
                }
            } else {
                flips += bitA + bitB;
            }
        }
        
        return flips;
    }
}
