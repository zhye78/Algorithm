class Solution {
    public long gcd(int num1, int num2){
        if(num2 == 0) return num1;
        else return gcd(num2, num1 % num2);
    }
    
    public long solution(int w, int h) {
        long entire = (long)w * (long)h;
        long n = gcd(w,h);
        return entire - n * ((w/n) + (h/n) - 1);
    }
}