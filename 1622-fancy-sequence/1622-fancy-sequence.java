class Fancy {
    List<Long> arr ;
    long add =0;
    long mul =1;
    int Mod = 1000000007;

    public Fancy() {
        arr = new ArrayList<>();
    }
    
    public void append(int val) {
        Long x = (val - add +Mod)%Mod;
        x = (x * reversepow(mul))%Mod;
        arr.add(x);
    }
    
    public void addAll(int inc) {
        add = (add+ inc)%Mod;
    }
    
    public void multAll(int m) {
        mul = (mul*m)%Mod;
        add = (add*m)%Mod;
    }
    
    public int getIndex(int idx) {
        if(idx>= arr.size()){
            return -1;
        }
        Long ans = arr.get(idx);
        return (int)((ans*mul+add)%Mod);
    }
    private long reversepow(Long val){
        return pow(val,Mod-2);
    }
    private long pow(Long val , int n){
        long ans = 1;

        while(n>0){
            if(n%2==1){
                ans =( ans*val)%Mod;
            }
            val = (val*val)%Mod;
            n = n/2;
        }
        return ans;
    }
}

/**
 * Your Fancy object will be instantiated and called as such:
 * Fancy obj = new Fancy();
 * obj.append(val);
 * obj.addAll(inc);
 * obj.multAll(m);
 * int param_4 = obj.getIndex(idx);
 */