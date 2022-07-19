
// Time Complexity : o(N)
// Space Complexity : O(H) 
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

//Recursive Approach
//TC O(N)
//SC O(H)
var prev *TreeNode
func isValidBST(root *TreeNode) bool {
    if root == nil{
        return false
    } 
    
    prev = nil
    return helper(root)
}

func helper(root *TreeNode) bool {

    if root == nil{
        return true
    }
    
    case1 := helper(root.Left) 
    
    if prev != nil && prev.Val >= root.Val{
        return false
    }
    
    prev = root
    
    case2 := helper(root.Right)
    
    return  case1 && case2 
}



///////////////////////////////////////////////////////////////////////////////
//Iterative Approach
//TC O(N)
//SC O(H)
var prev *TreeNode
func isValidBST(root *TreeNode) bool {
    if root == nil{
        return false
    } 
    
    stack := []*TreeNode{}
    prev = nil
    for root != nil || len(stack) > 0{
        for root != nil{
            stack = append(stack,root)
            root = root.Left
            
        }
        root = stack[len(stack)-1]
        stack = stack[:len(stack)-1]
        if prev != nil && prev.Val >= root.Val{
                return false
            }
        prev = root
        root = root.Right
    }
    
    return true
}


///////////////////////////////////////////////////////////////////////////////////////
//By min max variables
//TC - O(N)
//SC  - O(H)

func isValidBST(root *TreeNode) bool {

    var min *int = nil
    var max *int  = nil
    
    return helper(root,min,max)
}


func helper(root *TreeNode,min,max *int) bool{
    if root == nil{
        return true
    }
    
    if max != nil && root.Val >= *max{
        return false
    }
    
    if min != nil && root.Val <= *min{
        return false
    }
    
    return helper(root.Left,min,&root.Val) && helper(root.Right,&root.Val,max)
}



