// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/*
 * We maintain a map with elements of inorder along with their position. 
 * We check if start is greater than end and return null if yes. 
 * We put the first element as root from preorder array. 
 * We run helper functions with preorder and values of start and end for inorder so we don't have to run two loops. 
 *  
 */


public class Problem2 {
    HashMap<Integer, Integer> map;
    int preIdx;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.map = new HashMap<>();
        for(int i =0; i < inorder.length;i++){
            map.put(inorder[i],i);
        }
        return helper(preorder, 0, inorder.length-1);
    }
    private TreeNode helper(int preorder[],int start, int end){
        if (start > end) return null; 
        int rootVal = preorder[preIdx];
        preIdx++;
        int rootIdx = map.get(rootVal);
        TreeNode root = new TreeNode(rootVal);
        root.left = helper(preorder, start, rootIdx-1);
        root.right = helper(preorder, rootIdx+1,end);
        return root; 
    }
}
