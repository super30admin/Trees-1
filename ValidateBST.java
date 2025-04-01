import java.util.ArrayList;
import java.util.*;

public class ValidateBST {
        static boolean flag;
        static TreeNode prev;

    public static boolean isValidBST(TreeNode root) {
        flag = true;
        helper(root);
        return flag;
    }

    public static void helper(TreeNode root)
    {
        if(root == null || !flag) return;
        helper(root.left);
        if(prev!= null && prev.val <=root.val) {
            flag = false;
        }

            prev = root;
        if(flag)
          helper(root.right);

    }

    public static void main(String [] args)
    {
     TreeNode left = new TreeNode(3);
     TreeNode right = new TreeNode(2);
     TreeNode root = new TreeNode(1,left,right);

     boolean result = isValidBST(root);
     System.out.print(result);

    }

}
