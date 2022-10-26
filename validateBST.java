// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this : no

//     * Definition for a binary tree node.
//     * public class TreeNode {
//     *     int val;
//     *     TreeNode left;
//     *     TreeNode right;
//     *     TreeNode() {}
//     *     TreeNode(int val) { this.val = val; }
//     *     TreeNode(int val, TreeNode left, TreeNode right) {
//     *         this.val = val;
//     *         this.left = left;
//     *         this.right = right;
//     *     }
//}

    public class validateBST {
        long prevNode = Long.MIN_VALUE;

        public boolean isValidBST(TreeNode root) {

            return isValidBSTTraverse(root);
        }

        public boolean isValidBSTTraverse(TreeNode node){

            if(node == null){
                return true;
            }

            Boolean isLeft = isValidBSTTraverse(node.left);
            Boolean isBinary = prevNode < node.val;
            prevNode = node.val;
            Boolean isRight = isValidBSTTraverse(node.right);
            return isLeft && isBinary && isRight;
        }

    }
