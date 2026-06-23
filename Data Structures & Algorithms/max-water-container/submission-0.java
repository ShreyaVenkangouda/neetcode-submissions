class Solution {
    public int maxArea(int[] heights) {
        int maxArea = 0;
        int lp = 0;
        int rp = heights.length-1;
        while(lp < rp){
            int width = rp - lp;
            int ht = Math.min(heights[lp],heights[rp]);
            maxArea = Math.max(maxArea,(width*ht));
            while(lp<rp && heights[lp] <= ht){
                lp++;
            }
            while(lp<rp && heights[rp] <= ht){
                rp--;
            }
        }
        return maxArea;
    }
}
