class Solution {
    boolean solution(String s) {
        int open = 0;
        int close = 0;
        
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == '('){
                open++;
            }else{
                if(open > close) close++;
                else return false;
            }
        }
        
        if(open == close) return true;
        else return false;
    }
}