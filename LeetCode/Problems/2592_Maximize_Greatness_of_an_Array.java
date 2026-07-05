/*

left  -> smallest element waiting to be beaten
right -> current candidate to beat it

*/

import java.util.Arrays;

class Solution {
    public int maximizeGreatness(int[] nums) {
        Arrays.sort(nums);

        int left = 0;
        int right = 0;
        int ans = 0;

        while (right < nums.length) {
            if (nums[right] > nums[left]) {
                ans++;
                left++;
            }
            right++;
        }

        return ans;
    }
}