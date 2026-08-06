import java.util.*;

class Solution {
    public boolean isHappy(int n) {
        HashSet<Integer> set = new HashSet<>();
        while (n != 1) {
            int num = n;
            n = 0;
            while (num != 0) {
                n += (num % 10) * (num % 10);
                num /= 10;
            }
            if (set.contains(n)) {
                return false;
            }
            set.add(n);
        }
        return true;
    }
}