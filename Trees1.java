//validate binary search tree
//Time Complexity O(N) and space complexity O(N)
class Solution {

    
    public boolean isValidBST(TreeNode root) {
      
        return helper(root,null,null);
    }

    public boolean helper(TreeNode root, Integer high, Integer low){

        if(root==null) return true;

        if(low!=null && root.val <= low) return false;

        if(high!=null && root.val >=high) return false;

        boolean left = helper(root.left,root.val,low);

        boolean right = helper(root.right,high,root.val);

        return left && right;
       
    }
}



//construct tree from inorder and preorder
//Time complexity O(N) and Space complexity O(N)
class Solution {
    int preorderIndx;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        preorderIndx=0;
        HashMap<Integer,Integer> map = new HashMap<>();

        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }

        return buildPath(map,0,inorder.length-1,preorder);
        
    }

    public TreeNode buildPath(HashMap<Integer,Integer> map, int left, int end, int[] preorder){

        if(left>end) return null;

        int rootVal = preorder[preorderIndx];
        preorderIndx++;
        TreeNode root = new TreeNode(rootVal);

        int rootIdx = map.get(rootVal);

        root.left = buildPath(map,left,rootIdx-1,preorder);
        root.right = buildPath(map,rootIdx+1,end,preorder);
        return root;
    }
}
