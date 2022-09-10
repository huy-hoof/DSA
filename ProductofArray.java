import java.util.stream.*;

public class ProductofArray {
    public static void main(String... args) {
        ProductofArray run = new ProductofArray();

        int[] nums = { 1, 2, 3, 4 };
        int[] products = run.productExceptSelf(nums);
        IntStream.of(products).forEach(System.out::println);
    }

    public int[] productExceptSelf(int[] nums) {
        int[] leftPrefix = new int[nums.length];
        leftPrefix[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            leftPrefix[i] = leftPrefix[i - 1] * nums[i];
        }

        int[] rightPrefix = new int[nums.length];
        rightPrefix[nums.length - 1] = nums[nums.length - 1];
        for (int i = nums.length - 2; i >= 0; i--) {
            rightPrefix[i] = rightPrefix[i + 1] * nums[i];
        }

        int[] products = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            products[i] = ((i - 1 < 0) ? 1 : leftPrefix[i - 1]) * ((i + 1 == nums.length) ? 1 : rightPrefix[i + 1]);
        }

        return products;
    }
}
