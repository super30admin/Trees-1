//Time Complexity : O(nodes in the tree)
//Space Complexity: O(depth of tree)

/*Approach
- doing the inorder traversal and if the tree is valid then previous element in inorder will be 
always less than the next one
-in inorder traversal storing the previous value and if it breaks our rule we just return false
 */
import java.util.Stack ;
public class ValidBST{
     public static class TreeNode {
             int val;
             TreeNode left;
             TreeNode right;
             TreeNode(int x) { val = x; }
        }
       
    public boolean isValidBST(TreeNode root) {
        if(root == null) return true;
        Stack<TreeNode> stk = new Stack<>();
        TreeNode prev = null;
        while(root != null || !stk.isEmpty()){
            while(root!= null){
                stk.push(root);
                root = root.left;
            }
            root = stk.pop();
            if(prev != null && prev.val >= root.val)return false;
            prev = root;
            root = root.right;
        }
        return true;
        
    }
    //recursive
    TreeNode prevr = null;
    public boolean isValidBSTRecursive(TreeNode root) {
        if(root == null) return true;
        return inorder(root);
    }
    private boolean inorder(TreeNode root){
        if(root == null) return true;
        if(inorder(root.left)== false) return false;
        if(prevr != null && prevr.val >= root.val)return false;
        prevr = root;
        return inorder(root.right);
    }

    public static void main(String args[]){
       ValidBST obj = new ValidBST();
       TreeNode root = new TreeNode(50);
       root.left=new TreeNode(40);
       root.left.left= new TreeNode(25);
       root.left.right= new TreeNode(45);
       root.right = new TreeNode(70);
       root.right.left=new TreeNode(63);
       root.right.right=new TreeNode(75);
       System.out.println(obj.isValidBST(root));
       System.out.println(obj.isValidBSTRecursive(root));

    }

}