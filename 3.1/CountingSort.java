import java.util.List;

public class CountingSort implements Sorting<Integer> {
    @Override
    public void sort(List<Integer> nums) {
        int[] count = new int[128];

        for (int i = 0; i < nums.size(); i++) {
            count[nums.get(i)]++;
        }

        int index = 0;
        for (int i = 0; i < 128; i++) {
            for (int c = 0; c < count[i]; c++) {
                nums.set(index, i);
                index++;
            }
        }
    }
}