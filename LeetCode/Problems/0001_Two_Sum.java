class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> H = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (H.containsKey(target - nums[i])) {
                return new int[] { H.get(target - nums[i]), i };
            }
            H.put(nums[i], i);
        }
        return new int[] {};
    }
}