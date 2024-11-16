/*
 * TC - O(N)
 * SC - O(1)
 * Approach - The first element in the preorder will always be the root, and 
 * then we find it in the inorder. the ones before the root are left side of the tree
 * and after the root are right side of the tree. Continue this recursively.
 */ 

import java.util.HashMap;
import java.util.Map;

public class constructBtPreAndIn {
    //optimized way- 
    Map<Integer, Integer> map ;
    int idx;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.map = new HashMap<>();
        this.idx =0;
        for(int i = 0; i < inorder.length; i++){
            map.put(inorder[i], i);
        }
        return helper(preorder, 0, inorder.length-1);
    }

    public TreeNode helper(int[] preorder, int start, int end){
        if(start > end) return null;
        int rootVal = preorder[idx];
        TreeNode root = new TreeNode(rootVal);
        idx++;
        int rootIdx = map.get(rootVal);
        root.left = helper(preorder, start, rootIdx-1);
        root.right = helper(preorder, rootIdx + 1, end);

        return root;
    }   


    // public TreeNode buildTree(int[] preOrder, int[] inOrder) {
    //     //base case 
    //     if(preOrder.length == 0) return null;

    //     //logic 
    //     int rootVal = preOrder[0];
    //     int rootIdx = -1;
    //     for(int i = 0; i < inOrder.length; i++){
    //         if(rootVal == inOrder[i]){
    //             rootIdx = i;
    //             break;
    //         }
    //     }
    //     int inLeft[] = Arrays.copyOfRange(inOrder, 0, rootIdx);
    //     int inRight[] = Arrays.copyOfRange(inOrder, rootIdx+1, inOrder.length);
    //     int preLeft[] = Arrays.copyOfRange(preOrder, 1, inLeft.length+1);
    //     int preRight[] = Arrays.copyOfRange(preOrder, preLeft.length+1, preOrder.length);

    //     TreeNode root = new TreeNode(rootVal);
    //     root.left = buildTree(preLeft, inLeft);
    //     root.right = buildTree(preRight, inRight);

    //     return root;
    // }
}
