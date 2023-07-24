// Time Complexity :O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No problem


// Your code here along with comments explaining your approach
class Solution {
    // boolean flag;
    // TreeNode prev;
    // public boolean isValidBST(TreeNode root) {
    //     this.flag=true;
    //     inorder(root);
    //     return flag;
    // }

    // //inorder Traversal
    // public void inorder(TreeNode root) {
    //     if(root==null) return;
    //     System.out.println(root.val);
    //     if(flag)
    //         inorder(root.left);
        
    //     if(prev!=null && prev.val>=root.val){
    //         flag=false;
    //     }
    //     prev=root;
    //     if(flag)
    //         inorder(root.right);

    // }

    //2nd way of doing it
    // boolean flag;
    // TreeNode prev;
    // public boolean isValidBST(TreeNode root) {
    //     this.flag=true;
    //     return inorder(root);
    // }

    // //inorder Traversal
    // public boolean inorder(TreeNode root) {
    //     if(root==null) return true;
    //     System.out.println(root.val);
    //     boolean left= inorder(root.left);
        
    //     if(prev!=null && prev.val>=root.val){
    //         return false;
    //     }
    //     prev=root;
    //     boolean right= inorder(root.right);
    //     return left && right;
    // }

    //3rd way of doing it
    // TreeNode prev;
    // boolean flag;
    // public boolean isValidBST(TreeNode root) {
    //     this.flag = true;
    //     inorder(root);
    //     return flag;
    // }
    //   private void inorder(TreeNode root){
    //     // base
    //     if(root == null) return;
    //     System.out.println(root.val);
    //     inorder(root.left);
    //     //st.pop();
    //     if(prev != null && prev.val >= root.val){
    //         flag = false;
    //         return;
    //     }
    //     prev = root;
    //     inorder(root.right);
    //     //st.pop();
    // }

    //with range check
    boolean flag;
    public boolean isValidBST(TreeNode root) {
        this.flag=true;
        inorder(root, null,null);
        return flag;
    }

    //inorder Traversal
    public void inorder(TreeNode root, Integer min, Integer max) {
        //base condition
        if(root==null) return; //leaf node condition
        if(min!=null && root.val<=min) flag=false; ////root has to be greater than min, else false
        if(max!=null && root.val>=max) flag=false; //root has to be greater than max, else false
        //logic
        if(flag) //conditional recursion
            inorder(root.left, min, root.val);
        if(flag) //conditional recursion
            inorder(root.right, root.val, max);
    }
}


//Problem 2: BST from Inorder/Preorder 
// Time Complexity :O(m+n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No problem


// Your code here along with comments explaining your approach
class Solution {
    int idx; // preorder index for getting next root
    Map<Integer, Integer> map; //to store inorder values for O(1) searching
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.map = new HashMap<>();

        for(int i=0;i<inorder.length;i++)
            map.put(inorder[i],i);
        
        return inorderTraversal(preorder, 0, inorder.length-1, 0); //Inorder-> root, left, right, so root index is 0
    }
    private TreeNode inorderTraversal(int[] preorder, int start, int end, int rootIdx){

        //base
        if(start>end) return null;

        //logic
        int rootVal = preorder[idx];
        idx++; //to get next root from preorder in next recursion

        rootIdx=map.get(rootVal);
        TreeNode root = new TreeNode(rootVal);

        root.left=inorderTraversal(preorder, start , rootIdx-1, rootIdx); //recursive call to left subarray start-rootIdx-1
        root.right=inorderTraversal(preorder, rootIdx+1, end, rootIdx); //recursive call to right SubArray rootIdx+1- end

        return root;
    }
}