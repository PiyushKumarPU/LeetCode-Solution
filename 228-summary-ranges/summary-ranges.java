class Solution {
    public List<String> summaryRanges(int[] nums) {
       List<String> result = new ArrayList<>();
        for (int i = 0; i < nums.length; ) {
            int j = i + 1;
            while (j < nums.length && nums[j] == nums[j - 1] + 1) {
                j++;
            }
            if (j - 1 == i) {
                result.add(String.valueOf(nums[i]));
            } else {
                result.add(nums[i] + "->" + nums[j - 1]);
            }
            i = j;
        }
        return result; 
    }
}