class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer,Integer> hp = new HashMap<>();

        for(int i=0;i<nums1.length;i++){
            hp.put(nums1[i],hp.getOrDefault(nums1[i],0)+1);
        }

        ArrayList<Integer> ar = new ArrayList<>();
        for(int num: nums2){
            if(hp.containsKey(num) && hp.get(num)>0){
                ar.add(num);
                hp.put(num,hp.get(num)-1);
            }
        }
        int[] res = new int[ar.size()];
        int i=0;
        for(Integer key : ar){
            res[i]=key;
            i++;
        }
        return res;

        // HashMap<Integer,Integer> hp2 = new HashMap<>();
        // for(int i=0;i<nums1.length;i++){
        //     if(hp1.containsKey(nums1[i])){
        //         hp1.put(nums1[i],hp1.get(nums1[i])+1);
        //     }
        //     else{
        //        hp1.put(nums1[i],1);
        //     } 
        // }
        // for(int i=0;i<nums2.length;i++){
        //     if(!hp2.containsKey(nums2[i])){
        //         hp2.put(nums2[i],hp2.get(nums2[i])+1);
        //     }
        //     else{
        //        hp2.put(nums2[i],1);
        //     } 
        // }
       // int min = Math.min(nums1.length,nums2.length);
        
    }
}