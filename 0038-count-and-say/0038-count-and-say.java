class Solution {
    public String countAndSay(int n) {
        if(n<=0){
            return "";
        }
        String result ="1";
        for(int step=1;step<n;step++){
            int i=0;
            StringBuilder sb = new StringBuilder();
            while(i<result.length()){
                char ch = result.charAt(i);
                int count =0;
                while(i<result.length() && ch == result.charAt(i)){
                    count++;
                    i++;
                }
                sb.append(count).append(ch);
   
            }
            result = sb.toString();

        }
        return result;
    }
}