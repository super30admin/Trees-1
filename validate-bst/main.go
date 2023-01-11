package main

/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */

// Time : O(n) : where n is height and worst case its a skewed tree and we traverse to left or right of the tree
// Space : O(1)
func isValidBST(root *TreeNode) bool {
	return helper(root)
}

var prev *TreeNode

func helper(root *TreeNode) bool {

	//base
	if root == nil {
		return true
	}
	//left

	isLeftValidBST := helper(root.Left)
	if prev != nil && prev.Val >= root.Val {
		//leftBST := false
		return false
	}
	prev = root
	//right
	isRightValidBST := helper(root.Right)

	//fmt.Println(root.Val,isLeftValidBST,isRightValidBST)
	if isLeftValidBST == false || isRightValidBST == false {
		return false
	}

	return true
}
