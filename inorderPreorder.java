//time complexity:O(n)
//space complexity:O(n)
class Solution {
    int index;//pointer on preorder array
    HashMap<Integer,Integer> map;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length==0) return null;
        map = new HashMap<>();
        for(int i=0;i<inorder.length;i++)
        {
            map.put(inorder[i],i);
        }
        return helper(preorder, 0, inorder.length-1);    
    }
    private TreeNode helper(int[] preorder, int start, int end)
    {
        if(start>end) return null;
        int rootVal=preorder[index];//current root value
        TreeNode root= new TreeNode(rootVal);
        index++;//increment to get the root in the subtrees
        int rootIdx=map.get(rootVal);//get the index of the respective root
        root.left=helper(preorder, start, rootIdx-1);//in inorder array
        //the elements to the left of the root form the left subtree
        root.right=helper(preorder,rootIdx+1,end);// and the elements to the 
        //right form the right subtree
        return root; 
        
    }
}
