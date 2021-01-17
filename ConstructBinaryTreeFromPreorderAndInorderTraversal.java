// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Understanding the recursive solution

// Notes : FInd the root from the Preorder array, and find the index of that root in the Inorder array. Based on that index, go towards the left and right of the Preorder array and populate the left and right trees from the root.

public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
    //Solution 1: Recursive
    HashMap<Integer, Integer> map;
    int index = 0;
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {

        if(preorder.length == 0) return null;
        
        map = new  HashMap<Integer, Integer>();
        
        for(int i = 0; i < inorder.length; i++){
            map.put(inorder[i], i);
        }

        return helper(preorder, 0, preorder.length - 1);
        
    }
    
    private TreeNode helper(int[] preorder, int start, int end){
        if(start > end)
            return null;
            
        TreeNode root = new TreeNode(preorder[index]);

        int rootIdx = map.get(preorder[index]);
        
        index++;

        root.left = helper(preorder, start, rootIdx-1);
        root.right = helper(preorder, rootIdx+1, end);
        
        return root;
    }


    //Solution 2: Iterative
    // public TreeNode buildTree(int[] preorder, int[] inorder) {

    //     if(preorder.length == 0) return null;
        
    //     TreeNode root = new TreeNode(preorder[0]);
        
    //     int index ;
    //     for(index = 0; index < preorder.length ; index++){
    //         if(preorder[0] == inorder[index]){
    //             break;
    //         }
    //     }
         
    //     int [] preLeft = Arrays.copyOfRange(preorder, 1, index+1);
    //     int [] inLeft = Arrays.copyOfRange(inorder, 0, index);
        
    //     int [] preRight = Arrays.copyOfRange(preorder, index+1, preorder.length);
    //     int [] inRight = Arrays.copyOfRange(inorder, index+1, inorder.length);
        
    //     root.left = buildTree(preLeft, inLeft);
    //     root.right = buildTree(preRight, inRight);
        
    //     return root;
    // }
}