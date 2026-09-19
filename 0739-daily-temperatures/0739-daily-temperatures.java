class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] ans = new int[temperatures.length];

        HashMap<Integer,Integer> hp = new HashMap<>();
        Deque<Integer> stack = new ArrayDeque<>();

        for(int i=0;i<temperatures.length;i++){
            int curr = temperatures[i];

            while(!stack.isEmpty() && curr > temperatures[stack.peek()]){
                hp.put(stack.pop(),i);
            }
            stack.push(i);
        }



        for(int i=0;i<ans.length;i++){
            int curr = temperatures[i];
            if(!hp.containsKey(i)){
                ans[i] = 0;
            }else{
                 ans[i] = hp.get(i)-i;
            }
           
        }

        return ans;

    }
}