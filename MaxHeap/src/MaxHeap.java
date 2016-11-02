/**
 * Created by Ankit on 02-Nov-16.
 */
public class MaxHeap {
    public int heapSize;
    public int[] heapArray;
    public int currentSize;
    public MaxHeap(int heapSize){
        this.heapSize = heapSize;
        currentSize = 0;
        heapArray = new int[heapSize + 1];
    }
    public void createMaxHeap(int[] arr){
        if(arr.length > 0){
            for(int i : arr){
                insert(i);
            }
        }
    }
    public void insert(int i){
        if(currentSize == 0){
            heapArray[++currentSize] = i;
            currentSize++;
        }
        else{
            heapArray[currentSize++] = i;
            bubbleUp();
        }
    }
    public void bubbleUp(){
        int tempSize = currentSize - 1;
        while(tempSize > 1 && heapArray[tempSize/2] < heapArray[tempSize]){
            swap(tempSize/2, tempSize);
            tempSize = tempSize/2;
        }
    }
    public void swap(int a, int b){
        int temp = heapArray[a];
        heapArray[a] = heapArray[b];
        heapArray[b] = temp;
    }
    public int extractMax(){
        int max = heapArray[1];
        heapArray[1] = heapArray[--currentSize];
        heapArray[currentSize] = 0;
        sinkDown(1);
        return max;
    }
    public void sinkDown(int i){
        int largest = i;
        if(2 * i < currentSize && heapArray[2 * i] > heapArray[largest]){
            largest = 2 * i;
        }
        if((2 * i) + 1 < currentSize && heapArray[(2 * i) + 1] > heapArray[largest]){
            largest = (2 * i) + 1;
        }
        if(largest != i){
            swap(i, largest);
            sinkDown(largest);
        }
    }
    public void displayHeap(){
        for(int i = 1; i < heapArray.length; i++){
            System.out.print(heapArray[i] + " ");
        }
        System.out.println();
    }
    public static void main(String[] args){
        int[] arr = {1, 2, 3, 7, 8, 4, 10, 16, 12};
        MaxHeap mh = new MaxHeap(arr.length);
        System.out.println("Original Array: ");
        for(int i : arr){
            System.out.print(i + " ");
        }
        System.out.println();
        System.out.println("Max Heap Array: ");
        mh.createMaxHeap(arr);
        mh.displayHeap();
        System.out.println("Extract Max: ");
        for (int ignored : arr) {
            System.out.print(mh.extractMax() + " ");
            System.out.println();
            mh.displayHeap();
        }
    }
}

/*
Original Array:
1 2 3 7 8 4 10 16 12
Max Heap Array:
16 12 8 10 3 2 4 1 7
Extract Max:
16
12 10 8 7 3 2 4 1 0
12
10 7 8 1 3 2 4 0 0
10
8 7 4 1 3 2 0 0 0
8
7 3 4 1 2 0 0 0 0
7
4 3 2 1 0 0 0 0 0
4
3 1 2 0 0 0 0 0 0
3
2 1 0 0 0 0 0 0 0
2
1 0 0 0 0 0 0 0 0
1
0 0 0 0 0 0 0 0 0
*/