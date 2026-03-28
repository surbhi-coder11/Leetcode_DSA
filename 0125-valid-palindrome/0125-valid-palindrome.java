class Solution {
    public boolean isPalindrome(String s) {
        String ans = "";
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(ch>='A' && ch<='Z'){
                ans+=(char)(ch-'A'+'a');
            }else if(ch>='a' && ch<='z'){
                ans+=ch;
            }else if(ch>='0' && ch<='9'){
                ans+=ch;
            }
        }
        for(int i=0;i<ans.length();i++){
            int n= ans.length();
            if(ans.charAt(i)!=ans.charAt(n-i-1)){
                return false;
            }
        }
        // int i=0;
        // int j=ans.length()-1;
        // while(i<j){
        //     if(s.charAt(i) != s.charAt(j)){
        //         return false;
        //     }
        //     i++;
        //     j--;
        // }

        return true;

    }
}