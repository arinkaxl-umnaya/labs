import java.util.List;

     interface Sorting<T extends Comparable<T>> {
    void sort(List<T> nums);
}