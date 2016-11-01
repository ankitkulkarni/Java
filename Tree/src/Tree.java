/**
 * Created by Ankit on 30-Oct-16.
 */
public class Tree {
    public static void main(String[] args){
        TreeNode rootNode = new TreeNode(null);
        rootNode.setId("root");
        TreeNode childNodel = addChild(rootNode, "childL1");
        TreeNode l1childl1 = addChild(childNodel, "l1-childl1");
        addChild(childNodel, "l1-childr1");
        TreeNode childNoder = addChild(rootNode, "childR1");
        addChild(childNoder, "r1-childr1");
        printTree(" ", rootNode);
        System.out.println("Parent of l1childl1: " + l1childl1.getParent().getId());
        System.out.println("Id of ChildNodel: " + childNodel.getId());
    }
    public static TreeNode addChild(TreeNode parent, String treeNodeId){
        TreeNode node = new TreeNode(parent);
        node.setId(treeNodeId);
        parent.getChildren().add(node);
        return node;
    }
    public static void printTree(String appendThis, TreeNode node){
        System.out.println(appendThis + node.getId());
        for(TreeNode treenode: node.getChildren()){
            printTree(appendThis + appendThis, treenode);
        }
    }
}
