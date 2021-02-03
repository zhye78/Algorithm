import java.util.ArrayList;
import java.util.Iterator;

class Solution {
    public int getSum(ArrayList list){
        int sum = 0;
        Iterator<Integer> it = list.iterator();
		while(it.hasNext())
			sum += it.next();
        return sum;
    }
    
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0;i<bridge_length;i++)
            list.add(0);
        
        int index = 0;
        while(list.size() > 0){
            answer++;
            list.remove(0);
            if(index < truck_weights.length){
                if(getSum(list) + truck_weights[index] <= weight){
                    list.add(truck_weights[index]);
                    index++;
                }
                else{
                    list.add(0);
                }
            }
        }
        return answer;
    }
}