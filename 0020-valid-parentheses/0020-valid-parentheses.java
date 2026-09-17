class Solution {
    public boolean isValid(String s) {

        if(s.length()%2 !=0){
            return false;
        }
        HashMap<Character,Character> hp = new HashMap<>();
        hp.put('}','{');
        hp.put(')','(');
        hp.put(']','[');

        Deque<Character> dq = new ArrayDeque<>();

        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(!hp.containsKey(ch)){
                dq.push(ch);
            }
            else{
                if(dq.isEmpty() || hp.get(ch)!=dq.pop()){
                    return false;
                }
            }

        }
        if(!dq.isEmpty()){
            return false;
        }
        return true;
    }
}