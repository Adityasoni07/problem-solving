class RLEIterator {

    int[] encoding;
    int idx;

    public RLEIterator(int[] encoding) {
        this.encoding = encoding;
        this.idx = 0;
    }

    public int next(int n) {

        while (idx < encoding.length && n > encoding[idx]) {
            n -= encoding[idx];
            idx += 2;
        }

        if (idx == encoding.length) {
            return -1;
        }

        encoding[idx] -= n;
        return encoding[idx + 1];
    }
}

/**
 * Your RLEIterator object will be instantiated and called as such:
 * RLEIterator obj = new RLEIterator(encoding);
 * int param_1 = obj.next(n);
 */