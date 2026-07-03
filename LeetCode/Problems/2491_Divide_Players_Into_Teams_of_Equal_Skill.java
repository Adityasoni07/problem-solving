import java.util.Arrays;

class Solution {
    public long dividePlayers(int[] skill) {
        Arrays.sort(skill);
        int left = 0;
        int right = skill.length - 1;
        int k = skill[left] + skill[right];
        long ans = 0;
        while (left < right) {
            int sum = skill[left] + skill[right];
            if (sum == k) {
                ans = ans + (skill[left] * skill[right]);
                left++;
                right--;
            } else {
                return -1;
            }
        }
        return ans;
    }
}