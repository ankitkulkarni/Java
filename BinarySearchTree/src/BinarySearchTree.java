/**
 * Created by Ankit on 31-Oct-16.
 */
public class BinarySearchTree {
    private Node root;
    private static class Node{
        Node left, right;
        int data;
        public Node(int newData){
            left = null;
            right = null;
            data = newData;
        }
    }
    public BinarySearchTree(){
        root = null;
    }
    public void insert(int data){
        root = insert(root, data);
    }
    public Node insert(Node node, int data){
        if(node == null){
            node = new Node(data);
        }
        else{
            if(data <= node.data){
                node.left = insert(node.left, data);
            }
            else{
                node.right = insert(node.right, data);
            }
        }
        return node;
    }
    public boolean lookup(int data){
        return lookup(root, data);
    }
    public boolean lookup(Node node, int data){
        if(node == null){
            return false;
        }
        else{
            if(data == node.data){
                return true;
            }
            else if(data <= node.data){
                return lookup(node.left, data);
            }
            else{
                return lookup(node.right, data);
            }
        }
    }
    public void inorder(){
        inorder(root);
    }
    public void inorder(Node node){
        if(node != null){
            inorder(node.left);
            System.out.println(node.data);
            inorder(node.right);
        }
    }
    public void preorder(){
        preorder(root);
    }
    public void preorder(Node node){
        if(node != null){
            System.out.println(node.data);
            preorder(node.left);
            preorder(node.right);
        }
    }
    public void postorder(){
        postorder(root);
    }
    public void postorder(Node node){
        if(node != null){
            postorder(node.left);
            postorder(node.right);
            System.out.println(node.data);
        }
    }
    public static void main(String[] args){
        BinarySearchTree bt = new BinarySearchTree();
        bt.insert(8);
        bt.insert(4);
        bt.insert(12);
        bt.insert(2);
        bt.insert(6);
        bt.insert(10);
        bt.insert(14);
        bt.insert(1);
        bt.insert(3);
        bt.insert(5);
        bt.insert(7);
        bt.insert(9);
        bt.insert(11);
        bt.insert(13);
        bt.insert(15);
        bt.lookup(12);
        bt.lookup(17);
        bt.lookup(0);
        bt.inorder();
        bt.preorder();
        bt.postorder();
    }
}