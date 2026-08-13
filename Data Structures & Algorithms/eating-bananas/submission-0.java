class Solution {
    public int totalHours(int[] piles, int h){
        int totalHours = 0;
        for(int i=0;i<piles.length;i++){
            totalHours += ((piles[i] + h - 1)/h);
        }
        return totalHours;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int high = 0;
        for(int pile : piles){
            high = Math.max(high,pile);
        }
        int ans = high;
        while(low <= high){
            int mid = (low+high) / 2;
            int hours = totalHours(piles,mid);
            if(hours <= h){
                ans = mid;
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        return ans;
    }
}
