import java.util.Arrays;

public class RotateArray {

    public static int[] rotateArray(int[] nums, int k) {
        int n = nums.length;
        if (n == 0) {
            return nums;
        }
        k = k % n;
        int[] rotated = new int[n];

        for (int i = 0; i < n; i++) {
            rotated[(i + k) % n] = nums[i];
        }

        return rotated;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(rotateArray(new int[]{1, 2, 3, 4, 5, 6, 7}, 3)));
        System.out.println(Arrays.toString(rotateArray(new int[]{1, 2}, 3)));
    }
}
