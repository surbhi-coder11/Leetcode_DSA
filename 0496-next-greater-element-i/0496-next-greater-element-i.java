class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> hp = new HashMap<>();
        Deque<Integer> dq = new ArrayDeque<>();
        for(int num : nums2){
            while(!dq.isEmpty() && num> dq.peek()){
                hp.put(dq.pop(),num);
            }
            dq.push(num);
        }

        while(!dq.isEmpty()){
            hp.put(dq.pop(),-1);
        }
       int[] ans = new int[nums1.length];
        for(int i=0;i<nums1.length;i++){
           ans[i] = hp.get(nums1[i]);
        }

        return ans;
    }
}