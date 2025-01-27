// Time Complexity : O(n)
// Space Complexity : O(n) + O(h) = O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

public class Problem2 {
    //This will store the values of inorder array with the index , so we can find the index for root in here with O(1)
    HashMap<Integer,Integer> inOrderMap;
    //This will iterate over preorder array which will give the root value.
    int preOrderIdx;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder == null || preorder.length == 0 || inorder.length == 0){
            return null;
        }
        preOrderIdx = 0;
        inOrderMap = new HashMap<>();
        for(int i =0 ;i<inorder.length;i++){
            inOrderMap.put(inorder[i],i);
        }
        return createTree(preorder,0,inorder.length-1);
    }

    private TreeNode createTree(int[] preorder, int start, int end){
        //base
        if(start > end){
            //this means all the value to the left or right sub tree completed.
            return null;
        }
        //logic
        //1. Find the root value
        int rootVal = preorder[preOrderIdx];
        //2. Increase the index for next root val
        preOrderIdx++;
        //3. Create the treeNode
        TreeNode root = new TreeNode(rootVal);
        //4. Find the index of root val in inorder map to get the left and right sub tree
        int rootIdx = inOrderMap.get(rootVal);
        //5. Recursive call to create the left and right sub tree with updated start and end index
        root.left = createTree(preorder,start,rootIdx-1);
        root.right = createTree(preorder,rootIdx+1,end);

        return root;
    }
}
