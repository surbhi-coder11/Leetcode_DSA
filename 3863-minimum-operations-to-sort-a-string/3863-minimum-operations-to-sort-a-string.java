class Solution {
    public int minOperations(String s) {
        int n = s.length();
        if(n == 1) return 0;

        //impossible case -> -1
        if(n == 2 && s.charAt(0) > s.charAt(1)) return -1;
        
        char[] arr = s.toCharArray();
        Arrays.sort(arr);
        
        //already sorted -> 0
        int i = 0;
        while(i<n && s.charAt(i) == arr[i]) i++;
        if(i == n) return 0;

        //possible answer is 1
        if(s.charAt(0) == arr[0] || s.charAt(n-1) == arr[n-1]) return 1;

        //possible answer is 3 
        if(s.charAt(0) == arr[n-1] && s.charAt(n-1) == arr[0]){
            if(arr[0] == arr[1] || arr[n-1] == arr[n-2]) return 2;
            return 3;
        } 
        return 2;
    }
}