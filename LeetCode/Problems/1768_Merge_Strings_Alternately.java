class Solution {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder sb = new StringBuilder();
        int m = word1.length();
        int n = word2.length();
        int i = 0;
        int j = 0;
        while (i < m && j < n) {
            sb.append(word1.charAt(i));
            sb.append(word2.charAt(j));
            i++;
            j++;
        }
        while (i < m) {
            sb.append(word1.charAt(i));
            i++;
        }
        while (j < n) {
            sb.append(word2.charAt(j));
            j++;
        }
        return sb.toString();
    }
}