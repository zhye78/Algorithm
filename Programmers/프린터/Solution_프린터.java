import java.util.*;

class Solution {
    public int getMax(Vector<Integer> arr){
        int max = arr.get(0);
        for(int i=1;i<arr.size();i++)
            if(max < arr.get(i))
                max = arr.get(i);
        return max;
    }
    
    public int solution(int[] priorities, int location) {
        int answer = 0;
        Vector<Integer> v = new Vector<Integer>();
        for(int i: priorities)
            v.add(i);
        
        while(v.size() > 0){
            if(location == 0){
                if(v.get(0) < getMax(v)){
                    v.add(v.get(0));
                    v.remove(0);
                    location = v.size() - 1;
                }else{
                    return answer + 1;
                }
            }else{
                if(v.get(0) < getMax(v)){
                    v.add(v.get(0));
                    v.remove(0);
                    location--;
                }else{
                    v.remove(0);
                    location--;
                    answer++;
                }
            }
        }
        return answer;
    }
}