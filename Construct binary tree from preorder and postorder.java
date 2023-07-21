// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Your code here along with comments explaining your approach: Since the first element of the preorder is always the root, we will look for that root in the inorder array using a hashmap. Then we will set that as the rootIdx. 
//This will help us set the range for the left and the right subtree. The range for left subtree is from the start to the rootIdx-1 and for right subtree is rootIdx+1 to the end. 


class Solution {
    int idx;
    HashMap<Integer,Integer> map;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.map=new HashMap<>();
        //Storing the values of Inorder in HashMap

        for(int i=0;i<inorder.length;i++)
        {
            map.put(inorder[i],i);
        }
        return helper(preorder,0,inorder.length-1,0);

    }

    private TreeNode helper(int[] preorder, int start, int end,int rootIdx)
  {  //baseif 
    if(start>end) return null;
    //logic
    int rootval=preorder[idx];
    idx++;
    //search for the rootval in inorder
    rootIdx=map.get(rootval);
    //Construct the tree
    TreeNode root=new TreeNode(rootval);

    root.left=helper(preorder,start,rootIdx-1,rootIdx);
    root.right=helper(preorder,rootIdx+1,end,rootIdx);

    return root;
}


}
