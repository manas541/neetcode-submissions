class Solution {
    public int maxArea(int[] heights) {
        int l =0;
        int r = heights.length-1;
        int area = 0;
        int maxArea=0;
        while(l<r){
            area=(r-l)*Math.min(heights[l],heights[r]);
            maxArea= Math.max(area,maxArea);

            if(heights[l]<heights[r]) l++;
            else r--;
        }

        return maxArea;
    }
}
