import java.util.Stack;

//Definition for a binary tree node.
 
 class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
       this.val = val;
       this.left = left;
        this.right = right;
     }

    }
//sc- o(h)
//tc-o(n)
public class Solution {


public static void main(String args[])
{
    TreeNode root = [50,37,60,30,45,55,70,15,32,38,46,53,59,65,100];
    boolean result = isValidBST(root);

}




    public boolean isValidBST(TreeNode root) {
    Stack<TreeNode>st = new Stack<>();
        TreeNode prev = null;
        while(root!=null || !st.isEmpty())
        {
            while(root!=null)
            {
            st.push(root);
            root = root.left;
            }
            root = st.pop();
            
            
            if(prev!= null && prev.val>=root.val)
            {
                return false;
            }
            prev = root;
            root = root.right;
        }
        
        return true;
    }
  
}
 