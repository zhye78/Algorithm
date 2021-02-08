import java.util.*;
import java.lang.Math;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> answer = new ArrayList<Integer>();
        int cnt = 1;
        int day = (int)Math.ceil(((double)100 - progresses[0]) / speeds[0]);
        for(int i=1;i<progresses.length;i++){
            if((int)Math.ceil(((double)100 - progresses[i]) / speeds[i]) > day){
                day = (int)Math.ceil(((double)100 - progresses[i]) / speeds[i]);
                answer.add(cnt);
                cnt = 1;
            }else{
                cnt++;
            }
        }
        answer.add(cnt);
        
        int[] arr = new int[answer.size()];
        for(int i=0;i<answer.size();i++){
            arr[i] = answer.get(i);
        }
        return arr;
    }
}