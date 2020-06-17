/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     public var val: Int
 *     public var left: TreeNode?
 *     public var right: TreeNode?
 *     public init(_ val: Int) {
 *         self.val = val
 *         self.left = nil
 *         self.right = nil
 *     }
 * }
 */
// Time Complexity : O(n) number of nodes
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach
//Recursive approachusing inorder traversal. Inorder traversal return sorted array so compare previous and currently visited val whether current is greater than previous value. make sure to return false while traversing in the left node

class Solution {
    var prev: TreeNode? = nil
    func isValidBST(_ root: TreeNode?) -> Bool {
        return inOrder(root)
    }
    
     func inOrder(_ root:TreeNode?) ->Bool{
        if root == nil {
            return true
        }
        
        if !inOrder(root?.left) {
            return false
        }
         
        if prev != nil && prev!.val >= root!.val {
            return false
        }
        prev = root
        return inOrder(root?.right) 
     }
    
  
}

// Time Complexity : O(n) Number of nodes
// Space Complexity : O(h) h is the height of the tree
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : missed prev = root assignment

// Your code here along with comments explaining your approach
//iterative appoach using stack inorder traversal. Inorder traversal return sorted array so compare previous and currently visited val whether current is greater than previous value. make sure to return false while traversing in the left node

class Solution {
    var prev: TreeNode? = nil
    func isValidBST(_ rootNode: TreeNode?) -> Bool {
        var prev:TreeNode? = nil
        var stack:[TreeNode] = [TreeNode]()
        var root = rootNode
        while root != nil || !stack.isEmpty {
            while root != nil {
                stack.append(root!)
                root = root?.left
            }
            root = stack.popLast()
            if prev != nil && prev!.val >= root!.val {
                return false
            }
            prev = root
            root = root?.right
        }
        return true
    }
    
}