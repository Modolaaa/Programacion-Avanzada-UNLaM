import java.util.ArrayList;

public class MaxHeap <T extends Comparable<T>>{
    private ArrayList<Tuple<T>> myHeap;

    public MaxHeap(){
        this.myHeap = new ArrayList<>();
        this.myHeap.add(null); // indice 0 no es considerado para facilitar calculos

    }

    public void insert(Tuple<T> t){
        this.myHeap.add(t);
        int i = this.myHeap.size()-1;
        swim(i);
    }

    public void swim(int i){
        while(i>1 && this.myHeap.get(i/2).compareTo(this.myHeap.get(i))<0){
            swap(i,i/2);
            i = i/2;
        }
    }

    public void swap(int i, int j){
        Tuple<T> aux = this.myHeap.get(i);
        this.myHeap.set(i,this.myHeap.get(j));
        this.myHeap.set(j,aux);
    }

    public Tuple<T> peek(){
        if(this.myHeap.size()<=1){
            return null;
        }
        return this.myHeap.get(1);
    }

    public Tuple<T> extractMax(){
        if(this.myHeap.size()<=1){
            return null;
        }
        Tuple<T> max = this.myHeap.get(1);
        Tuple<T> ultimo = this.myHeap.removeLast();

        if (this.myHeap.size() > 1) {
            this.myHeap.set(1, ultimo);
            heapify(1);
        }
        return max;
    }

    private void heapify(int i) {
        int left = 2 * i;
        int right = 2 * i + 1;
        int largest = i;

        if (left < myHeap.size() && myHeap.get(left).compareTo(myHeap.get(largest)) > 0) {
            largest = left;
        }
        if (right < myHeap.size() && myHeap.get(right).compareTo(myHeap.get(largest)) > 0) {
            largest = right;
        }

        if (largest != i) {
            swap(i, largest);
            heapify(largest);
        }
    }
    public void buildHeap() {
        // myHeap.get(0) == null

        // Construcción en O(n) usando heapify desde n/2 hasta 1

        for (int i = (myHeap.size() - 1) / 2; i >= 1; i--) {
            heapify(i);
        }
    }

    public int size() {
        return this.myHeap.size() - 1; // porque hay un null en 0
    }

    @Override
    public String toString() {
        return myHeap.subList(1, myHeap.size()).toString();
    }


}
