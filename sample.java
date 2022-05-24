import java.util.HashMap;
class TreeNode {
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
//Valid BST
//Time Complexity : O(N)
//Space Complexity : O(N)
class Solution {
    TreeNode prev;
    boolean isValid;
    public boolean isValidBST(TreeNode root) {
        prev=null;
        isValid=true;
        inorder(root);
        return isValid;
    }
    //Inorder traversal
    public void inorder(TreeNode root){
        if(root==null) return;
        //got to the left last element
        inorder(root.left);
        //previous val > than root make isValid false
        if(prev!=null && prev.val >= root.val){
            isValid=false;
            return;
        }
        //if previous is previously null assign it to root
        prev = root;
        //go to right last element
        inorder(root.right);
    }
}


//Construct Binary Tree from Preorder and Inorder Traversal
//Time complexity : O(N)
//Space complexity : O(N)
class Solution1 {

    int pre;
    HashMap<Integer, Integer> inmap;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
       pre = 0;
        // build a hashmap to store value -> its index relations
        inmap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inmap.put(inorder[i], i);
        }

        return arrayToTree(preorder, 0, preorder.length - 1);
    }

    private TreeNode arrayToTree(int[] preorder, int left, int right) {
        // if there are no elements to construct the tree
        if (left > right) return null;

        // select the preorder_index element as the root and increment it
        int rootValue = preorder[pre++];
        TreeNode root = new TreeNode(rootValue);

        // build left and right subtree
        // excluding inmap[rootValue] element because it's the root
        root.left = arrayToTree(preorder, left, inmap.get(rootValue) - 1);
        root.right = arrayToTree(preorder, inmap.get(rootValue) + 1, right);
        return root;
    }
} 

