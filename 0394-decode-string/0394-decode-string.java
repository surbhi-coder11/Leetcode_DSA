class Solution {
    public String decodeString(String s) {
        Stack<Integer> count = new Stack<>();
        Stack<StringBuilder> curr = new Stack<>();

        StringBuilder sb = new StringBuilder();
        int k=0;

        for(char ch : s.toCharArray()){
            if(Character.isDigit(ch)){
                k = k*10 + (ch - '0');
            }else if(ch == '['){
                curr.push(sb);
                count.push(k);
                sb = new StringBuilder();
                k=0;
            }else if(ch == ']'){
                StringBuilder decoded = curr.pop();
                int rem = count.pop();

                while(rem-->0){
                    decoded.append(sb);
                }

                sb = decoded;
            }
            else{
                sb.append(ch);
            }
        }

        return sb.toString();
    }
}