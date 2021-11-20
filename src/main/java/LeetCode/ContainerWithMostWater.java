package LeetCode;

import static java.util.Collections.swap;

//https://leetcode.com/problems/container-with-most-water/submissions/
public class ContainerWithMostWater {

    static int maxArea(int[] height) {
        int s = 0;
        int e = height.length-1;
        int water = Integer.MIN_VALUE;
        while (s < e) {
            int h;
            int dis = e - s;
            if (height[s] < height[e]) {
                h = height[s++];
            } else {
                h = height[e--];
            }
            water = Math.max(water, dis * h);
        }
        return water;
    }

    public static void main(String[] args) {
//        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
//        int[] height = {4,3,2,1,4};
//        int[] height = {1, 2, 1};
//        int[] height = {1, 34};
//        int[] height = {2,3,4,5,18,17,6};
//        int[] height = {4,4,2,11,0,11,5,11,13,8};
//        int[] height = {4,6,4,4,6,2,6,7,11,2};
//        int[] height = {9,6,14,11,2,2,4,9,3,8};
        int[] height = {75,21,3,152,13,107,163,166,32,160,41,131,7,67,56,5,153,176,29,139,61,149,176,142,64,75,170,156,73,48,148,101,70,103,53,83,11,168,1,195,81,43,126,88,62,134,45,167,63,26,107,124,128,83,67,192,158,189,149,184,37,49,85,107,152,90,143,115,58,144,62,139,139,189,180,153,75,177,121,138,4,28,15,132,63,82,124,174,23,25,110,60,74,147,120,179,37,63,94,47};
        System.out.println(maxArea(height));
    }
}
