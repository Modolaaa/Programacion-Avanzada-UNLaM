import java.util.ArrayList;

public class MinHeapToMaxHeap {

    public static void heapify(ArrayList<Integer> heap, int index, int heapSize) {
        int left = 2 * index + 1;
        int right = 2 * index + 2;
        int largest = index;

        if (left < heapSize && heap.get(left) > heap.get(largest)) {
            largest = left;
        }
        if (right < heapSize && heap.get(right) > heap.get(largest)) {
            largest = right;
        }

        if (largest != index) {
            int swap = heap.get(index);
            heap.set(index, heap.get(largest));
            heap.set(largest, swap);

            heapify(heap, largest, heapSize);
        }
    }

    public static ArrayList<Integer> convert(ArrayList<Integer> minHeap) {
        ArrayList<Integer> maxHeap = new ArrayList<>(minHeap);
        int n = maxHeap.size();

        for (int i = (n - 1) / 2; i >= 0; i--) {
            heapify(maxHeap, i, n);
        }
        return maxHeap;
    }
}


