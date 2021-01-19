// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : some difficulty understanding how preorder/inorder traversal
//works


// Your code here along with comments explaining your approach
//we will use inorder array to find where all the roots are, and go through
//the preorder array. In the inorder array the left and right of a root rep. the left and right
//sub trees, so we recursively keep finding the roots until we get to leaf nodes, and make a TreeNode at each root.


public class BuildTree {
    int idx = 0;
    HashMap <Integer, Integer>  mp = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length == 0) return null;



        for(int i = 0; i< inorder.length; i++){
            mp.put(inorder[i], i);
        }

        return helper(preorder, 0, preorder.length - 1);
    }

    public TreeNode helper(int[] preorder, int start, int end){
        //base
        if(start > end){
            return null; //reached bottom of tree
        }


        //logic

        //make the node
        int rootVal = preorder[idx];

        TreeNode root = new TreeNode(rootVal);

        idx++;
        //find its place in the inorder array to find left and right subtrees
        int ridx = mp.get(rootVal);

        root.left = helper(preorder, start, ridx - 1);
        root.right = helper(preorder, ridx + 1, end);
        return root;


    }
}