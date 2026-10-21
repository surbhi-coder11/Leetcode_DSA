class Solution {
    public long countSubarrays(int[] nums, int k, int m) {
        return countWithAtLeastDistinct(nums, k, m) - countWithAtLeastDistinct(nums, k + 1, m);
    }

    private long countWithAtLeastDistinct(int[] nums, int k, int m) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        long totalSubarrays = 0;
        int left = 0;
        int validElementsCount = 0; 

        for (int right = 0; right < nums.length; right++) {
            int num = nums[right];
            int newFreq = frequencyMap.merge(num, 1, Integer::sum);
            if (newFreq == m) {
                validElementsCount++;
            }

            // Correct condition depending on what 'k' represents:
            // If 'k' is the threshold for elements with frequency >= m:
            while (validElementsCount >= k) {
                // Add valid subarrays ending at 'right'
                totalSubarrays += (nums.length - right); // Or adjust based on your prefix counting logic
                
                int leftNum = nums[left++];
                int updatedFreq = frequencyMap.merge(leftNum, -1, Integer::sum);
                if (updatedFreq == m - 1) {
                    validElementsCount--;
                }
                if (updatedFreq == 0) {
                    frequencyMap.remove(leftNum);
                }
            }
        }

        return totalSubarrays;
    }
}