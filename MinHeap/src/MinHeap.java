/**
 * Created by Ankit on 02-Nov-16.
 */
public class MinHeap {
    public int arraySize;
    public int currentSize;
    public int[] heapArray;
    public MinHeap(int arraySize){
        this.arraySize = arraySize;
        currentSize = 0;
        heapArray = new int[arraySize + 1];
    }
    public void insertInHeap(int[] arr){
        if(arr.length > 0){
            for (int val : arr) {
                insert(val);
            }
        }
    }
    public void insert(int value){
        if(currentSize == 0){
            heapArray[currentSize + 1] = value;
            currentSize = 2;
        }
        else{
            heapArray[currentSize++] = value;
            bubbleUp();
        }
    }
    public void bubbleUp(){
        int tempSize = currentSize - 1;
        while(tempSize >0 && heapArray[tempSize/2] > heapArray[tempSize]){
            swap(tempSize/2, tempSize);
            tempSize = tempSize/2;
        }
    }
    public int extractMin(){
        int min = heapArray[1];
        currentSize--;
        heapArray[1] = heapArray[currentSize];
        heapArray[currentSize] = 0;
        sinkDown(1);
        return min;
    }
    public void sinkDown(int k){
        int smallest = k;
        if(2 * k < currentSize && heapArray[smallest] > heapArray[2 * k]){
            smallest = 2 * k;
        }
        if((2 * k) + 1 < currentSize && heapArray[smallest] > heapArray[(2 * k) + 1]){
            smallest = (2 * k) + 1;
        }
        if(smallest != k){
            swap(k, smallest);
            sinkDown(smallest);
        }
    }
    public void swap(int a, int b){
        int temp = heapArray[a];
        heapArray[a] = heapArray[b];
        heapArray[b] = temp;
    }
    public void displayHeap(){
        for (int i=1; i < heapArray.length; i++) {
            System.out.print(heapArray[i] + " ");
        }
        System.out.println();
    }
    public static void main(String[] args){
        int[] arr = {3, 2, 1, 7, 8, 4, 10, 16, 12};
        MinHeap mh = new MinHeap(arr.length);
        System.out.println("Original Array: ");
        for(int i : arr){
            System.out.print(i + " ");
        }
        System.out.println();
        System.out.println("Min Heap Array: ");
        mh.insertInHeap(arr);
        mh.displayHeap();
        System.out.println("Extract Min: ");
        for (int ignored : arr) {
            System.out.print(mh.extractMin() + " ");
            System.out.println();
            mh.displayHeap();
        }
    }
}

/*
Original Array:
3 2 1 7 8 4 10 16 12
Min Heap Array:
1 3 2 7 8 4 10 16 12
Extract Min:
1
2 3 4 7 8 12 10 16 0
2
3 7 4 16 8 12 10 0 0
3
4 7 10 16 8 12 0 0 0
4
7 8 10 16 12 0 0 0 0
7
8 12 10 16 0 0 0 0 0
8
10 12 16 0 0 0 0 0 0
10
12 16 0 0 0 0 0 0 0
12
16 0 0 0 0 0 0 0 0
16
0 0 0 0 0 0 0 0 0
*/