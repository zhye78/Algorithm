import java.util.ArrayList;

class Solution {
    public int solution(int n, int[][] edge) {
        int answer = 0;
        int[] arr = new int[n+1];
        int[] visited = new int[n+1];
        ArrayList<Integer> stack = new ArrayList<>();
        ArrayList<Integer> sub = new ArrayList<>();
        stack.add(1);
        visited[1] = 1;
        int count = 0;
        
        while(stack.size() > 0){
            sub.clear();
            for(int i=0;i<edge.length;i++){
                if(visited[edge[i][0]] != 1 || visited[edge[i][1]] != 1){
                    if(stack.contains(edge[i][0])){
                        sub.add(edge[i][1]);
                    }
                    else if(stack.contains(edge[i][1])){
                        sub.add(edge[i][0]);
                    }
                }
            }
            count++;
            stack.clear();
            stack.addAll(sub);
            while(sub.size() > 0){
                int num = sub.get(0);
                sub.remove(0);
                if(visited[num] == 0){
                    arr[num] = count;
                    visited[num] = 1;
                }
            }
        }
        
        int max = 0;
        for(int a:arr)
            if(a >= max) max = a;
        for(int a:arr)
            if(a == max) answer++;
        return answer;
    }
}