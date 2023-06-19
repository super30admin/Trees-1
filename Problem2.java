package Trees1;

import java.util.HashMap;

/**
 * 
 * We do know the the first element of preorder array is always the current root and we can deduce span of left and right subtree using inorder array.
 * We use pointers to vary the low and high of both arrays and recursively construct left subtree and then the right subtree using the corresponding inorder and preorder arrays.
 * 
 * Time Complexity :
 * O(n) - where n is the no of nodes.
 * 
 * Space Complexity :
 * O(n), actually is the height of the tree in worst case(skewed tree)
 * 
 * Did this code successfully run on Leetcode : yes
 * 
 * Any problem you faced while coding this : No
 */

public class Problem2 {
    HashMap<Integer,Integer> map=new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for(int i=0;i<preorder.length;i++){
            map.put(inorder[i],i);
        }
        return helper(preorder,0,preorder.length-1,inorder,0,inorder.length-1);
        
    }

    TreeNode helper(int[] preorder,int leftPre,int rightPre, int[] inorder, int leftIn, int rightIn){

        //base
        if(rightPre<leftPre || rightIn<leftIn)
            return null;

        //logic
        int currentNodeVal=preorder[leftPre];
        TreeNode currNode=new TreeNode(currentNodeVal);

        //the no of elements to the left of the currNode in Inorder array
        int leftDiff=map.get(currentNodeVal)-leftIn;

        //leftsubtree
        currNode.left= helper(preorder,leftPre+1, leftPre+leftDiff, inorder,leftIn, map.get(currentNodeVal)-1 );

        //rightsubtree
        currNode.right= helper(preorder,leftPre+leftDiff+1, rightPre, inorder,map.get(currentNodeVal)+1, rightIn );

        return currNode;

    }

}
