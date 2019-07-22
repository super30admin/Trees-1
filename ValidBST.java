/**
 * Time Complexity:
 * Space Complexity:
 * Idea:
 * 1. For a BST, current node should be greater than all the nodes from its left sub tree
 * 2. For a BST, current node should be lesser than all the nodes from its right sub tree
 */

class ValidBST {

    public static class TreeNode {
             int val;
             TreeNode left;
             TreeNode right;
             TreeNode(int x) { val = x; }
         }

    public int findMax(TreeNode root){
        if(root == null) return 0;

        if(root.left == null && root.right == null)
            return root.val;
        

        if(root.left != null && root.right != null){
            int left = findMax(root.left);
            int right = findMax(root.right);
            return Math.max(Math.max(left, right), root.val);
        }

        if(root.left == null && root.right != null){
            return Math.max(root.val, findMax(root.right));
        }

        if(root.right == null && root.left != null){
            return Math.max(root.val, findMax(root.left));
        }

        return 0;
        
    }

    public int findMin(TreeNode root){
        if(root == null) return 0;

        if(root.left == null && root.right == null)
            return root.val;
        
        if(root.left != null && root.right != null){
            int left = findMin(root.left);
            int right = findMin(root.right);
            return Math.min(Math.min(left, right), root.val);
        }

        if(root.left == null && root.right != null){
            return Math.min(root.val, findMin(root.right));
        }

        if(root.right == null && root.left != null){
            return Math.min(root.val, findMin(root.left));
        }

        return 0;                      
    }
    public boolean isValidBST(TreeNode root) {
        

        if(root == null) return true;

        if(root.left != null && findMax(root.left) >= root.val){            
            return false;
        }
            
        
        if(root.right != null && findMin(root.right) <= root.val){
            return false;
        }
            

        // boolean left = isValidBST(root.left);
        // boolean right = isValidBST(root.right);
        

        return isValidBST(root.right) && isValidBST(root.left);
    }
    public static void main(String[] args){
        System.out.println("ValidBST");
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(15);
        root.right.right = new TreeNode(20);
        root.right.left = new TreeNode(6);

        ValidBST obj = new ValidBST();
        System.out.println(obj.isValidBST(root));
        System.out.println("Max "+ obj.findMax(root));

    }
}