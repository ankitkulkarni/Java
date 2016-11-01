import java.util.EmptyStackException;

/**
 * Created by Ankit on 25-Oct-16.
 */
public class Stack {
    int capacity, size, stk[];
    public Stack(int capacity){
        this.capacity = capacity;
        size = 0;
        stk = new int[capacity];
    }
    public void push(int data){
        if(size >= capacity){
            System.out.println("Stack is full");
        }
        stk[size++] = data;
    }
    public int pop(){
        if(size == 0){
            throw new EmptyStackException();
        }
        int data = stk[--size];
        stk[size] = 0;
        return data;
    }
    public int getSize(){
        return size;
    }
    public void displayStack(){
        System.out.println("Stack Values: ");
        for(int i = 0; i < size; i++){
            System.out.println(stk[i]);
        }
    }
    public int peek(){
        if(size == 0){
            throw new EmptyStackException();
        }
        int returnThis = stk[--size];
        size++;
        return returnThis;
    }
    public boolean isEmpty(){
        return size == 0;
    }
}