/**
 * Definition for a binary tree node.
 */
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

//TC: O(N) SC: O(N)
public class ValidateTree {
    boolean flag;
    public boolean isValidBST(TreeNode root) {
        return helper(root, null, null);
    }

    private boolean helper(TreeNode root, Integer low, Integer high) {
        if(root == null) return true;
        if((low!= null && root.val <= low) || (high != null && root.val >= high)) {
            return false;
        }
        
        return helper(root.left, low, root.val) && helper(root.right, root.val, high);
    }
}



// public boolean isValidBST(TreeNode root) {
//         return inorder(root);
//     }

//     public boolean inorder(TreeNode root) {
//         //base
//         if(root == null) return true;
//         //logic
//         if(!inorder(root.left)) return false;
//         if(prev != null && prev.val >= root.val) return false;
//         prev = root;
//         return inorder(root.right);
//     }

// boolean flag;
//     public boolean isValidBST(TreeNode root) {
//         this.flag = true;
//         inorder(root, null);
//         return flag;
//     }

//     public void inorder(TreeNode root, TreeNode prev) {
//         //base
//         if(root == null) return;
//         // if(!flag) return;
//         System.out.println(root.val);
//         //logic
//         if(flag) inorder(root.left, prev);
//         // prev > curr
//         if(prev != null && prev.val >= root.val) {
//             flag = false;
//         }
//         prev = root;
//         if(flag) inorder(root.right, prev);
//     }
