/**Leetcode Question - 105 - Construct Binary Tree from Preorder and Inorder */
/**Algorithm - Recursion
 * Root of the tree = First element of the preorder array
 * Find the root element in the inorder array.
 * Divide the preorder and inorder array around the root element in the preorderLeft, preorderRight
 * InorderLeft and InorderRight array using copyOfRange function (basically slicing the given arrays)
 * Build the left tree using preorderLeft and InorderLeft array
 * Build the right tree using the preorderRoght and the postOrderRight array
 */
/**TC- O(N^2)
 * SC -O()
 */
public class ConstBTFromPre&Inorder {
    class Solution {
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            if(preorder == null || preorder.length ==0){
                return null;
            }
            TreeNode root  = new TreeNode(preorder[0]);
            int index = -1;
            for(int i =0; i< inorder.length; i++){
                if(root.val == inorder[i]){
                    index = i;
                }
            }
            int[] preorderLeft = Arrays.copyOfRange(preorder,1, index+1);
            int[] preorderRight = Arrays.copyOfRange(preorder,index+1, preorder.length);
            int[] inorderLeft = Arrays.copyOfRange(inorder,0, index);
            int[] inorderRight = Arrays.copyOfRange(inorder,index+1, inorder.length);
            root.left = buildTree(preorderLeft, inorderLeft);
            root.right = buildTree(preorderRight, inorderRight);
            return root;
        }
    }
}

/**HashMap Recursion Approach
 * Build a hashMap of the inorder array so that the lookup time decreases to O(1)
 * Rest same recursion method
 */
/**TC- O(N)
 * SC- O(N)
 */
class Solution {
    HashMap<Integer, Integer> map;
    int index;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder == null || preorder.length == 0){
            return null;
        }
        map = new HashMap<>();
        for(int i =0; i<inorder.length; i++){
            map.put(inorder[i], i);
        }
        return helper(preorder, 0, preorder.length -1);
    }
    private TreeNode helper(int[] preorder, int start, int end){
        if(start > end){
            return null;
        }
        TreeNode root = new TreeNode(preorder[index]);
        index++;
        int idx = map.get(root.val);
        root.left = helper(preorder, start, idx-1);
        root.right = helper(preorder, idx+1, end);
        return root;
    }
}