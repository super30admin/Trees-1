package BST;// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes

import java.util.HashMap;

public class BTFromInAndPreOrder {
    HashMap<Integer, Integer> map = new HashMap<>();
    int preOrderIdx = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {

        for(int i=0; i<inorder.length; i++)
        {
            map.put(inorder[i], i);
        }

        return helper(preorder, 0, inorder.length-1);
    }
    public TreeNode helper(int[] preorder, int start, int end){

        if(start > end) return null;

        int rootVal = preorder[preOrderIdx];
        preOrderIdx++;

        TreeNode node = new TreeNode();
        node.val = rootVal;

        int rootIdx = map.get(rootVal);

        node.left = helper(preorder,start,rootIdx-1);
        node.right = helper(preorder,rootIdx+1,end);
        return node;
    }
}
