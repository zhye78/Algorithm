import java.util.ArrayList;
import java.lang.Math;

class Solution
{
    public int solution(int [][]board)
    {
        int row = board.length; //행
        int col = board[0].length; //열
        int min = 0;
        int maxVal = 0;
        int count = 0;
        
        for(int i=0; i<row; i++)
            for(int j=0; j<col; j++)
                if(board[i][j] == 0)
                    count++;
        if(count == row * col)
            return 0;
        
        for(int i=1; i<row; i++){
            for(int j=1; j<col; j++){
                if(board[i][j] == 0)
                    continue;
                min = Math.min(board[i-1][j], board[i][j-1]);
                min = Math.min(min, board[i-1][j-1]);
                board[i][j] = min + 1;
                if(maxVal < board[i][j])
                    maxVal = board[i][j];
            }
        }
        
        if(maxVal == 0)
            return 1;
        return maxVal * maxVal;
    }
}