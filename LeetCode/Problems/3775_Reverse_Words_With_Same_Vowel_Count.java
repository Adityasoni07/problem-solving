class Solution {
    public boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }

    public int vowelCount(String curr) {
        int count = 0;
        for (int i = 0; i < curr.length(); i++) {
            if (isVowel(curr.charAt(i))) {
                count++;
            }
        }
        return count;
    }

    public String reverseWords(String s) {
        String[] arr = s.split(" ");
        int count = vowelCount(arr[0]);
        StringBuilder sb = new StringBuilder(arr[0]);
        for (int i = 1; i < arr.length; i++) {
            sb.append(" ");
            String curr = arr[i];
            if (vowelCount(curr) == count) {
                for (int j = curr.length() - 1; j >= 0; j--) {
                    sb.append(curr.charAt(j));
                }
            } else {
                sb.append(curr);
            }
        }
        return sb.toString();
    }
}