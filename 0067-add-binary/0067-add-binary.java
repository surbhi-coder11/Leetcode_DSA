class Solution {
    public String addBinary(String a, String b) {
       int d = Math.abs(a.length()-b.length());
       if(a.length()<b.length()){
          for(int i=0;i<d;i++){
            a='0'+a;
          }
       }
       else{
        for(int i=0;i<d;i++){
            b='0'+b;
        }
       }
       String ans="";
       int n = a.length();
       int carry=0;
       for(int i=n-1;i>=0;i--){
          int b1= a.charAt(i)-'0';
          int b2= b.charAt(i)-'0';
          int res =(carry+b1+b2)%2;
          ans=res+ans;
          carry=(carry+b1+b2)/2;
       }
       if(carry>0){
        ans= carry+ans;
       }
       return ans;

    
   }
}