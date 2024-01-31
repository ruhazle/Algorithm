class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        String[] skillList = skill.split("");
        
        for(int i = 0; i < skill_trees.length; i++) {
            String[] list = skill_trees[i].split("");
            int index = 0;
            String learned = "";
            for(String nk : list) {
                if(!skill.contains(nk))
                    learned += nk;
                else {
                    if(nk.equals(skillList[index])){
                        learned += nk;
                        index++;
                    }
                    else break;
                }     
            }
            if(learned.equals(skill_trees[i]))
                answer++;
        }
        return answer;
    }
}