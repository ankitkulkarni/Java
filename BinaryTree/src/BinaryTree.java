/**
 * Created by Ankit on 31-Oct-16.
 */
public class BinaryTree {
    public static void main(String[] args) {
        Node a = new Node(8);
        Node b = new Node(4);
        Node c = new Node(2);
        Node d = new Node(6);
        Node e = new Node(1);
        Node f = new Node(3);
        Node g = new Node(5);
        Node h = new Node(7);
        Node i = new Node(12);
        Node j = new Node(10);
        Node k = new Node(14);
        Node l = new Node(9);
        Node m = new Node(11);
        Node n = new Node(13);
        Node o = new Node(15);
        a.left = b;
        a.right = i;
        b.left = c;
        b.right = d;
        c.left = e;
        c.right = f;
        d.left = g;
        d.right = h;
        i.left = j;
        i.right = k;
        j.left = l;
        j.right = m;
        k.left = n;
        k.right = o;
        System.out.println("In-Order Traversal: ");
        inorder(a);
        System.out.println("Pre-Order Traversal: ");
        preorder(a);
        System.out.println("Post-Order Traversal: ");
        postorder(a);
    }
    public static void inorder(Node n){
        if(n != null){
            inorder(n.left);
            System.out.println(n.data);
            inorder(n.right);
        }
    }
    public static void preorder(Node n){
        if(n != null){
            System.out.println(n.data);
            preorder(n.left);
            preorder(n.right);
        }
    }
    public static void postorder(Node n){
        if(n != null){
            postorder(n.left);
            postorder(n.right);
            System.out.println(n.data);
        }
    }
}
