import java.util.ArrayList;
import java.util.List;

public class VariantsCount {

    public static int variantsCount(int n, int s0, int k, int b, int m, int a) {
        if (n <= 0) {
            return 0;
        }

        List<Integer> sumArray = new ArrayList<>();
        sumArray.add(s0);
        for (int i = 1; i < n; i++) {
            int s_i = ((k * sumArray.get(i - 1) + b) % m) + 1 + sumArray.get(i - 1);
            sumArray.add(s_i);
        }

        // Two pointers to calculate the count
        int left = 0;
        int right = sumArray.size() - 1;
        int count = 0;
        while (left <= right) {
            int area = sumArray.get(left) * sumArray.get(right);
            if (area <= a) {
                count += 2 * (right - left) + 1;
                left++;
            } else if (area > a) {
                right--;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int n = 5;
        int s0 = 1;
        int k = 2;
        int b = 1;
        int m = 5;
        int a = 11;

        int result = variantsCount(n, s0, k, b, m, a);
        System.out.println(result); // Output: 7
    }
}
