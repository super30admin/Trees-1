// space complexity - o(n) - number of nodes
      //time - o(n) where n is number of nodes
      //Ran on Leetcode successfully : Yes
      // Problem faced  : No
// recursive approach : start pointer pre order that  will be root, find the element inorder, and divide inorder in two part to
                        // construct the left and right of tree.
class Solution {

    int preorderIndex = 0;

    Map<Integer, Integer> map = null;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        map = new HashMap<>();
        for(int i =0; i<inorder.length; i++){
            map.put(inorder[i], i);
        }
        return buildTree(preorder, inorder, 0, preorder.length-1);
    }

    public TreeNode buildTree(int[] preorder, int[] inorder, int start, int end) {

        if(start > end){
            return null;
        }

        TreeNode curr = new TreeNode(preorder[preorderIndex]);

        int mid = map.get(preorder[preorderIndex]);

        /*for(int i = start; i<= end; i++){
            if(inorder[i] == preorder[preorderIndex]){
                mid  = i;
                break;
            }
        }*/

        preorderIndex++;
        curr.left = buildTree(preorder, inorder, start, mid-1);
        curr.right  = buildTree(preorder, inorder, mid+1, end);
        return curr;

    }
}
