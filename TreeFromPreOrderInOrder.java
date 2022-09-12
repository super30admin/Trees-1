// Time Complexity : O(n) where n is the number of nodes
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach
//Method 2- Using HashMap and 2 pointers and avoiding creating new array each time

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
    int idx; //to iterate on preorder
    HashMap<Integer ,Integer> map;
    public TreeNode buildTree(int[] preorder, int[] inorder) {

        if(preorder.length == 0)
            return null;

        map = new HashMap<>();

        for(int i = 0; i < inorder.length ; i++){
            map.put(inorder[i] ,i);
        }

        return helper(preorder,0,inorder.length-1);
    }

    private TreeNode helper(int[] preorder, int start , int end){

        //base case
        if(start > end)
            return null;

        //logic
        int rootVal = preorder[idx];
        int rootIdx = map.get(rootVal);
        idx++;

        TreeNode root = new TreeNode(rootVal);

        root.left = helper(preorder,start,rootIdx-1);
        root.right = helper(preorder,rootIdx+1,end);

        return root;
    }
}



/*
Method 1- recursion
TC: O(n^2) and SC: O(n^2) where n is the number of nodes
 */
public class TreeFromPreOrderInOrder {
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

            if(preorder.length == 0)
                return null;

            int rootVal = preorder[0];

            TreeNode root = new TreeNode(rootVal);

            int idx =-1;

            //finding root in inorder array
            for(int i = 0 ; i < inorder.length ; i++){
                if(inorder[i] == rootVal){
                    idx = i;
                    break;
                }
            }

            int[] inleft = Arrays.copyOfRange(inorder,0,idx);
            int[] preleft = Arrays.copyOfRange(preorder,1,inleft.length + 1);
            int[] inright = Arrays.copyOfRange(inorder,idx  + 1, inorder.length);
            int[] preright = Arrays.copyOfRange(preorder,inleft.length + 1,preorder.length);

            root.left = buildTree(preleft,inleft);
            root.right = buildTree(preright,inright);

            return root;

        }
    }
}
