/*Sort the array.

Think of each element as either:
1. A number that needs to be beaten.
2. A number used to beat another number.

Start from the largest values.

For the current largest unused value (right),
try to match it with the largest possible value that is still smaller than it (left).

Why?
Using a very large number to beat a much smaller number wastes its potential.
Matching it with the largest value it can beat preserves smaller values for future matches.

If nums[right] == nums[left],
this value cannot beat any remaining element,
so skip all duplicates of that value.

Otherwise,
form one valid pair,
increase greatness,
and move both pointers. 


Pattern:
Greedy + Two Pointers + Sorting

Complexity
Time : O(n log n)
Space: O(1) (excluding sorting)

Greedy Invariant
Always use the current largest available element
to beat the largest available element that is still smaller than it.
This avoids wasting larger elements on unnecessarily small values.

*/

import java.util.Arrays;

class Solution {
    public int maximizeGreatness(int[] nums) {
        Arrays.sort(nums);
        int left = nums.length - 1;
        int right = nums.length - 1;
        int ans = 0;
        while (left >= 0) {
            if (nums[left] == nums[right]) {
                while (left >= 0 && nums[left] == nums[right]) {
                    left--;
                }
            } else {
                ans++;
                left--;
                right--;
            }
        }
        return ans;
    }
}