class Solution {
    /*public int majorityElement(int[] nums) {
     HashMap<Integer,Integer> countValMap = new HashMap<>();
     for(int i = 0; i < nums.length; i++){
        int preCount = countValMap.getOrDefault(nums[i], 0);
        preCount += 1;
        if(preCount > nums.length/2) return nums[i];
        countValMap.put(nums[i], preCount);
     }   
     return -1;
    }*/
    public int majorityElement(int[] nums) {
        int candidate = findCandidate(nums);
        return verifyCandidate(nums, candidate) ? candidate : -1;
    }

    private int findCandidate(int[] nums) {
        int candidate = 0, count = 0;
        for (int num : nums) {
            if (count == 0) {
                candidate = num;
                count = 1;
            } else if (num == candidate) {
                count++;
            } else {
                count--;
            }
        }
        return candidate;
    }

    private boolean verifyCandidate(int[] nums, int candidate) {
        int count = 0;
        for (int num : nums) {
            if (num == candidate) {
                count++;
            }
        }
        return count > nums.length / 2;
    }
}