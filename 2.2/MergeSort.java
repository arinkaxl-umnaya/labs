import java.util.List;

public class MergeSort implements Sorting<Integer> {
    private void slice(List<Integer> nums, int start, int end) {
        if (start < end) {
            int mid = (start + end) / 2;
            slice(nums, start, mid);
            slice(nums, mid + 1, end);
            merge(nums, start, mid, end);
        }
    }

    private void merge(List<Integer> nums, int start, int mid, int end) {
        int levo_size = mid - start + 1;
        int pravo_size = end - mid;

        int[] levo = new int[levo_size];
        int[] pravo = new int[pravo_size];

        for (int i = 0; i < levo_size; i++) {
            levo[i] = nums.get(start + i);
        }
        for (int j = 0; j < pravo_size; j++) {
            pravo[j] = nums.get(mid + 1 + j);

        }

        int i = 0;
        int j = 0;
        int k = start;

        while (i < levo_size && j < pravo_size) {
            if (levo[i] <= pravo[j]) {
                nums.set(k, levo[i]);
                i++;
            } else {
                nums.set(k, pravo[j]);
                j++;
            }
            k++;
        }

        while (i < levo_size) {
            nums.set(k, levo[i]);
            i++;
            k++;
        }

        while (j < pravo_size) {
            nums.set(k, pravo[j]);
            j++;
            k++;
        }
    }

    @Override
    public void sort(List<Integer> nums) {
        slice(nums, 0, nums.size() - 1);
    }
}