// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
/*
call recursive function with root, min as nil, max as nil

in recursive function
if root is nil then return true
if min is not nil and root value<= min value return false
if max is not nil and root value>= max value return false
return recursive(root.left, min, root) && recursive(roo.right, root, max)
*/
package main

import "fmt"

type TreeNode struct {
     Val int
     Left *TreeNode
     Right *TreeNode
}

var prev *TreeNode
func isValidBST(root *TreeNode) bool {
	return inorder(root, nil, nil)
}

func inorder(root, min, max *TreeNode) bool {
	if root == nil {
		return true
	}
	if min != nil && root.Val <= min.Val {
		return false
	}
	if max != nil && root.Val >= max.Val {
		return false
	}
	return inorder(root.Left, min, root) && inorder(root.Right, root, max)
}

func MainValidBST() {
	root := &TreeNode{
		Val: 0,
		Left: nil,
		Right: nil,
	}
	fmt.Println(isValidBST(root)) // expected true
}
