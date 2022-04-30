//Time Complexity:O(N)
//Space Complexity:O(h) for stack space
public class ValidateBST2 {
    public boolean isValidBST(TreeNode root) {

        return inorder(root, null, null);
    }

    public boolean inorder(TreeNode root, Integer min, Integer max){

        if(root == null){ // If is has reached till leaf nodes till now no issues
            return true;
        }


        boolean left = inorder(root.left,min,root.val);

        if((min != null && root.val <= min) || (max != null && root.val >= max)){
            return false;
        }

        boolean right = inorder(root.right,root.val,max);


        return left && right;

    }
}
