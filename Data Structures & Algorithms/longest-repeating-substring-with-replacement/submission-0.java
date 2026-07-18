class Solution {
    public int characterReplacement(String s, int k) {
        int maxLength = 0;
        int windowLength = 0;
        int maxFreq = 0;
        HashMap<Character,Integer> freq = new HashMap<>();
        int left = 0;
        for(int right = 0;right < s.length();right++){
            char ch = s.charAt(right);
            freq.put(ch, freq.getOrDefault(ch, 0) + 1);
            maxFreq = Math.max(maxFreq,freq.get(ch));
            windowLength = right - left + 1;
            while(windowLength - maxFreq > k){
                freq.put(s.charAt(left),freq.getOrDefault(s.charAt(left),0)-1);
                left++;
                windowLength = right - left + 1;
            }
            maxLength = Math.max(maxLength,right-left+1);
        }
        return maxLength;
    }
}
