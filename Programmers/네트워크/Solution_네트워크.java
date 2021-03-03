import java.util.ArrayList;

class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        int len = computers.length;
        ArrayList<Integer> list = new ArrayList<>();
        int[] visited = new int[len];
        
        for(int i=0; i<len; i++){
            if(visited[i] == 0)
                list.add(i);
            else continue;
            while(list.size() > 0){
                int idx = list.get(0);
                list.remove(0);
                visited[idx] = 1;
                for(int j=0; j<computers[idx].length; j++){
                    if(j != idx && computers[idx][j] == 1){
                        if(visited[j] == 0)
                            list.add(j);
                    }
                }
            }
            answer += 1;
        }
        return answer;
    }
}