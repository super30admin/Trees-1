/*Did this code successfully run on Leetcode :  Yes
Any problem you faced while coding this :  No
 */

import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreePreorderInorderTraversal_LC_105 {

    int index ;
    Map<Integer, Integer> indexMap;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int left = 0, right = preorder.length-1;
        indexMap = new HashMap<>();

        //Build hashmap from inoder so that you get the index of root since we are going to get root every single time from inoder array
        index = 0;
        for(int i =0; i<inorder.length; i++){
            indexMap.put(inorder[i], i);
        }


        //index = postorder.length -1;
        return helper(preorder,left,right);

    }


    private TreeNode helper(int[] preorder, int left, int right){

        //This is to identify the null nodes for partiular root
        if(left > right)
            return null;

        int val = preorder[index++];

        TreeNode root =  new TreeNode(val);

        root.left = helper( preorder, left, indexMap.get(root.val) -1);

        root.right = helper( preorder, indexMap.get(root.val)+1, right);

        return root;

    }
}
