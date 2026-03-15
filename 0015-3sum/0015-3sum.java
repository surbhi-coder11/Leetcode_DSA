class Solution {
    public List<List<Integer>> threeSum(int[] nums) {

      //List<List<Integer>> ans = new ArrayList<>();
      Set<List<Integer>>  result = new HashSet<>();
      for(int i=0;i<nums.length;i++){
         Set<Integer> trip = new HashSet<>();
        for(int j=i+1;j<nums.length;j++){
            int target = -(nums[i] + nums[j]);
            if(trip.contains(target)){
               List<Integer> triplet = Arrays.asList(nums[i],nums[j] ,target);
               Collections.sort(triplet);
               result.add(triplet);
            }
            trip.add(nums[j]);
        }
      }
      return new ArrayList<>(result);
    //    // HashMap<List<Integer>, Integer> result = new HashMap<>();
    //     for(int i=0;i<nums.length;i++){
    //         for(int j=i+1;j<nums.length;j++){
    //             for(int k=j+1;k<nums.length;k++){
                   
    //                if(nums[i] + nums[j] + nums[k] ==0){
    //                 List<Integer> triplet = new ArrayList<>();
    //                 triplet.add(nums[i]);
    //                 triplet.add(nums[j]);
    //                 triplet.add(nums[k]);
    //                 Collections.sort(triplet);
    //                 if(!ans.contains(triplet)){
    //                     ans.add(triplet);
    //                 }
    //                }
                  
    //             }
                  
    //         }
    //     }
        

    //     // for(ArrayList<Integer> list : result){
    //     //     ans.add(list);
    //     // }
    //     return ans;
    }
}