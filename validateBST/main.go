/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */


/*
    Sorted order == valid BST
    How to traverse a tree in a sorted order?
    - Inorder traversal of a BST guarentees a sorted order
    
    If you traverse a tree in inorder fashion, you will see nodes in asc order.
    
    approach 1: Populate a list while traversing inorder
    - inorder traverse
        - time: o(n) - where n is the number of nodes in the tree. We end up seeing all nodes.
        - space: o(h) - where h is the height of the tree. Regardless if we use recursion or iterative stack
    - push each item to a list
        - time: o(1)
        - space: o(n)
    - finally check if the list is sorted
        - time : o(n)
        - space : o(1)
    time: o(n) + o(1) + o(n) = o(n)
    space: o(n) + o(h) + o(1) = o(n)
    
    
    approach 2: Maintain a prev pointer to compare current root node with
    - inorder traversal
    - compare prev with current root
        - prev will always be smaller in a true BST ( prev in a number line thats sorted will always be smalled )
        - if prev >= current { return false }
    time: o(n)
    space: o(h)
    
    approach 3: Iterative implmentation of approach #2
*/

// func isValidBST(root *TreeNode) bool {
//     b := &bst{prev:nil}
//     return b.inorder(root)
// }

// // the hack class to scope global var within an instance of a class..
// // or if we expose global at main func level, than we have global pollution when multiple tests are ran
// type bst struct {
//     prev *TreeNode
// }

// func (b *bst) inorder(root *TreeNode) bool {
//     // base
//     if root == nil {
//         return true // because a nil tree is a valid BST
//     }
    
//     // logic
//     leftValid := b.inorder(root.Left)
//     // stack.Pop()
//     if !leftValid {
//         return false // no need to push more items in the recursion stack, we can exit early
//     }
    
//     if b.prev != nil {
//         if b.prev.Val >= root.Val {
//             return false
//         }
//     }
//     b.prev = root
//     return b.inorder(root.Right) // stack.Pop()
// }


// inorder iterative
// func isValidBST(root *TreeNode) bool {
//     if root == nil {
//         return true
//     }
//     var prev *TreeNode
//     stack := []*TreeNode{}
//     for root != nil || len(stack) != 0 {
//         for root != nil {
//             stack= append(stack, root)
//             root = root.Left
//         }
//         root = stack[len(stack)-1]
//         stack = stack[:len(stack)-1]
//         if prev != nil {
//             if prev.Val >= root.Val {
//                 return false
//             }
//         }
//         prev = root
//         root = root.Right
//     }
//     return true
// }


// pre-order ( processing root first and then left -> right )
func isValidBST(root *TreeNode) bool {
    return dfs(root, nil, nil)

}

// pre-order ( processing root first and then left -> right )
func dfs(root *TreeNode, min, max *TreeNode) bool {
    
    // base 
    if root == nil {return true}
    if min != nil && root.Val <= min.Val {return false}
    if max != nil && root.Val >= max.Val {return false}
    
    // logic
    return dfs(root.Left, min, root) && dfs(root.Right, root, max)
}
