class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        int idx;
        for(String tree : skill_trees){
            idx = 0;
            for(int i=0; i<skill.length(); i++){
                int ch_idx = tree.indexOf(skill.charAt(i));
                if(ch_idx >= idx){
                    if(idx == -1 && ch_idx != -1){
                        idx = -2;
                        break;
                    }
                    else{
                        idx = ch_idx;
                    }
                }
                else{
                    if(ch_idx == -1){
                        idx = ch_idx;
                    }else{
                        idx = -2;
                        break;
                    }
                }
            }
            if(idx >= -1) answer++;
        }
        return answer;
    }
}