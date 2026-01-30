// Solution-1

// TimeComplexity: O(n)
// SpaceComplexity: O(n)
// Explanation : We use preorder to pick the root nodes in order.Then we use a HashMap of inorder values to quickly find the root index. 
// Then recursively build left and right subtrees using inorder boundaries. The preIndex tracks the current root in preorder.

class Solution {
    int preIndex= 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> inorderMap = new HashMap<>();
        for(int i=0; i < inorder.length; i++){
            inorderMap.put(inorder[i], i);
        }
        return helper(preorder, inorderMap, 0 , inorder.length-1);    
    }

    private TreeNode helper(int[] preorder, Map<Integer, Integer> inorderMap, int inleft, int inright) {
        if(inleft>inright) return null;
        TreeNode root = new TreeNode(preorder[preIndex]);
        preIndex++;
    
        
        int rootidx = inorderMap.get(root.val);
       
        root.left = helper(preorder, inorderMap,inleft, rootidx-1);
        root.right = helper(preorder, inorderMap,rootidx+1, inright);
        return root;   
    }
}

// Solution -2

// TimeComplexity: O(n)
// SpaceComplexity: O(n)
// Explanation : I am building the binary tree recursively by taking the first element of the current preorder range as the root. 
// Using a HashMap of inorder values, I quickly find the root’s position in the inorder array, which tells me how many nodes belong to the left subtree. 
// I then recursively construct the left and right subtrees by updating the preorder and inorder ranges according to the size of the left subtree, until the entire tree is built.


class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> inorderMap = new HashMap<>();
        for(int i=0; i < inorder.length; i++){
            inorderMap.put(inorder[i], i);
        }
    
        
        return helper(preorder, inorderMap, 0, preorder.length -1, 0 , inorder.length-1);
        
        
    }
    private TreeNode helper(int[] preorder, Map<Integer, Integer> inorderMap, int preleft, int preright, int inleft, int inright) {
        if(inleft>inright || preleft>preright) return null;
        TreeNode root = new TreeNode();
        root.val =preorder[preleft];
        int count = inorderMap.get(root.val) - inleft;
       
        root.left = helper(preorder, inorderMap, preleft+1, preleft+count, inleft, inleft+count-1);
        root.right = helper(preorder, inorderMap, preleft+count+1, preright, inleft+count+1, inright);
        return root;   
    }
}
