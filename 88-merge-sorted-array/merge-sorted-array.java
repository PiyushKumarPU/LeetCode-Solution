class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (m == 0) nums1[0] = nums2[0];
        else if (n == 0) return;
        int[] result = new int[m + n];
        int index = 0, firstIndex = 0, secondIndex = 0;
        while (firstIndex < m || secondIndex < n) {
            int first = firstIndex < m ? nums1[firstIndex] : Integer.MAX_VALUE;
            int second = secondIndex < n ? nums2[secondIndex] : Integer.MAX_VALUE;
            if (first > second) {
                result[index++] = second;
                secondIndex++;
            } else if (second > first) {
                result[index++] = first;
                firstIndex++;
            } else {
                result[index++] = first;
                result[index++] = second;
                firstIndex++;
                secondIndex++;
            }
        }
        System.arraycopy(result, 0, nums1, 0, result.length);
    }
}