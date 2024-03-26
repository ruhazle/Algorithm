class Solution {
    public String solution(String m, String[] musicinfos) {
        String answer = "(None)";
        int maxPlayTime = Integer.MIN_VALUE;
       
        m=m.replaceAll("C#", "H");
        m=m.replaceAll("D#", "I");
        m=m.replaceAll("F#", "J");
        m=m.replaceAll("G#", "K");
        m=m.replaceAll("A#", "L");
        m=m.replaceAll("B#", "M");
        
        for(int i = 0; i < musicinfos.length; i++) {
            String[] info = musicinfos[i].split(",");
            
            //재생 시간
            String[] start = info[0].split(":");
            int sm = Integer.parseInt(start[0]) * 60 + Integer.parseInt(start[1]);
            String[] end = info[1].split(":");
            int em = Integer.parseInt(end[0]) * 60 + Integer.parseInt(end[1]);
            int playTime = em - sm;
            
            info[3]=info[3].replaceAll("C#", "H");
            info[3]=info[3].replaceAll("D#", "I");
            info[3]=info[3].replaceAll("F#", "J");
            info[3]=info[3].replaceAll("G#", "K");
            info[3]=info[3].replaceAll("A#", "L");
            info[3]=info[3].replaceAll("B#", "M");
            String playString = "";
            if(info[3].length() > playTime)
                playString = info[3].substring(0, playTime);
            if(info[3].length() == playTime)
                playString = info[3];
            if(info[3].length() < playTime) {
                int count = playTime / info[3].length();
                int extra = playTime % info[3].length();
                
                while(count > 0) {
                    playString += info[3];
                    count--;
                }
                if(extra > 0)
                    playString += info[3].substring(0, extra);
            }
            
            if(playString.contains(m) && (playTime > maxPlayTime)){
                answer = info[2];
                maxPlayTime = playTime;
            }
                
                
        }
    
        return answer;
    }
}