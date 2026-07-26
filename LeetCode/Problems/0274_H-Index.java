class Solution {
    public int hIndex(int[] citations) {
        int freq[] = new int[1001];

        for (int citation : citations) {
            freq[citation]++;
        }

        int n = citations.length;
        int hIndex = 0;
        int papersWithSmallerCitations = 0;

        for (int citation = 0; citation <= 1000; citation++) {
            if (n - papersWithSmallerCitations < citation) {
                break;
            }

            hIndex = citation;
            papersWithSmallerCitations += freq[citation];
        }

        return hIndex;
    }
}