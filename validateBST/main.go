

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
    - why isnt prev part of recursion stack...
    - because when the inorder goes back to a root node from left
    - the prev to this root should be left.
    - if prev is maintained with root in recursion stack, it will never be the left child.
    - therefore global prev
    - compare prev with current root
        - prev will always be smaller in a true BST ( prev in a number line thats sorted will always be smalled )
        - if prev >= current { return false }
    time: o(n)
    space: o(h)
    
*/


// inorder DFS ( recursive ) -- using prev pointer
// time: o(n) - we visit all nodes in best/worst case
// space: o(h) - max height of the tree will be in recursion stack at worse case and o(n) in a skewed tree

// func isValidBST(root *TreeNode) bool {
//     var prev *TreeNode
//     var dfs func(r *TreeNode) bool 
//     dfs = func(r *TreeNode) bool {
//         // base
//         if r == nil {return true}
        
//         // logic
//         left := dfs(r.Left)
//         if !left {return false}
        
//         if prev != nil && prev.Val >= r.Val {
//             return false
//         }
//         prev = r
//         return dfs(r.Right)
//     }
//     return dfs(root)
// }



// inorder iterative using prev ptr
// func isValidBST(root *TreeNode) bool {
//     st := []*TreeNode{}
//     var prev *TreeNode
//     // why isnt this && ? 
//     // because in inorder, we go left all the way and push each item to recursive stack
//     // so at some point root will become nil but that does not stop our recursion. Why?
//     // because each time we recursed, we pushed current node to recursive stack
//     // so our recursion keeps going while root is not nil or while st is not empty
//     for root != nil || len(st) != 0 {
        
//         // go left
//         // in inorder, we went all the left and pushed each item to stack
//         // until root became nil
//         for root != nil {
//             st = append(st, root)
//             root = root.Left
//         }
//         // once we hit the nil case in left of inorder recursion
//         // our recursion popped item out of stack, so do that
//         // and assign back to root, because our recursion stored back the previous state it was paused at
//         root = st[len(st)-1]
//         st = st[:len(st)-1]
        
//         // process root node
//         if prev != nil && prev.Val >= root.Val {return false}
//         prev = root
        
//         // go right 
//         root = root.Right
//     }
//     return true
// }

// inorder recursive using min and max
/*
    for a bst to be valid, root.left must be smaller than root and root.right must be greater than root
    
    so then left can be as little as possible.. as long as its not >= root
    and right can be as greater as possible.... as long as its not <= root
    
    left child has a max, it must not be >= root
    right child has a min, it must not be <= root
    
    when we go left, we will set a max as current root.val
    when we go right, we will set a min as current root.val
    
    initial min and max can be -inf and +inf
    
    time: o(n)
    space: o(n) worst case
*/
func isValidBST(root *TreeNode) bool {
    var dfs func(r *TreeNode, min,max int) bool
    dfs = func(r *TreeNode, min,max int)bool {
        // base
        if r == nil {return true}
        
        // logic
        if r.Val <= min || r.Val >= max {return false}
        
        left := dfs(r.Left, min, r.Val)
        if !left {return false}
        return dfs(r.Right, r.Val, max)
    }
    return dfs(root, math.MinInt64, math.MaxInt64)
}

