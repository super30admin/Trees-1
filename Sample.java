class Sample{
/***********************************PROBLEM 1**********************/
    //TC:O(N)
    //SC:0(H) , H=height of tree
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode() {}
     *     TreeNode(int val) { this.val = val; }
     *     TreeNode(int val, TreeNode left, TreeNode right) {
     *         this.val = val;
     *         this.left = left;
     *         this.right = right;
     *     }
     * }
     */
    class Solution {
        TreeNode prev;
        boolean isValid;
        public boolean isValidBST(TreeNode root) {
            isValid=true;
            recurseInorder(root);
            return isValid;
        }

        private void recurseInorder(TreeNode root){
            if(root==null){
                return;
            }
            recurseInorder(root.left);
            if(prev!=null && prev.val>=root.val){
                isValid=false;
                return;
            }
            prev=root;
            recurseInorder(root.right);
        }
    }

    //Check if the element lies between min and max
    //TC :0(n)
    //SC :0(h)
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode() {}
     *     TreeNode(int val) { this.val = val; }
     *     TreeNode(int val, TreeNode left, TreeNode right) {
     *         this.val = val;
     *         this.left = left;
     *         this.right = right;
     *     }
     * }
     */

    class Solution {
        boolean isValid;
        public boolean isValidBST(TreeNode root) {
            if(root==null){
                return true;
            }
            isValid=true;
            checkValidity(root,null,null);
            return isValid;
        }

        private void checkValidity(TreeNode root,Integer min, Integer max){
            if(root==null){
                return;
            }
            checkValidity(root.left,min,root.val);
            if((min!=null && root.val<=min)||(max!=null && root.val>=max)){
                isValid=false;
                return;
            }
            checkValidity(root.right,root.val,max);
        }
    }
    

    /***********************************PROBLEM 2**********************/
//TC:O(H*H)
// SC:0(H) , H=height of tree
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode() {}
     *     TreeNode(int val) { this.val = val; }
     *     TreeNode(int val, TreeNode left, TreeNode right) {
     *         this.val = val;
     *         this.left = left;
     *         this.right = right;
     *     }
     * }
     */
    class Solution {
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            if(preorder==null || preorder.length==0 || inorder.length==0){
                return null;
            }
            TreeNode root=new TreeNode(preorder[0]);
            int rootIndex=-1;
            for(int i=0;i<inorder.length;i++){
                if(inorder[i]==root.val){
                    rootIndex=i;
                    break;
                }
            }
            int[] inorderLeft=Arrays.copyOfRange(inorder,0,rootIndex);
            int[] inorderRight=Arrays.copyOfRange(inorder,rootIndex+1,inorder.length);
            int[] preorderLeft=Arrays.copyOfRange(preorder,1,rootIndex+1);
            int[] preorderRight=Arrays.copyOfRange(preorder,rootIndex+1,preorder.length);
            root.left=buildTree(preorderLeft,inorderLeft);
            root.right=buildTree(preorderRight,inorderRight);
            return root;
        }
    }


}