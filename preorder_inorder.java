public class preorder_inorder {
    
}/**
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
    int idx;
    HashMap<Integer,Integer> map;
    public TreeNode buildTree(int[] preorder, int[] inorder) {

        // time complexity : O(n^2) as we are iterating n times at each node
        //space: O(n^2) as we are creating 2n size array at each node
        // approach: at each node, we check the preorder for root and inroder for the left and right subtrees of that root.then we save the
        //left subtree from inorder and preorder in inleft and preleft array, and the right subtree from inorder and preorder in inright and preright.
        // we repeat until the arrays are empty. 
        if(preorder.length==0) return null;
        int rootval=preorder[0];
        int idx=-1;
        for(int i=0;i<inorder.length;i++)
        {
            if(inorder[i]==rootval)
            {
                idx=i;
                break;
            }
        }
        int[] inleft=Arrays.copyOfRange(inorder,0,idx);
        int[] inright=Arrays.copyOfRange(inorder,idx+1,inorder.length);
        int[] preleft=Arrays.copyOfRange(preorder,1,inleft.length+1);
        int[] preright=Arrays.copyOfRange(preorder,inleft.length+1,preorder.length);
        TreeNode root=new TreeNode(rootval);
        root.left=buildTree(preleft,inleft);
        root.right=buildTree(preright,inright);
        return root;


        //time complexity: O(n)
        //space:O(n) Hasmap and stack space
        //approach: created a hashmap to save the values from inorder into it and fetch in O(1) time. then we take the root from preorder array.
        //find its index in the inorder.we take 2 pointers start and end.the start remains same, end becomes index-1 for the left node of the root
        //start becomes index+1 and end remains same for the right node of the root.




        this.idx=0;
        this.map = new HashMap<>();
        for(int i=0;i<inorder.length;i++)
        {
            map.put(inorder[i],i);
        }
        return helper(preorder,0,inorder.length-1);

    }
    public TreeNode helper(int[] preorder, int start, int end)
    {
        if(start>end) return null;
        int rootnode=preorder[idx];
        idx++;
        int rootval=map.get(rootnode);
        TreeNode root=new TreeNode(rootnode);
        root.left=helper(preorder,start,rootval-1);
        root.right=helper(preorder,rootval+1,end);
        return root;
    }

}
