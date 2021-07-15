import java.util.Stack;

import javax.swing.tree.TreeNode;

public class validateBST_Iterative {
    public boolean isValidBST(TreeNode root) {        
        if(root == null)
            return false;      
        Stack<TreeNode> stack = new Stack<>();
        TreeNode prevNode = null;
        while(root != null || !stack.isEmpty()){
            while(root != null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if(prevNode != null && prevNode.val >= root.val)
                return false;            
            prevNode = root;            
            root = root.right;
        }
        return true;
    }
}

//The tome complexity is O(N), where N is the number of nodes.
//The space complexity is O(h), where h is the height of the tree.


