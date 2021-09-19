package 네파;

import java.util.Arrays;

public class Main3 {

    static int solution3(int[] A) {
        int ans = 0;
        int l = 0;
        int r = A.length - 1;

        // l == negative
        // r == positive
        Arrays.sort(A);

        while (l < r) {
            int abs_Left = Math.abs(A[l]);
            int abs_Right = Math.abs(A[r]);

            if (abs_Left == abs_Right && A[l] < A[r]) {
                return abs_Right;
            }
            if (abs_Left <= abs_Right && A[l] < A[r]) {
                r--;
            } else {
                l++;
            }
        }
        return 0;
    }

    public static void main(String[] args){

        return;
    }
}
