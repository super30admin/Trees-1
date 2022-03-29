/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
func buildTree(preorder []int, inorder []int) *TreeNode {
    
    if len(preorder) == 0 && len(inorder) == 0 || len(preorder) != len(inorder) {
        return nil
    }
    
    // get mid from preorder
    root := &TreeNode{Val: preorder[0]}

    // find the root in inorder list
    mid := -1
    for i := 0; i < len(inorder); i++ {
        if inorder[i] == root.Val {
            mid = i
            break
        }
    }
    
    // left of mid in inorder is the left subtree
    // right of mid in inorder is the right subtree
    
    // how do we get the same for preorder?
    // we can exclude idx 0 from pre as it is the root, it will never be a subtree
    // the mid idx in inorder tells us the end position of preorder in preorder list
    // that means, that preorder[1:mid+1] is the left of preorder
    // that means, that preorder[mid+1:] is the right of preorder
    // that means, that inorder[0:mid] is the left of inorder
    // that means, that inorder[mid+1:] is the right of inorder
    root.Left = buildTree(preorder[1:mid+1], inorder[0:mid])
    root.Right = buildTree(preorder[mid+1:], inorder[mid+1:])
    return root
}
