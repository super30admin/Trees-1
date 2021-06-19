class BuildTreeWithPreorderInorder{

    // Time  - O(n^2)
    // Space  - O(n^2) -  for every root creating extra arrays
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length == 0) return null;
        int rootval = preorder[0];
        TreeNode root = new TreeNode(rootval);
        int rootIdxInorder = 0;
        for(int i=0; i<inorder.length; i++){
            if(root.val == inorder[i])
                rootIdxInorder = i;
        }

        int[] preLeft = Arrays.copyOfRange(preorder, 1, rootIdxInorder+1);
        int[] preRight = Arrays.copyOfRange(preorder, rootIdxInorder+1, preorder.length);
        int[] inLeft = Arrays.copyOfRange(inorder, 0, rootIdxInorder);
        int[] inRight = Arrays.copyOfRange(inorder, rootIdxInorder+1, inorder.length);

        root.left = buildTree(preLeft, inLeft);
        root.right = buildTree(preRight, inRight);
        return root;
    }

    // Time  - O(n)
    // Space  - O(n)
    HashMap<Integer, Integer> map;
    int indexPre;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        map = new HashMap<>();
        indexPre = 0;

        //put inorder in HashMap to find root index
        for(int i=0 ;i<inorder.length; i++){
            map.put(inorder[i], i);
        }
        return helper(preorder, inorder, 0, inorder.length-1);
    }

    private TreeNode helper(int[] preorder, int[] inorder, int start, int end){
        //base
        if(start > end) return null;

        //logic
        int rootVal = preorder[indexPre];
        indexPre++;
        TreeNode root = new TreeNode(rootVal);
        int indexIn = map.get(rootVal);
        root.left = helper(preorder, inorder, start, indexIn-1);
        root.right = helper(preorder, inorder, indexIn+1, end );
        return root;
    }
}