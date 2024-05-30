class Solution {
    public int maxArea(int[] height) {
        if (height.length < 2) return 0;
        int ans = 0, start = 0, end = height.length - 1;
        while (start < end) {
            int area = Math.min(height[start], height[end]) * (end - start);
            ans = Math.max(ans, area);
            if (height[start] <= height[end]) start++;
            else end--;
        }
        return ans;
    }
}