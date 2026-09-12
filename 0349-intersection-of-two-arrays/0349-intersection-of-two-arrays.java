class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> s = new HashSet<>();
       // Set<Integer> s2 = new HashSet<>();
        for(int num : nums1){
            s.add(num);
        }
        ArrayList<Integer> ar = new ArrayList<>();
        for(int i=0;i<nums2.length;i++){
            if(s.contains(nums2[i])){
                ar.add(nums2[i]);
                s.remove(nums2[i]);
            }
        }
        int[] arr = new int[ar.size()];
        int i=0;
        for(Integer key : ar){
            arr[i]=key;
            i++;
        }
        return arr;
        //return Integer[] ar;
    }
}