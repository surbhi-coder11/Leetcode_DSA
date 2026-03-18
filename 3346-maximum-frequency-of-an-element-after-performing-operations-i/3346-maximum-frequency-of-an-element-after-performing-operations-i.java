class Solution {
    public int maxFrequency(int[] nums, int k, int numOperations) {
        int n = nums.length;
        Arrays.sort(nums);

        Map<Integer,Integer> hp = new HashMap<>();
        TreeSet<Integer> ts = new TreeSet<>();

        for(int x : nums){
            hp.put(x,hp.getOrDefault(x,0)+1);
            ts.add(x);
            ts.add(x+k);
            ts.add(x-k);
        }
        int maxfreq =0;
        int left =0;
        int right =0;
        for(int v : ts){
            while(right<n && nums[right] <= v+k){
               right++;
            }
            while(left< n && nums[left]< v-k){
                left++;
            }
            int rge = right - left ;
            int orig = hp.getOrDefault(v,0);
            int adjustable = rge - orig;
            maxfreq = Math.max(maxfreq , orig+Math.min(adjustable,numOperations));
        }
       return maxfreq;
    }
}