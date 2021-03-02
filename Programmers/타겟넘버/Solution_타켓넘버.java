import java.util.ArrayList;

class Solution {
    public int solution(int[] numbers, int target) {
        int answer = 0;
        ArrayList<Integer> stack = new ArrayList<Integer>();
        ArrayList<Integer> sub = new ArrayList<Integer>();
        stack.add(0);
        
        for(int i=0; i < numbers.length; i++){
            sub.clear();
            for(int j=0; j < stack.size(); j++){
                sub.add(stack.get(j) + numbers[i]);
                sub.add(stack.get(j) - numbers[i]);
            }
            stack.clear();
            stack.addAll(sub);
        }
        
        for(int i : sub)
            if(i == target)
                answer++;
        return answer;
    }
}