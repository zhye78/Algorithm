import java.util.PriorityQueue;
import java.util.Collections;

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = {0,0};
        PriorityQueue<Integer> minq = new PriorityQueue<>();
        PriorityQueue<Integer> maxq = new PriorityQueue<>(Collections.reverseOrder());
        
        for(String op : operations){
            String[] arr = op.split(" ");
            
            switch(arr[0]){
                case "I":
                    minq.add(Integer.parseInt(arr[1]));
                    maxq.add(Integer.parseInt(arr[1]));
                    break;
                case "D":
                    if(minq.size() > 0){
                        if(arr[1].equals("1"))
                            minq.remove(maxq.poll());
                        else
                            maxq.remove(minq.poll());
                    }
                    break;
            }
        }
            
        if(minq.size() >= 2){
            answer[0] = maxq.poll();
            answer[1] = minq.poll();
        }
        return answer;
    }
}