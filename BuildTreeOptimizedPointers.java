// Time Complexity : O(n)
// Space Complexity : O(n) // HashMap
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : -

import java.util.HashMap;
import java.util.Map;

//Use indexing to set logical boundaries of left and right subtrees in preorder array
//Recursively call helper function for left and right subtrees and keep adding their root to new tree
public class BuildTreeOptimizedPointers {

    //global preorder root idx
    int pIdx;
    //HashMap of inorder array to fetch indexes in O(1)
    Map<Integer, Integer> inMap = new HashMap();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int idx = 0;
        pIdx = 0;

        for(int i: inorder)
            inMap.put(i, idx++); //O(n)

        return helper(preorder, 0, preorder.length -1, 0);
    }

    //helper function iterates through the preorder nums to build the tree for each element in preorder O(n)
    private TreeNode helper(int[] preorder, int sIdx, int eIdx, int rIdx){
        //base
        if(sIdx>eIdx) return null;

        //root value
        int rootVal = preorder[pIdx];
        pIdx++;
        TreeNode root = new TreeNode(rootVal);

        rIdx = inMap.get(rootVal);
        System.out.println(rootVal+ " "+ sIdx+ " "+ ((int)rIdx-1)+ " " + rIdx );
        root.left = helper(preorder,sIdx, rIdx -1, rIdx);
        System.out.println(rootVal+ " "+ rIdx+1+ " "+ eIdx+ " " + rIdx );
        root.right = helper(preorder,rIdx+1, eIdx, rIdx);

        return root;
    }


    public static void main(String[] args) {
        BuildTreeOptimizedPointers p = new BuildTreeOptimizedPointers();
        TreeNode n = p.buildTree(new int[]{3,9,5,4,20,15,7}, new int[]{5,9,4,3,15,20,7});
        System.out.println(n);
    }
}
