// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Yes, took some help from leetcode solution


// Your code here along with comments explaining your approach

Dictionary<int, int> inorderDict;
int preorderIndex;
public TreeNode BuildTree(int[] preorder, int[] inorder) {
    if(preorder == null || preorder.Length == 0 || inorder == null || inorder.Length == 0)
        return null;
    inorderDict = new Dictionary<int, int>();
    
    //save all values of inroder in dictionary
    //so that we can grab all left and right subtree based on root node value from inorder array
    //as inorder is left, root, right
    for(int i = 0; i < inorder.Length; i++)
    {
        inorderDict.Add(inorder[i], i);
    }
    
    return helper(preorder, 0, preorder.Length - 1);
}

private TreeNode helper(int[] preorder, int left, int right)
{
    if(left> right)
        return null;
    
    //get root node value from preorder array
    //as preorder array is root, left, right
    int rootValue = preorder[preorderIndex];
    preorderIndex++;
    TreeNode root = new TreeNode(rootValue);
    
    //call helper method again for left subtree, 
    //right index we can get from inorder dictionary based on root value
    root.left = helper(preorder, left, inorderDict[rootValue] -1);
    
    //call helper method again for right subtree, 
    //left index we can get from inorder dictionary based on root value
    root.right = helper(preorder, inorderDict[rootValue] + 1, right);
    
    return root;
}