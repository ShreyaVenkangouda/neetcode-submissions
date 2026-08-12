class Solution {
    public int[] getConcatenation(int[] nums) {
        int n = nums.length*2;
        int[] ans = new int[n];
        int idx = 0;
        for(int i=0;i<2;i++){
            for(int num : nums){
                ans[idx++] = num;
            }
        }
        return ans;
    }
}