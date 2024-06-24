// ## Problem 2
//https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/


// Using the fact that first node in preorder is always the root of current tree
// find that root in in-order, all nodes to left will be a part of left subtree
// and all nodes to the right will be a part of right subtree
// Do this recursicely
// Time Complexity: O(N)
// Space Complexity: O(Height of tree(recursive stack space) + N(for hashmap))

class Solution {
    int p;
    Map<Integer, Integer> mappy;

    private TreeNode helper(int[] preorder, int[] inorder, int ii, int ij){
        if(ii==ij){
            //base
            return null;
        }

        //logic
        int rootVal = preorder[p];
        TreeNode root = new TreeNode(rootVal);
        p++;

        // find root index in inorder
        int k=mappy.getOrDefault(rootVal, ii);
        while(k<ij && inorder[k]!=rootVal){
            if(!mappy.containsKey(inorder[k])){
                mappy.put(inorder[k], k);
            }
            k++;
        }

        root.left = helper(preorder, inorder, ii, k);
        root.right = helper(preorder, inorder, k+1, ij);

        return root;
    }


    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // Hashmap to optimize search
        this.mappy=new HashMap<>();
        return helper(preorder,inorder,0,inorder.length);
    }
}