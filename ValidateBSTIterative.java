//Time Complexity:O(N)
//Space Complexity:O(h) for stack space
import java.util.Stack;

public class ValidateBSTIterative {

    public boolean isValidBST(TreeNode root) {



         Stack<TreeNode> stack = new Stack<>();
         TreeNode currentNode = root;
         TreeNode prev = null;

         while(currentNode != null || !stack.isEmpty()){

             while(currentNode != null){
                 stack.push(currentNode);
                 currentNode = currentNode.left;
             }
             currentNode = stack.pop();
             if(prev != null && prev.val >= currentNode.val){
                 return false;
             }
             prev = currentNode;
             System.out.println(currentNode.val);
             currentNode = currentNode.right;
         }

        return true;
    }
}
