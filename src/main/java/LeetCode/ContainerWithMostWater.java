package LeetCode;

//https://leetcode.com/problems/container-with-most-water/submissions/
public class ContainerWithMostWater {

    static int maxArea(int[] height) {

        int first_i = 0;
        int first_max = Integer.MIN_VALUE;
        int second_i = height.length-1;
        int second_max = Integer.MIN_VALUE;

        for (int i = 0; i < height.length; i++) {
            if (height[i] > first_max) {
                first_i  = i;
                first_max = height[i];
            }
        }
        for (int i = 0; i < height.length; i++) {
            if (i != first_i  && height[i] > second_max) {
                second_i = i;
                second_max = height[i];
            }
        }

        int s = 0;
        int e = height.length - 1;
        int rain = Integer.MIN_VALUE;
        if (first_i > second_i) {
            int temp = first_i;
            first_i = second_i;
            second_i = temp;
            temp = first_max;
            first_max = second_max;
            second_max = temp;
        }
        while (s < second_i) {
            int h = Integer.min(height[s], second_max);
            rain = Integer.max(rain, (second_i - s) * h);
            s++;
        }
        while (e > first_i) {
            int h = Integer.min(first_max, height[e]);
            rain = Integer.max(rain, (e - first_i) * h);
            e--;
        }
        s = 0;
        e = height.length - 1;
        while (s < e) {
            int h = Integer.min(height[s], height[e]);
            rain = Integer.max(rain, (e - s) * h);
            s++;
        }
        s = 0;
        while (s < e) {
            int h = Integer.min(height[s], height[e]);
            rain = Integer.max(rain, (e - s) * h);
            e--;
        }
        return rain;
    }

    public static void main(String[] args) {
//        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
//        int[] height = {4,3,2,1,4};
//        int[] height = {1, 2, 1};
//        int[] height = {1, 34};
//        int[] height = {2,3,4,5,18,17,6};
//        int[] height = {4,4,2,11,0,11,5,11,13,8};
//        int[] height = {4,6,4,4,6,2,6,7,11,2};
        int[] height = {9,6,14,11,2,2,4,9,3,8};
        System.out.println(maxArea(height));
    }
}
