//TC: O(n)
//SC: O(n)
// use the definition of binary search tree -- sorted order property
//predecessor value is less than next value in ascending order

//works in leetcode
public class BinarySearchTree {
    private static long inordPredecessor;

    public static  boolean isValidBST(TreeNode root) {
        inordPredecessor = Long.MIN_VALUE;
        return isValidBSTRecursive(root);
    }
    private static  boolean isValidBSTRecursive(TreeNode node) {

        if(node==null){
            return true;
        }


        //left subtree
        boolean left =  isValidBSTRecursive(node.left);

        boolean curr = node.val > inordPredecessor;
        inordPredecessor = node.val;

        //right subtree
        boolean right = isValidBSTRecursive(node.right);


        return left && curr && right;
    }


    public static void main(String [] args){
        TreeNode leaf1 = new TreeNode(1,null,null);
        TreeNode leftLeaf  = new TreeNode(3,null,null);
        TreeNode rightLeaf = new TreeNode(6,null,null);

        TreeNode root1 = new TreeNode(4,leftLeaf,rightLeaf);

        TreeNode root = new TreeNode(5,leaf1,root1);

        System.out.println(isValidBST(root));
    }
}

