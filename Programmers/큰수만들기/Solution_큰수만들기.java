import java.util.ArrayList;
import java.util.List;

class Solution {
    public String solution(String number, int k) {
        String answer = "";
        String[] arr = number.split("");
        List<Integer> list = new ArrayList<>();
        list.add(Integer.parseInt(arr[0]));
        
        int i;
        for(i=1; i<arr.length; i++){
            int now = Integer.parseInt(arr[i]);
            if(list.get(list.size()-1) >= now){
                list.add(now);
            }else{
                while(list.size() > 0 && list.get(list.size()-1) < now){
                    list.remove(list.size() - 1);
                    k--;
                    if(k == 0)
                        break;
                }
                list.add(now);
            }
            if(k == 0)
                break;
        }
        
        if(k > 0){
            list = list.subList(0, list.size() - k);
        }
        else{
            for(int j=i+1; j<arr.length; j++)
                list.add(Integer.parseInt(arr[j]));
        }
        
        for(int a : list)
            answer += Integer.toString(a);
        return answer;
    }
}