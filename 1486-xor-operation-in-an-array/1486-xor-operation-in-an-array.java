class Solution {
    public int xorOperation(int n, int start) {
        int[] xor = new int[n];
        for(int i=0;i<n;i++){
            xor[i] = start + 2*i;
        }

        int x =0;
        for(int i=0;i<xor.length;i++){
            x=x^xor[i];
        }
       return x;
    }
}