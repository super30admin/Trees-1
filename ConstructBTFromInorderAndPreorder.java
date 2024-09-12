// Time complexity - O(n)
// Space Complexity - O(n) Recursive stack, Hashmap
// Leetcode passed - Yes

import java.util.HashMap;
import java.util.Map;

public class ConstructBTFromInorderAndPreorder {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        Map <Integer, Integer> inMap = new HashMap <>();

        // Storing inorder elements in hashmap to access in O(1) time
        for(int i = 0; i < inorder.length; i++) {
            inMap.put(inorder[i], i);
        }
        return buildTreehelper(preorder, 0, n-1, 0, n-1, inMap);
    }

    public TreeNode buildTreehelper(int[] preorder, int preStart, int preEnd, int inStart, int inEnd, Map <Integer, Integer> inMap) {
        // when the indices cross each other, that means we started moving in wrong direction, hence the node doesn't have any element as its child
        if(inStart > inEnd || preStart> preEnd) {
            return null;
        }
        // the element at preStart is the root node
        TreeNode root = new TreeNode(preorder[preStart]);
        // finding the inex of root node in the inorder array
        int rootIndex = inMap.get(preorder[preStart]);
        // Below approach would cost O(n) time, and overall Time is O(n^2) if we don't use the hashmap
        // int rootIndex = isI;
        // while(rootIndex<=ieI) {
        //     if(inorder[rootIndex] == preorder[psI]) {
        //         break;
        //     }
        //     rootIndex++;
        // }

        // finding the leftTreeLength
        int leftTreeLength = rootIndex-inStart;

        // Using recursion to fin right and left subtree's nodes
        // left Tree indices - preStart is preStart+1 and inEnd is rootIndex -1
        TreeNode left = buildTreehelper(preorder, preStart+1, preEnd, inStart, rootIndex-1, inMap);
        // right Tree indices -preEnd is preStart+leftTreeLength+1 and inStart is rootIndex+1
        TreeNode right = buildTreehelper(preorder, preStart+leftTreeLength+1, preEnd, rootIndex+1, inEnd, inMap);

        root.left = left;
        root.right = right;
        return root;
    }


    int idx; // index to kepp track of the current element
    Map <Integer, Integer> inMap;
    public TreeNode buildTree2( int[] preorder, int[] inorder){
        int n = preorder.length;
        inMap = new HashMap <>();
        idx = 0;

        // Storing inorder elements in hashmap to access in O(1) time
        for (int i = 0; i < inorder.length; i++) {
            inMap.put(inorder[i], i);
        }
        return buildTreehelper2(preorder, 0, n - 1);
    }

    public TreeNode buildTreehelper2(int[] preorder, int inStart, int inEnd){
        // when the indices cross each other, that means we started moving in wrong direction, hence the node doesn't have any element as its child
        if (inStart > inEnd) {
            return null;
        }
        // the element at idx is the root node
        TreeNode root = new TreeNode(preorder[idx]);
        // finding the index of root node in the inorder array
        int rootIndex = inMap.get(preorder[idx]);
        idx++; // incrementing it to pass the next element for the further calls

        // Using recursion to find right and left subtree's nodes
        // left Tree indices - start remains same, and inEnd is rootIndex -1
        TreeNode left = buildTreehelper2(preorder, inStart, rootIndex - 1);
        // right Tree indices - start is rootIndex+1, end remains same
        TreeNode right = buildTreehelper2(preorder, rootIndex + 1, inEnd);

        root.left = left;
        root.right = right;
        return root;
    }
}
