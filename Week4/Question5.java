//Week 4 - Question 5
public class DynamicArray {
    private int[] arr;
    private int size;

    public DynamicArray() {
        arr = new int[10];
        size = 0;
    }

    public int get(int index) {
        if (index < 0 || index >= arr.length) {
            throw new Error("Array index out of range");
        }
        return arr[index];
    }

    public void add(int element) {
        if (size == arr.length) {
            int[] temp = new int[size * 2];
            for (int i = 0; i < arr.length; i++) {
                temp[i] = arr[i];
            }
            arr = temp;
        }
        arr[size] = element;
        size += 1;
    }

    public int size() {
        return size;
    }
}