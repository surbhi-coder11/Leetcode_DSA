class Solution {
    public long countCommas(long n) {
        long count = 0;
        long min = 1000;
        int comm = 1;
        while(n>=min){
            long max = min*1000-1;
            long high = Math.min(n, max);

            count+=(high - min +1)*comm;

            min*=1000;
            comm = comm+1;
        }
        return count;
        
    }
}