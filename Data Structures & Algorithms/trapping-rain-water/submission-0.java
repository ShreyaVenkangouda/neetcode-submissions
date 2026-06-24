class Solution {
    public int trap(int[] height) {
        int[] lmb = new int[height.length];
        lmb[0] = height[0];
        for(int i=1;i<height.length;i++){
            lmb[i] = Math.max(height[i],lmb[i-1]);
        }
        int[] rmb = new int[height.length];
        rmb[height.length-1] = height[height.length-1];
        for(int i=height.length-2;i>=0;i--){
            rmb[i] = Math.max(height[i],rmb[i+1]);
        }
        int trap = 0;
        for(int i=0;i<height.length;i++){
            int waterlevel = Math.min(lmb[i],rmb[i]);
            trap += waterlevel - height[i];
        }
        return trap;
    }
}
