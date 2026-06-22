class Solution {
    public int longestConsecutive(int[] nums) {
        Arrays.sort(nums);
        int longest = 0;
        int currCnt = 0;
        int lastSmall = Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            if(nums[i]-1 == lastSmall){
                currCnt++;
                lastSmall = nums[i];
            }
            else if(nums[i] != lastSmall){
                currCnt = 1;
                lastSmall = nums[i];
            }
            longest = Math.max(longest,currCnt);
        }
        return longest;
    }
}
