import java.util.ArrayList;

class Solution {
    public boolean check(String s){ //올바른 괄호 문자열이면 true
        int open = 0;
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == '(')
                open++;
            else
                open--;
            if(open < 0)
                return false;
        }
        return true;
    }
    
    public String solution(String p) {
        if(p == "") return "";
        
        String u = "";
        String v = "";
        int open = 0;
        int close = 0;
        for(int i=0; i<p.length(); i++){
            if(p.charAt(i) == '(')
                open++;
            else
                close++;
            u += p.charAt(i);
            if(open == close){
                if(i < p.length() - 1)
                    v = p.substring(i+1, p.length());
                break;
            }
        }
        
        if(check(u)){
            return u + solution(v);
        }else{
            String str = "(";
            str += solution(v);
            str += ")";
            u = u.substring(1, u.length() - 1);
            for(int i=0; i<u.length(); i++){
                if(u.charAt(i) == '(')
                    str += ")";
                else
                    str += "(";
            }
            return str;
        }
    }
}