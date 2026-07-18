class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character,Integer> window = new HashMap<>();
        HashMap<Character,Integer> need = new HashMap<>();
        int formed = 0;
        for(int i=0;i<t.length();i++){
            char ch = t.charAt(i);
            need.put(ch,need.getOrDefault(ch,0)+1);
        }
        int required = need.size();
        int left = 0;
        int minLength = Integer.MAX_VALUE;
        int minStart = 0;
        for(int right=0;right<s.length();right++){
            char ch = s.charAt(right);
            window.put(ch,window.getOrDefault(ch,0)+1);
            if(need.containsKey(ch) && window.get(ch).equals(need.get(ch))){
                formed++;
            }
            while(formed == required){
                if(right-left+1 < minLength){
                    minLength = Math.min(minLength,right-left+1);
                    minStart = left;
                }
                char leftChar = s.charAt(left);
                window.put(leftChar,window.get(leftChar)-1);
                if(need.containsKey(leftChar) && window.get(leftChar) < need.get(leftChar)){
                    formed--;
                }
                left++;
            }
        }
        if(minLength == Integer.MAX_VALUE){
            return "";
        }
        return s.substring(minStart, minStart + minLength);
    }
}
