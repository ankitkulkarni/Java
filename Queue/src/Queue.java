import java.util.Stack;

/**
 * Created by Ankit on 25-Oct-16.
 */
public class Queue {
    public static Stack<Integer> stack1 = new Stack<>();
    public static Stack<Integer> stack2 = new Stack<>();
    public static void main(String[] args){
        add(5);
        add(4);
        add(3);
        add(2);
        add(1);
        System.out.println("Peeked Value: " + peek());
	System.out.println("Queue Size: " + size());
        System.out.println("Popped value: " + remove());
        System.out.println("Popped value: " + remove());
	System.out.println("Queue Size: " + size());
        System.out.println("Peeked value: " + peek());
        System.out.println("Popped value: " + remove());
    }
    public static void add(int data){
        stack1.push(data);
    }
    public static int peek(){
        if(!stack2.isEmpty()){
            return stack2.peek();
        }
        else{
            shiftFromS1toS2();
            return stack2.peek();
        }
    }
    public int size(){
        return (stack1.size() + stack2.size());
    }
    public static void shiftFromS1toS2(){
        if(stack1.isEmpty()){
            System.out.println("Queue Empty");
        }
        else{
            while(!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
        }
    }
    public static int remove(){
        if(!stack2.isEmpty()){
            return stack2.pop();
        }
        else{
            shiftFromS1toS2();
            return stack2.pop();
        }
    }
}
