// Time Complexity : O(N)
// Space Complexity : O(N) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
//TC - O(N)
// SC O(N)
var preorderindex int
var inordermap map[int]int

func buildTree(preorder []int, inorder []int) *TreeNode {
    preorderindex = 0
    inordermap = make(map[int]int)
    
    for i:=0;i<len(inorder);i++{
        inordermap[inorder[i]] = i
    }
    
    left:=0
    right := len(inorder)-1
    
    return arrayToTree(preorder,left,right)
}

func arrayToTree(preorder []int,left,right int) *TreeNode{
    if left > right{
        return nil
    }
    
    rootvalue := preorder[preorderindex]
    preorderindex+=1
    
    root := &TreeNode{}
    root.Val = rootvalue
    
    root.Left = arrayToTree(preorder,left,inordermap[rootvalue]-1)
    root.Right = arrayToTree(preorder,inordermap[rootvalue]+1,right)
    
    return root
}
