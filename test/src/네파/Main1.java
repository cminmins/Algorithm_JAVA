package 네파;

public class Main1 {

    static int[] solution1(String[] S) {
        final int ALPHABET_LENGTH = 26;
        int m = S[0].length();
        int[][] dp = new int[m][ALPHABET_LENGTH];

        for (int S_idx = 0; S_idx < m; S_idx++) {
            for (int alpha = 0; alpha < ALPHABET_LENGTH; alpha++) {
                dp[S_idx][alpha] = -1;
            }
        }

        for (int S_idx = 0; S_idx < S.length; S_idx++) {
            for (int m_idx = 0; m_idx < m; m_idx++) {
                int cur_alpha = getAlphabetPosition(S[S_idx].charAt(m_idx));

                if (dp[m_idx][cur_alpha] == -1) {
                    dp[m_idx][cur_alpha] = S_idx;
                } else {
                    return new int[]{dp[m_idx][cur_alpha], S_idx, m_idx};
                }
            }
        }
        return new int[]{};
    }

    static int getAlphabetPosition(char character) {
        return character - 'a';
    }

    public static void main(String[] args) {

        return;
    }
}
