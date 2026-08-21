class Solution {
    public boolean winnerOfGame(String colors) {
        int AliceTurn = 0;
        int BobTurn = 0;
        int len = colors.length();
        int a = 0;
        int b = 0;
        for (int i = 0; i < len; i++) {
            char curr = colors.charAt(i);
            if (curr == 'A') {
                a++;
                b = 0;
                if (a >= 3) {
                    AliceTurn += a - 2;
                }
            } else {
                b++;
                a = 0;
                if (b >= 3) {
                    BobTurn += b - 2;
                }
            }
        }
        return AliceTurn > BobTurn;
    }
}