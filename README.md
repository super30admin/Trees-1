# Trees-1

## Problem 1

https://leetcode.com/problems/validate-binary-search-tree/

Given a binary tree, determine if it is a valid binary search tree (BST).

Assume a BST is defined as follows:

The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.
Example 1:

   2

   / \

  1   3

Input: [2,1,3]
Output: true
Example 2:

   5

   / \

  1   4

     / \

    3   6

Input: [5,1,4,null,null,3,6]
Output: false
Explanation: The root node's value is 5 but its right child's value is 4.

Recursive Solution:

Time Complexity: O(n)
Space Complexity: O(n)

class Solution:
    def isValidBST(self, root: TreeNode) -> bool:
        
        def helper(node, upper = float("inf"), lower = -float("inf")):
            if node:
                val = node.val
                if val>= upper or val<= lower:
                    return False
                else:
                    return helper(node.right, upper, val) and helper(node.left, val, lower)
            else:
                return True
        return helper(root, float("inf"), -float("inf"))

Iterative Solution:

Time Complexity: O(n)
Space Complexity: O(n)

class Solution:
    def isValidBST(self, root: TreeNode) -> bool:
        if not root:
            return True
        stack = [(root, float('inf'), -float('inf'))]
        
        while stack:
            curr, upper, lower = stack.pop()
            if curr.val>=upper or curr.val<=lower:
                return False
            else:
                if curr.left:
                    stack.append((curr.left, curr.val, lower))
                if curr.right:
                    stack.append((curr.right, upper, curr.val))
        return True
                
Inorder Solution:


Time Complexity: O(n)
Space Complexity: O(n)


class Solution:
    def isValidBST(self, root: TreeNode) -> bool:
        
        stack = []
        output = []
        prev = -float("inf")
        while stack or root:
            while root:
                stack.append(root)
                root = root.left
            root = stack.pop()
            if root.val<=prev:
                return False
            prev = root.val
            root = root.right

        return True
                


## Problem 2

https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/

Given preorder and inorder traversal of a tree, construct the binary tree.



Note:
You may assume that duplicates do not exist in the tree.

Can you do it both iteratively and recursively?

For example, given

preorder = [3,9,20,15,7]


inorder = [9,3,15,20,7]
Return the following binary tree:

   3


   / \


  9  20


    /  \


   15   7

Solution:
 Time = O(N)
 Space = O(N)

class Solution:
    def buildTree(self, preorder, inorder):

        index = {val:index for index, val in enumerate(inorder)}
        preIndex = 0
        def helper(left = 0, right = len(inorder)-1):
            nonlocal preIndex
            if left >right:
                return None
            
            rootVal = preorder[preIndex]
            
            root = TreeNode(rootVal)
            id = index[rootVal]
            preIndex+=1
            root.left = helper(left, id-1)
            root.right = helper(id+1, right)
            # if left == right:
            #     print(root, id, preIndex, left, right)
            
            return root
        return helper()