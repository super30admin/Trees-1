// Time Complexity : O(n)
// Space Complexity : O(n); 
class BuildTree_Preorder_Inorder{
	static class TreeNode {
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
	int preorderIdx;
    Map<Integer, Integer> inorderMap;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        preorderIdx=0;
        inorderMap= new HashMap<>();
        for(int i=0; i<inorder.length; i++){
            inorderMap.put(inorder[i], i);
        }
        return helper(preorder, 0, preorder.length-1);
    }
    private TreeNode helper(int[] preorder, int left, int right) {
    	//base
        if(left > right) return null;
        
        //logic        
        //root= first element in preorder array (i.e.preorder= root->left->right)
        int rootVal= preorder[preorderIdx];
        preorderIdx++;
        TreeNode root= new TreeNode(rootVal);
        
        //root divides inorder array into two parts. Build left and right subtree.
        root.left=helper(preorder, left, inorderMap.get(rootVal)-1);
        root.right=helper(preorder, inorderMap.get(rootVal)+1, right);
        
        return root;
    }
	
	//Driver Code
	public static void main(String[] args) {
		BuildTree_Preorder_Inorder ob = new BuildTree_Preorder_Inorder();
		int[] inorder= {9,3,15,20,7};
		int[] preorder= {3,9,20,15,7};
		
		TreeNode root= ob.buildTree(preorder, inorder);
		System.out.println("Tree built from given preorder and inorder is: "+ root.val);
	}
}