class ConstructPreorderInorder {
    //  Time Complexity:    O(n^2)  ==>  Worst Case: left skewed [A,B,C,D], [D,C,B,A] ==> [A,B,null,C,null,D]
            // For  n recursions, we are searching in n elements
            // storing indexes of inorder traversal in a hashmap, for searching the index, can bring to O(n) time.
    //  Space Complexity:   O(n) ==> O(n) is recursion stack space and c is constant space for arrays created
            // can be reduced to O(n) by just passing the indexes instead of arrays, using hashmaps
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder == null || preorder.length == 0 || inorder == null || inorder.length == 0){
            return null;
        }
        // 1. Get the Root
        TreeNode root = new TreeNode(preorder[0]);
        
        // 2. Figure out the index in inorder array, thereby left and right subarray
        int index = -1;
        for(int i = 0; i < inorder.length; i++){
            if(root.val == inorder[i]){
                index = i;      // Found index
                break;
            }
        }
        
        // Inorder: Root splits inorder into left and right sub arrays  
            // [9,3,15,20,7] ==> [9], [15,20,7]
       // Preorder : [3,9,20,15,7] ==> [9], [20,15,7]
        int[] preLeft = Arrays.copyOfRange(preorder, 1, index+1);
        int[] inLeft = Arrays.copyOfRange(inorder, 0, index);
        
        int[] preRight = Arrays.copyOfRange(preorder, index+1, preorder.length);
        int[] inRight = Arrays.copyOfRange(inorder, index+1, inorder.length);
        
        // 3. Recursion call -> resolving left and right nodes of root
        root.left = buildTree(preLeft, inLeft);
        root.right = buildTree(preRight, inRight);
        

        return root;
    }
}