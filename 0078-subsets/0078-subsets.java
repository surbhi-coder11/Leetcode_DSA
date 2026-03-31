class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        int n = nums.length;
        List<List<Integer>> ans = new ArrayList<>();

        int subsets = (1<<n);
        for(int num =0;num<subsets;num++){
            List<Integer> res = new ArrayList<>();
            for(int i=0;i<n;i++){
                if((num &(1<<i))!=0){
                    res.add(nums[i]);
                }
            }
            ans.add(res);
        }
        return ans;
    }
}