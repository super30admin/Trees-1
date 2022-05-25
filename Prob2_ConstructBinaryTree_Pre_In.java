
//TC and SC : O(N)  
class Solution {
    HashMap<Integer, Integer> map;
    int count; // ON Preorder of Tree
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder == null || preorder.length == 0)  return null;
        map = new HashMap<>();
        
        for(int i = 0; i< inorder.length; i++){
            map.put(inorder[i], i);
        }
        
        return helper(preorder, 0, inorder.length - 1);
        
    }
    public TreeNode helper(int[] preorder, int start, int end){ //START AND END ON INORDER ARRAY
        
        if(start > end) return null;
        int rootValue = preorder[count];
        
        int rootIndex = map.get(rootValue); //INdex of current root in INORDER array
        
        count++; // Next root from preorder
        
        TreeNode root = new TreeNode(rootValue);
        root.left = helper(preorder, start, rootIndex - 1); // Start = Parent node's start index -- // Parent was preorder[count]
        root.right = helper(preorder, rootIndex + 1, end); // end = Parent node's end index -- // Parent was preorder[count]
        
        return root;
    }
}

/*


//O(N^2) - beacaue In each recursive call, we are doing n iterations on inorder array
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder == null || preorder.length == 0)  return null;
        
        int rootValue = preorder[0];
        TreeNode root = new TreeNode(rootValue);
        
        //Find root in inorder traversal
        
        int rootIndex = -1;
        for(int i = 0; i< inorder.length; i++){
            if(inorder[i] == rootValue){
                rootIndex = i;
            }
        }
        
        int[] leftInorder = Arrays.copyOfRange(inorder, 0, rootIndex); // Range is 0 to rootIndex-1  
        int[] rightInorder = Arrays.copyOfRange(inorder, rootIndex + 1, inorder.length );
        
        int[] leftPreorder = Arrays.copyOfRange(preorder, 1, leftInorder.length + 1); // or we can also use range :  1 to rootIndex + 1  
        int[] rightPreorder = Arrays.copyOfRange(preorder, rootIndex + 1, preorder.length);
        
        root.left = buildTree(leftPreorder, leftInorder);
        root.right = buildTree(rightPreorder, rightInorder);
        
        
        return root;
        
    }
}

*/