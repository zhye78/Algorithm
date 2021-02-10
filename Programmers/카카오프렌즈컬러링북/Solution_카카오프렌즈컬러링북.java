import java.util.*;

class Solution {
  public int[] solution(int m, int n, int[][] picture) {
      int[] answer = new int[2];
      int numberOfArea = 0;
      int maxSizeOfOneArea = 0;
      int count = 0;
      int[][] visited = new int[m][n];
      Vector<Integer> v = new Vector<Integer>();
      int color = 0;
      int x = 0;
      int y = 0;
      
      for(int i=0; i<m; i++){
          for(int j=0; j<n; j++){
              if(picture[i][j] == 0){
                  visited[i][j] = 1;
                  continue;
              }
              else{
                  if(visited[i][j] == 0){
                      v.add(i);
                      v.add(j);
                      while(!v.isEmpty()){
                          x = v.get(0);
                          y = v.get(1);
                          if(visited[x][y] == 0){
                              count++;
                              color = picture[x][y];
                              if(y < n-1 && color == picture[x][y+1]){
                                  v.add(x);
                                  v.add(y+1);
                              }
                              if(x < m-1 && color == picture[x+1][y]){
                                  v.add(x+1);
                                  v.add(y);
                              }
                              if(y > 0 && color == picture[x][y-1]){
                                  v.add(x);
                                  v.add(y-1);
                              }
                              if(x > 0 && color == picture[x-1][y]){
                                  v.add(x-1);
                                  v.add(y);
                              }
                              visited[x][y] = 1;
                          }
                          v.remove(0);
                          v.remove(0);
                      }
                      numberOfArea++;
                      if(maxSizeOfOneArea < count) maxSizeOfOneArea = count;
                      count = 0;
                  }
              }
          }
      }
      //System.out.println(numberOfArea);
      //System.out.println(maxSizeOfOneArea);
     
      answer[0] = numberOfArea;
      answer[1] = maxSizeOfOneArea;
      return answer;
  }
}