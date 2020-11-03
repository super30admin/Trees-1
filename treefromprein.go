// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
/*
if length of preorder == 0 return nil
make a map of [int]int loop through inorder and se m[element] = i
return recursive(preorder, inorder, 0,0,len(inorder), map)

in recursive function
if rootInd >- len(inorder) || startIndex >endIndex return nil
set root as current preorder[rootindex]
get location of current from inorder map
set root.left = recursive(p,i, current root +1, stindex, location -1,m)
set root.right = recursive(p,i, rootInd+location-stindex+1, location+1, endIndex,m)
*/
package main

import "fmt"

func buildTree(preorder []int, inorder []int) *TreeNode {
	if len(preorder) == 0 || len(preorder) != len(inorder) {
		return nil
	}

	m := make(map[int]int)
	for i:=0;i<len(inorder);i++ {
		m[inorder[i]] = i
	}

	return helper(preorder, inorder, 0, 0, len(inorder) - 1, m)
}

func helper(preorder, inorder []int , rootInd, stIndex, endIndex int, m map[int]int) *TreeNode {
	if rootInd >= len(inorder) || stIndex > endIndex {
		return nil
	}
	//set root
	root := &TreeNode{
		Val: preorder[rootInd],
		Left: nil,
		Right:nil,
	}

	if stIndex >= endIndex {
		return root
	}

	//search root in inorder
	inLocation := m[root.Val]

	//set left tree
	root.Left = helper(preorder, inorder, rootInd + 1, stIndex, inLocation - 1, m)
	//set right tree
	root.Right = helper(preorder, inorder, rootInd + inLocation - stIndex + 1, inLocation + 1, endIndex, m)
	return root
}

func MainTreeFromPreIn() {
	fmt.Println((buildTree([]int {3,9,20,15,7}, []int{9,3,15,20,7})).Val) // expected 3
}
