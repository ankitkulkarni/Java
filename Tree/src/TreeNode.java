import java.util.ArrayList;
import java.util.List;
/**
 * Created by Ankit on 30-Oct-16.
 */
public class TreeNode {
    private String treeNodeId;
    private List<TreeNode> children = new ArrayList<>();
    private TreeNode parent;
    public TreeNode(TreeNode parent){
        this.parent = parent;
    }
    public void setId(String id){
        this.treeNodeId = id;
    }
    public String getId(){
        return treeNodeId;
    }
    public List<TreeNode> getChildren(){
        return children;
    }
    public TreeNode getParent(){
        return parent;
    }
}